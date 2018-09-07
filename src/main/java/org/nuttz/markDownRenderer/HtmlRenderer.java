package org.nuttz.markDownRenderer;

import java.io.FileReader;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.parser.Parser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

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

   /**
    * get the current title for the resume
    * @return a <code>String</code> containing the current page title
    */
   public final String getTitle() {
      return title;
   }

   /**
    * set the title for the resume
    *
    * @param title a <code>String</code> containing the title
    */
   public final void setTitle(final String title) {
      this.title = title;
   }

   /**
    * Sends the rendered HTML to the passed <code>OutputStream</code>
    *
    * @param writer an <code>OutputStream</code> destination
    * @exception IOException if an error occurs
    */
   @Override
   public void renderToStream(OutputStream stream) throws IOException {
      Parser parser = Parser.builder().build();
      Node document = parser.parseReader(new FileReader(source));
      com.vladsch.flexmark.html.HtmlRenderer renderer = com.vladsch.flexmark.html.HtmlRenderer.builder().build();
      StringBuilder html = new StringBuilder("<html><head><title>");
      html.append(title);
      html.append("</title></head><body>");
      html.append(renderer.render(document)).append("</body></html>");
      OutputStreamWriter osw = new OutputStreamWriter(stream);
      osw.write(html.toString());
   }
}
