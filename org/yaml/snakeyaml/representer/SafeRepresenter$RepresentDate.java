package org.yaml.snakeyaml.representer;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;

public class SafeRepresenter$RepresentDate implements Represent {
   // $FF: synthetic field
   final SafeRepresenter this$0;

   protected SafeRepresenter$RepresentDate(SafeRepresenter this$0) {
      this.this$0 = this$0;
   }

   public Node representData(Object data) {
      Calendar calendar;
      if (data instanceof Calendar) {
         calendar = (Calendar)data;
      } else {
         calendar = Calendar.getInstance(this.this$0.getTimeZone() == null ? TimeZone.getTimeZone("UTC") : this.this$0.timeZone);
         calendar.setTime((Date)data);
      }

      int years = calendar.get(1);
      int months = calendar.get(2) + 1;
      int days = calendar.get(5);
      int hour24 = calendar.get(11);
      int minutes = calendar.get(12);
      int seconds = calendar.get(13);
      int millis = calendar.get(14);
      StringBuilder buffer = new StringBuilder(String.valueOf(years));

      while(buffer.length() < 4) {
         buffer.insert(0, "0");
      }

      buffer.append("-");
      if (months < 10) {
         buffer.append("0");
      }

      buffer.append(String.valueOf(months));
      buffer.append("-");
      if (days < 10) {
         buffer.append("0");
      }

      buffer.append(String.valueOf(days));
      buffer.append("T");
      if (hour24 < 10) {
         buffer.append("0");
      }

      buffer.append(String.valueOf(hour24));
      buffer.append(":");
      if (minutes < 10) {
         buffer.append("0");
      }

      buffer.append(String.valueOf(minutes));
      buffer.append(":");
      if (seconds < 10) {
         buffer.append("0");
      }

      buffer.append(String.valueOf(seconds));
      if (millis > 0) {
         if (millis < 10) {
            buffer.append(".00");
         } else if (millis < 100) {
            buffer.append(".0");
         } else {
            buffer.append(".");
         }

         buffer.append(String.valueOf(millis));
      }

      int gmtOffset = calendar.getTimeZone().getOffset(calendar.get(0), calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), calendar.get(14));
      if (gmtOffset == 0) {
         buffer.append('Z');
      } else {
         if (gmtOffset < 0) {
            buffer.append('-');
            gmtOffset *= -1;
         } else {
            buffer.append('+');
         }

         int minutesOffset = gmtOffset / '\uea60';
         int hoursOffset = minutesOffset / 60;
         int partOfHour = minutesOffset % 60;
         if (hoursOffset < 10) {
            buffer.append('0');
         }

         buffer.append(hoursOffset);
         buffer.append(':');
         if (partOfHour < 10) {
            buffer.append('0');
         }

         buffer.append(partOfHour);
      }

      return this.this$0.representScalar(this.this$0.getTag(data.getClass(), Tag.TIMESTAMP), buffer.toString(), (Character)null);
   }
}
