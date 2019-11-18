package org.yaml.snakeyaml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.composer.Composer;
import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.emitter.Emitter;
import org.yaml.snakeyaml.error.YAMLException;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.parser.Parser;
import org.yaml.snakeyaml.parser.ParserImpl;
import org.yaml.snakeyaml.reader.StreamReader;
import org.yaml.snakeyaml.reader.UnicodeReader;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;
import org.yaml.snakeyaml.serializer.Serializer;

public class Yaml {
   protected final Resolver resolver;
   private String name;
   protected BaseConstructor constructor;
   protected Representer representer;
   protected DumperOptions dumperOptions;
   protected LoaderOptions loadingConfig;

   public Yaml() {
      this(new Constructor(), new Representer(), new DumperOptions(), new LoaderOptions(), new Resolver());
   }

   public Yaml(DumperOptions dumperOptions) {
      this(new Constructor(), new Representer(), dumperOptions);
   }

   public Yaml(LoaderOptions loadingConfig) {
      this(new Constructor(), new Representer(), new DumperOptions(), (LoaderOptions)loadingConfig);
   }

   public Yaml(Representer representer) {
      this((BaseConstructor)(new Constructor()), (Representer)representer);
   }

   public Yaml(BaseConstructor constructor) {
      this(constructor, new Representer());
   }

   public Yaml(BaseConstructor constructor, Representer representer) {
      this(constructor, representer, initDumperOptions(representer));
   }

   private static DumperOptions initDumperOptions(Representer representer) {
      DumperOptions dumperOptions = new DumperOptions();
      dumperOptions.setDefaultFlowStyle(representer.getDefaultFlowStyle());
      dumperOptions.setDefaultScalarStyle(representer.getDefaultScalarStyle());
      dumperOptions.setAllowReadOnlyProperties(representer.getPropertyUtils().isAllowReadOnlyProperties());
      dumperOptions.setTimeZone(representer.getTimeZone());
      return dumperOptions;
   }

   public Yaml(Representer representer, DumperOptions dumperOptions) {
      this(new Constructor(), representer, dumperOptions, new LoaderOptions(), new Resolver());
   }

   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions) {
      this(constructor, representer, dumperOptions, new LoaderOptions(), new Resolver());
   }

   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions, LoaderOptions loadingConfig) {
      this(constructor, representer, dumperOptions, loadingConfig, new Resolver());
   }

   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions, Resolver resolver) {
      this(constructor, representer, dumperOptions, new LoaderOptions(), resolver);
   }

   public Yaml(BaseConstructor constructor, Representer representer, DumperOptions dumperOptions, LoaderOptions loadingConfig, Resolver resolver) {
      if (!constructor.isExplicitPropertyUtils()) {
         constructor.setPropertyUtils(representer.getPropertyUtils());
      } else if (!representer.isExplicitPropertyUtils()) {
         representer.setPropertyUtils(constructor.getPropertyUtils());
      }

      this.constructor = constructor;
      this.constructor.setAllowDuplicateKeys(loadingConfig.isAllowDuplicateKeys());
      if (dumperOptions.getIndent() <= dumperOptions.getIndicatorIndent()) {
         throw new YAMLException("Indicator indent must be smaller then indent.");
      } else {
         representer.setDefaultFlowStyle(dumperOptions.getDefaultFlowStyle());
         representer.setDefaultScalarStyle(dumperOptions.getDefaultScalarStyle());
         representer.getPropertyUtils().setAllowReadOnlyProperties(dumperOptions.isAllowReadOnlyProperties());
         representer.setTimeZone(dumperOptions.getTimeZone());
         this.representer = representer;
         this.dumperOptions = dumperOptions;
         this.loadingConfig = loadingConfig;
         this.resolver = resolver;
         this.name = "Yaml:" + System.identityHashCode(this);
      }
   }

   public String dump(Object data) {
      List list = new ArrayList(1);
      list.add(data);
      return this.dumpAll(list.iterator());
   }

   public Node represent(Object data) {
      return this.representer.represent(data);
   }

   public String dumpAll(Iterator data) {
      StringWriter buffer = new StringWriter();
      this.dumpAll(data, buffer, (Tag)null);
      return buffer.toString();
   }

   public void dump(Object data, Writer output) {
      List list = new ArrayList(1);
      list.add(data);
      this.dumpAll(list.iterator(), output, (Tag)null);
   }

   public void dumpAll(Iterator data, Writer output) {
      this.dumpAll(data, output, (Tag)null);
   }

   private void dumpAll(Iterator data, Writer output, Tag rootTag) {
      Serializer serializer = new Serializer(new Emitter(output, this.dumperOptions), this.resolver, this.dumperOptions, rootTag);

      try {
         serializer.open();

         while(data.hasNext()) {
            Node node = this.representer.represent(data.next());
            serializer.serialize(node);
         }

         serializer.close();
      } catch (IOException var6) {
         throw new YAMLException(var6);
      }
   }

   public String dumpAs(Object data, Tag rootTag, DumperOptions$FlowStyle flowStyle) {
      DumperOptions$FlowStyle oldStyle = this.representer.getDefaultFlowStyle();
      if (flowStyle != null) {
         this.representer.setDefaultFlowStyle(flowStyle);
      }

      List list = new ArrayList(1);
      list.add(data);
      StringWriter buffer = new StringWriter();
      this.dumpAll(list.iterator(), buffer, rootTag);
      this.representer.setDefaultFlowStyle(oldStyle);
      return buffer.toString();
   }

   public String dumpAsMap(Object data) {
      return this.dumpAs(data, Tag.MAP, DumperOptions$FlowStyle.BLOCK);
   }

   public List serialize(Node data) {
      Yaml$SilentEmitter emitter = new Yaml$SilentEmitter((Yaml$1)null);
      Serializer serializer = new Serializer(emitter, this.resolver, this.dumperOptions, (Tag)null);

      try {
         serializer.open();
         serializer.serialize(data);
         serializer.close();
      } catch (IOException var5) {
         throw new YAMLException(var5);
      }

      return emitter.getEvents();
   }

   public Object load(String yaml) {
      return this.loadFromReader(new StreamReader(yaml), Object.class);
   }

   public Object load(InputStream io) {
      return this.loadFromReader(new StreamReader(new UnicodeReader(io)), Object.class);
   }

   public Object load(Reader io) {
      return this.loadFromReader(new StreamReader(io), Object.class);
   }

   public Object loadAs(Reader io, Class type) {
      return this.loadFromReader(new StreamReader(io), type);
   }

   public Object loadAs(String yaml, Class type) {
      return this.loadFromReader(new StreamReader(yaml), type);
   }

   public Object loadAs(InputStream input, Class type) {
      return this.loadFromReader(new StreamReader(new UnicodeReader(input)), type);
   }

   private Object loadFromReader(StreamReader sreader, Class type) {
      Composer composer = new Composer(new ParserImpl(sreader), this.resolver);
      this.constructor.setComposer(composer);
      return this.constructor.getSingleData(type);
   }

   public Iterable loadAll(Reader yaml) {
      Composer composer = new Composer(new ParserImpl(new StreamReader(yaml)), this.resolver);
      this.constructor.setComposer(composer);
      Iterator result = new Yaml$1(this);
      return new Yaml$YamlIterable(result);
   }

   public Iterable loadAll(String yaml) {
      return this.loadAll((Reader)(new StringReader(yaml)));
   }

   public Iterable loadAll(InputStream yaml) {
      return this.loadAll((Reader)(new UnicodeReader(yaml)));
   }

   public Node compose(Reader yaml) {
      Composer composer = new Composer(new ParserImpl(new StreamReader(yaml)), this.resolver);
      this.constructor.setComposer(composer);
      return composer.getSingleNode();
   }

   public Iterable composeAll(Reader yaml) {
      Composer composer = new Composer(new ParserImpl(new StreamReader(yaml)), this.resolver);
      this.constructor.setComposer(composer);
      Iterator result = new Yaml$2(this, composer);
      return new Yaml$NodeIterable(result);
   }

   public void addImplicitResolver(Tag tag, Pattern regexp, String first) {
      this.resolver.addImplicitResolver(tag, regexp, first);
   }

   public String toString() {
      return this.name;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Iterable parse(Reader yaml) {
      Parser parser = new ParserImpl(new StreamReader(yaml));
      Iterator result = new Yaml$3(this, parser);
      return new Yaml$EventIterable(result);
   }

   public void setBeanAccess(BeanAccess beanAccess) {
      this.constructor.getPropertyUtils().setBeanAccess(beanAccess);
      this.representer.getPropertyUtils().setBeanAccess(beanAccess);
   }

   public void addTypeDescription(TypeDescription td) {
      this.constructor.addTypeDescription(td);
      this.representer.addTypeDescription(td);
   }
}
