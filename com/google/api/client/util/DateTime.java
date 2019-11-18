package com.google.api.client.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DateTime implements Serializable {
   private static final long serialVersionUID = 1L;
   private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
   private static final Pattern RFC3339_PATTERN = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");
   private final long value;
   private final boolean dateOnly;
   private final int tzShift;

   public DateTime(Date date, TimeZone zone) {
      this(false, date.getTime(), zone == null ? null : zone.getOffset(date.getTime()) / '\uea60');
   }

   public DateTime(long value) {
      this(false, value, (Integer)null);
   }

   public DateTime(Date value) {
      this(value.getTime());
   }

   public DateTime(long value, int tzShift) {
      this(false, value, tzShift);
   }

   public DateTime(boolean dateOnly, long value, Integer tzShift) {
      this.dateOnly = dateOnly;
      this.value = value;
      this.tzShift = dateOnly ? 0 : (tzShift == null ? TimeZone.getDefault().getOffset(value) / '\uea60' : tzShift);
   }

   public DateTime(String value) {
      DateTime dateTime = parseRfc3339(value);
      this.dateOnly = dateTime.dateOnly;
      this.value = dateTime.value;
      this.tzShift = dateTime.tzShift;
   }

   public long getValue() {
      return this.value;
   }

   public boolean isDateOnly() {
      return this.dateOnly;
   }

   public int getTimeZoneShift() {
      return this.tzShift;
   }

   public String toStringRfc3339() {
      StringBuilder sb = new StringBuilder();
      Calendar dateTime = new GregorianCalendar(GMT);
      long localTime = this.value + (long)this.tzShift * 60000L;
      dateTime.setTimeInMillis(localTime);
      appendInt(sb, dateTime.get(1), 4);
      sb.append('-');
      appendInt(sb, dateTime.get(2) + 1, 2);
      sb.append('-');
      appendInt(sb, dateTime.get(5), 2);
      if (!this.dateOnly) {
         sb.append('T');
         appendInt(sb, dateTime.get(11), 2);
         sb.append(':');
         appendInt(sb, dateTime.get(12), 2);
         sb.append(':');
         appendInt(sb, dateTime.get(13), 2);
         if (dateTime.isSet(14)) {
            sb.append('.');
            appendInt(sb, dateTime.get(14), 3);
         }

         if (this.tzShift == 0) {
            sb.append('Z');
         } else {
            int absTzShift = this.tzShift;
            if (this.tzShift > 0) {
               sb.append('+');
            } else {
               sb.append('-');
               absTzShift = -absTzShift;
            }

            int tzHours = absTzShift / 60;
            int tzMinutes = absTzShift % 60;
            appendInt(sb, tzHours, 2);
            sb.append(':');
            appendInt(sb, tzMinutes, 2);
         }
      }

      return sb.toString();
   }

   public String toString() {
      return this.toStringRfc3339();
   }

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DateTime)) {
         return false;
      } else {
         DateTime other = (DateTime)o;
         return this.dateOnly == other.dateOnly && this.value == other.value && this.tzShift == other.tzShift;
      }
   }

   public int hashCode() {
      return Arrays.hashCode(new long[]{this.value, this.dateOnly ? 1L : 0L, (long)this.tzShift});
   }

   public static DateTime parseRfc3339(String str) throws NumberFormatException {
      Matcher matcher = RFC3339_PATTERN.matcher(str);
      if (!matcher.matches()) {
         throw new NumberFormatException("Invalid date/time format: " + str);
      } else {
         int year = Integer.parseInt(matcher.group(1));
         int month = Integer.parseInt(matcher.group(2)) - 1;
         int day = Integer.parseInt(matcher.group(3));
         boolean isTimeGiven = matcher.group(4) != null;
         String tzShiftRegexGroup = matcher.group(9);
         boolean isTzShiftGiven = tzShiftRegexGroup != null;
         int hourOfDay = 0;
         int minute = 0;
         int second = 0;
         int milliseconds = 0;
         Integer tzShiftInteger = null;
         if (isTzShiftGiven && !isTimeGiven) {
            throw new NumberFormatException("Invalid date/time format, cannot specify time zone shift without specifying time: " + str);
         } else {
            if (isTimeGiven) {
               hourOfDay = Integer.parseInt(matcher.group(5));
               minute = Integer.parseInt(matcher.group(6));
               second = Integer.parseInt(matcher.group(7));
               if (matcher.group(8) != null) {
                  milliseconds = Integer.parseInt(matcher.group(8).substring(1));
                  int fractionDigits = matcher.group(8).substring(1).length() - 3;
                  milliseconds = (int)((double)((float)milliseconds) / Math.pow(10.0D, (double)fractionDigits));
               }
            }

            Calendar dateTime = new GregorianCalendar(GMT);
            dateTime.set(year, month, day, hourOfDay, minute, second);
            dateTime.set(14, milliseconds);
            long value = dateTime.getTimeInMillis();
            if (isTimeGiven && isTzShiftGiven) {
               int tzShift;
               if (Character.toUpperCase(tzShiftRegexGroup.charAt(0)) == 'Z') {
                  tzShift = 0;
               } else {
                  tzShift = Integer.parseInt(matcher.group(11)) * 60 + Integer.parseInt(matcher.group(12));
                  if (matcher.group(10).charAt(0) == '-') {
                     tzShift = -tzShift;
                  }

                  value -= (long)tzShift * 60000L;
               }

               tzShiftInteger = tzShift;
            }

            return new DateTime(!isTimeGiven, value, tzShiftInteger);
         }
      }
   }

   private static void appendInt(StringBuilder sb, int num, int numDigits) {
      if (num < 0) {
         sb.append('-');
         num = -num;
      }

      for(int x = num; x > 0; --numDigits) {
         x /= 10;
      }

      for(int i = 0; i < numDigits; ++i) {
         sb.append('0');
      }

      if (num != 0) {
         sb.append(num);
      }

   }
}
