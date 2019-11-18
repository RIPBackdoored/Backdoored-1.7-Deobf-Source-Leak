package com.google.api.client.http;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.escape.CharEscapers;
import com.google.api.client.util.escape.Escaper;
import com.google.api.client.util.escape.PercentEscaper;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Map.Entry;

public class GenericUrl extends GenericData {
   private static final Escaper URI_FRAGMENT_ESCAPER = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
   private String scheme;
   private String host;
   private String userInfo;
   private int port;
   private List pathParts;
   private String fragment;

   public GenericUrl() {
      this.port = -1;
   }

   public GenericUrl(String encodedUrl) {
      this(parseURL(encodedUrl));
   }

   public GenericUrl(URI uri) {
      this(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getRawPath(), uri.getRawFragment(), uri.getRawQuery(), uri.getRawUserInfo());
   }

   public GenericUrl(URL url) {
      this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
   }

   private GenericUrl(String scheme, String host, int port, String path, String fragment, String query, String userInfo) {
      this.port = -1;
      this.scheme = scheme.toLowerCase(Locale.US);
      this.host = host;
      this.port = port;
      this.pathParts = toPathParts(path);
      this.fragment = fragment != null ? CharEscapers.decodeUri(fragment) : null;
      if (query != null) {
         UrlEncodedParser.parse((String)query, this);
      }

      this.userInfo = userInfo != null ? CharEscapers.decodeUri(userInfo) : null;
   }

   public int hashCode() {
      return this.build().hashCode();
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (super.equals(obj) && obj instanceof GenericUrl) {
         GenericUrl other = (GenericUrl)obj;
         return this.build().equals(other.build());
      } else {
         return false;
      }
   }

   public String toString() {
      return this.build();
   }

   public GenericUrl clone() {
      GenericUrl result = (GenericUrl)super.clone();
      if (this.pathParts != null) {
         result.pathParts = new ArrayList(this.pathParts);
      }

      return result;
   }

   public GenericUrl set(String fieldName, Object value) {
      return (GenericUrl)super.set(fieldName, value);
   }

   public final String getScheme() {
      return this.scheme;
   }

   public final void setScheme(String scheme) {
      this.scheme = (String)Preconditions.checkNotNull(scheme);
   }

   public String getHost() {
      return this.host;
   }

   public final void setHost(String host) {
      this.host = (String)Preconditions.checkNotNull(host);
   }

   public final String getUserInfo() {
      return this.userInfo;
   }

   public final void setUserInfo(String userInfo) {
      this.userInfo = userInfo;
   }

   public int getPort() {
      return this.port;
   }

   public final void setPort(int port) {
      Preconditions.checkArgument(port >= -1, "expected port >= -1");
      this.port = port;
   }

   public List getPathParts() {
      return this.pathParts;
   }

   public void setPathParts(List pathParts) {
      this.pathParts = pathParts;
   }

   public String getFragment() {
      return this.fragment;
   }

   public final void setFragment(String fragment) {
      this.fragment = fragment;
   }

   public final String build() {
      return this.buildAuthority() + this.buildRelativeUrl();
   }

   public final String buildAuthority() {
      StringBuilder buf = new StringBuilder();
      buf.append((String)Preconditions.checkNotNull(this.scheme));
      buf.append("://");
      if (this.userInfo != null) {
         buf.append(CharEscapers.escapeUriUserInfo(this.userInfo)).append('@');
      }

      buf.append((String)Preconditions.checkNotNull(this.host));
      int port = this.port;
      if (port != -1) {
         buf.append(':').append(port);
      }

      return buf.toString();
   }

   public final String buildRelativeUrl() {
      StringBuilder buf = new StringBuilder();
      if (this.pathParts != null) {
         this.appendRawPathFromParts(buf);
      }

      addQueryParams(this.entrySet(), buf);
      String fragment = this.fragment;
      if (fragment != null) {
         buf.append('#').append(URI_FRAGMENT_ESCAPER.escape(fragment));
      }

      return buf.toString();
   }

   public final URI toURI() {
      return toURI(this.build());
   }

   public final URL toURL() {
      return parseURL(this.build());
   }

   public final URL toURL(String relativeUrl) {
      URL var10000;
      try {
         URL url = this.toURL();
         var10000 = new URL(url, relativeUrl);
      } catch (MalformedURLException var3) {
         throw new IllegalArgumentException(var3);
      }

      return var10000;
   }

   public Object getFirst(String name) {
      Object value = this.get(name);
      if (value instanceof Collection) {
         Collection collectionValue = (Collection)value;
         Iterator iterator = collectionValue.iterator();
         return iterator.hasNext() ? iterator.next() : null;
      } else {
         return value;
      }
   }

   public Collection getAll(String name) {
      Object value = this.get(name);
      if (value == null) {
         return Collections.emptySet();
      } else if (value instanceof Collection) {
         Collection collectionValue = (Collection)value;
         return Collections.unmodifiableCollection(collectionValue);
      } else {
         return Collections.singleton(value);
      }
   }

   public String getRawPath() {
      List pathParts = this.pathParts;
      if (pathParts == null) {
         return null;
      } else {
         StringBuilder buf = new StringBuilder();
         this.appendRawPathFromParts(buf);
         return buf.toString();
      }
   }

   public void setRawPath(String encodedPath) {
      this.pathParts = toPathParts(encodedPath);
   }

   public void appendRawPath(String encodedPath) {
      if (encodedPath != null && encodedPath.length() != 0) {
         List appendedPathParts = toPathParts(encodedPath);
         if (this.pathParts != null && !this.pathParts.isEmpty()) {
            int size = this.pathParts.size();
            this.pathParts.set(size - 1, (String)this.pathParts.get(size - 1) + (String)appendedPathParts.get(0));
            this.pathParts.addAll(appendedPathParts.subList(1, appendedPathParts.size()));
         } else {
            this.pathParts = appendedPathParts;
         }
      }

   }

   public static List toPathParts(String encodedPath) {
      if (encodedPath != null && encodedPath.length() != 0) {
         List result = new ArrayList();
         int cur = 0;

         int slash;
         for(boolean notDone = true; notDone; cur = slash + 1) {
            slash = encodedPath.indexOf(47, cur);
            notDone = slash != -1;
            String sub;
            if (notDone) {
               sub = encodedPath.substring(cur, slash);
            } else {
               sub = encodedPath.substring(cur);
            }

            result.add(CharEscapers.decodeUri(sub));
         }

         return result;
      } else {
         return null;
      }
   }

   private void appendRawPathFromParts(StringBuilder buf) {
      int size = this.pathParts.size();

      for(int i = 0; i < size; ++i) {
         String pathPart = (String)this.pathParts.get(i);
         if (i != 0) {
            buf.append('/');
         }

         if (pathPart.length() != 0) {
            buf.append(CharEscapers.escapeUriPath(pathPart));
         }
      }

   }

   static void addQueryParams(Set entrySet, StringBuilder buf) {
      boolean first = true;
      Iterator var3 = entrySet.iterator();

      while(true) {
         while(true) {
            Entry nameValueEntry;
            Object value;
            do {
               if (!var3.hasNext()) {
                  return;
               }

               nameValueEntry = (Entry)var3.next();
               value = nameValueEntry.getValue();
            } while(value == null);

            String name = CharEscapers.escapeUriQuery((String)nameValueEntry.getKey());
            if (value instanceof Collection) {
               Collection collectionValue = (Collection)value;

               Object repeatedValue;
               for(Iterator var8 = collectionValue.iterator(); var8.hasNext(); first = appendParam(first, buf, name, repeatedValue)) {
                  repeatedValue = var8.next();
               }
            } else {
               first = appendParam(first, buf, name, value);
            }
         }
      }
   }

   private static boolean appendParam(boolean first, StringBuilder buf, String name, Object value) {
      if (first) {
         first = false;
         buf.append('?');
      } else {
         buf.append('&');
      }

      buf.append(name);
      String stringValue = CharEscapers.escapeUriQuery(value.toString());
      if (stringValue.length() != 0) {
         buf.append('=').append(stringValue);
      }

      return first;
   }

   private static URI toURI(String encodedUrl) {
      URI var10000;
      try {
         var10000 = new URI(encodedUrl);
      } catch (URISyntaxException var2) {
         throw new IllegalArgumentException(var2);
      }

      return var10000;
   }

   private static URL parseURL(String encodedUrl) {
      URL var10000;
      try {
         var10000 = new URL(encodedUrl);
      } catch (MalformedURLException var2) {
         throw new IllegalArgumentException(var2);
      }

      return var10000;
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData clone() {
      return this.clone();
   }

   // $FF: synthetic method
   // $FF: bridge method
   public GenericData set(String var1, Object var2) {
      return this.set(var1, var2);
   }

   // $FF: synthetic method
   // $FF: bridge method
   public Object clone() throws CloneNotSupportedException {
      return this.clone();
   }
}
