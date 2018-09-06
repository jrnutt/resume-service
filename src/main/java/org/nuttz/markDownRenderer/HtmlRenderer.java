package org.nuttz.markDownRenderer;

import java.io.FileReader;
import java.io.File;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.parser.Parser;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.OutputStream;

/**
 * Renders a markdown file as HTML
 * Basically a wrapper around the flexmark renderer.
 *
 * Created: Tue Sep  4 14:36:38 2018
 *
 * @author <a href="mailto:jim@nuttz.org">Jim Nutt</a>
 * @version 1.0
 */
public class HtmlRenderer extends MarkDownRenderer {
   private String title;

   public final String getTitle() {
      return title;
   }

   public final void setTitle(final String title) {
      this.title = title;
   }

   public String renderToString() throws IOException {
      Parser parser = Parser.builder().build();
      Node document = parser.parseReader(new FileReader(source));
      com.vladsch.flexmark.html.HtmlRenderer renderer = com.vladsch.flexmark.html.HtmlRenderer.builder().build();
      StringBuilder html = new StringBuilder("<html><head><title>");
      html.append(title);
      html.append("</title></head><body>");
      html.append(renderer.render(document)).append("</body></html>");
      return html.toString();
   }

   public void renderToStream(OutputStream stream) throws IOException {
      OutputStreamWriter osw = new OutputStreamWriter(stream);
      renderToStream(osw);
   }
   
   public void renderToStream(Writer osw) throws IOException {
      String html = renderToString();
      osw.write(html, 0, html.length());
   }
}
