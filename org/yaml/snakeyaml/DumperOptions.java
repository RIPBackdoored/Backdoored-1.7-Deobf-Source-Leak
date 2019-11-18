package org.yaml.snakeyaml;

import java.util.Map;
import java.util.TimeZone;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.serializer.AnchorGenerator;
import org.yaml.snakeyaml.serializer.NumberAnchorGenerator;

public class DumperOptions {
   private DumperOptions$ScalarStyle defaultStyle;
   private DumperOptions$FlowStyle defaultFlowStyle;
   private boolean canonical;
   private boolean allowUnicode;
   private boolean allowReadOnlyProperties;
   private int indent;
   private int indicatorIndent;
   private int bestWidth;
   private boolean splitLines;
   private DumperOptions$LineBreak lineBreak;
   private boolean explicitStart;
   private boolean explicitEnd;
   private TimeZone timeZone;
   private DumperOptions$Version version;
   private Map tags;
   private Boolean prettyFlow;
   private AnchorGenerator anchorGenerator;

   public DumperOptions() {
      this.defaultStyle = DumperOptions$ScalarStyle.PLAIN;
      this.defaultFlowStyle = DumperOptions$FlowStyle.AUTO;
      this.canonical = false;
      this.allowUnicode = true;
      this.allowReadOnlyProperties = false;
      this.indent = 2;
      this.indicatorIndent = 0;
      this.bestWidth = 80;
      this.splitLines = true;
      this.lineBreak = DumperOptions$LineBreak.UNIX;
      this.explicitStart = false;
      this.explicitEnd = false;
      this.timeZone = null;
      this.version = null;
      this.tags = null;
      this.prettyFlow = false;
      this.anchorGenerator = new NumberAnchorGenerator(0);
   }

   public boolean isAllowUnicode() {
      return this.allowUnicode;
   }

   public void setAllowUnicode(boolean allowUnicode) {
      this.allowUnicode = allowUnicode;
   }

   public DumperOptions$ScalarStyle getDefaultScalarStyle() {
      return this.defaultStyle;
   }

   public void setDefaultScalarStyle(DumperOptions$ScalarStyle defaultStyle) {
      if (defaultStyle == null) {
         throw new NullPointerException("Use ScalarStyle enum.");
      } else {
         this.defaultStyle = defaultStyle;
      }
   }

   public void setIndent(int indent) {
      if (indent < 1) {
         throw new YAMLException("Indent must be at least 1");
      } else if (indent > 10) {
         throw new YAMLException("Indent must be at most 10");
      } else {
         this.indent = indent;
      }
   }

   public int getIndent() {
      return this.indent;
   }

   public void setIndicatorIndent(int indicatorIndent) {
      if (indicatorIndent < 0) {
         throw new YAMLException("Indicator indent must be non-negative.");
      } else if (indicatorIndent > 9) {
         throw new YAMLException("Indicator indent must be at most Emitter.MAX_INDENT-1: 9");
      } else {
         this.indicatorIndent = indicatorIndent;
      }
   }

   public int getIndicatorIndent() {
      return this.indicatorIndent;
   }

   public void setVersion(DumperOptions$Version version) {
      this.version = version;
   }

   public DumperOptions$Version getVersion() {
      return this.version;
   }

   public void setCanonical(boolean canonical) {
      this.canonical = canonical;
   }

   public boolean isCanonical() {
      return this.canonical;
   }

   public void setPrettyFlow(boolean prettyFlow) {
      this.prettyFlow = prettyFlow;
   }

   public boolean isPrettyFlow() {
      return this.prettyFlow;
   }

   public void setWidth(int bestWidth) {
      this.bestWidth = bestWidth;
   }

   public int getWidth() {
      return this.bestWidth;
   }

   public void setSplitLines(boolean splitLines) {
      this.splitLines = splitLines;
   }

   public boolean getSplitLines() {
      return this.splitLines;
   }

   public DumperOptions$LineBreak getLineBreak() {
      return this.lineBreak;
   }

   public void setDefaultFlowStyle(DumperOptions$FlowStyle defaultFlowStyle) {
      if (defaultFlowStyle == null) {
         throw new NullPointerException("Use FlowStyle enum.");
      } else {
         this.defaultFlowStyle = defaultFlowStyle;
      }
   }

   public DumperOptions$FlowStyle getDefaultFlowStyle() {
      return this.defaultFlowStyle;
   }

   public void setLineBreak(DumperOptions$LineBreak lineBreak) {
      if (lineBreak == null) {
         throw new NullPointerException("Specify line break.");
      } else {
         this.lineBreak = lineBreak;
      }
   }

   public boolean isExplicitStart() {
      return this.explicitStart;
   }

   public void setExplicitStart(boolean explicitStart) {
      this.explicitStart = explicitStart;
   }

   public boolean isExplicitEnd() {
      return this.explicitEnd;
   }

   public void setExplicitEnd(boolean explicitEnd) {
      this.explicitEnd = explicitEnd;
   }

   public Map getTags() {
      return this.tags;
   }

   public void setTags(Map tags) {
      this.tags = tags;
   }

   public boolean isAllowReadOnlyProperties() {
      return this.allowReadOnlyProperties;
   }

   public void setAllowReadOnlyProperties(boolean allowReadOnlyProperties) {
      this.allowReadOnlyProperties = allowReadOnlyProperties;
   }

   public TimeZone getTimeZone() {
      return this.timeZone;
   }

   public void setTimeZone(TimeZone timeZone) {
      this.timeZone = timeZone;
   }

   public AnchorGenerator getAnchorGenerator() {
      return this.anchorGenerator;
   }

   public void setAnchorGenerator(AnchorGenerator anchorGenerator) {
      this.anchorGenerator = anchorGenerator;
   }
}
