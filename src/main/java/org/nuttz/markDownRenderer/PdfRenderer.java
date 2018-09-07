package org.nuttz.markDownRenderer;

import java.io.IOException;
import java.io.OutputStream;
import java.io.FileReader;

import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.pdf.converter.PdfConverterExtension;
import com.vladsch.flexmark.util.options.MutableDataHolder;
import com.vladsch.flexmark.util.options.MutableDataSet;


/**
 * Describe class PdfRenderer here.
 *
 *
 * Created: Thu Sep  6 14:48:22 2018
 *
 * @author <a href="mailto:jim@nuttz.org">Jim Nutt</a>
 * @version 1.0
 */
public class PdfRenderer extends MarkDownRenderer {

   static final MutableDataHolder OPTIONS = new MutableDataSet();

   /**
    * Creates a new <code>PdfRenderer</code> instance.
    *
    */
   public PdfRenderer() {

   }

   /**
    * Writes the rendered PDF to an <code>OutputStream</code>
    *
    * @param outputStream an <code>OutputStream</code> value
    * @exception IOException if an error occurs
    */
   @Override
   public void renderToStream(final OutputStream outputStream) throws IOException {
      Parser parser = Parser.builder().build();
      Node document = parser.parseReader(new FileReader(source));
      com.vladsch.flexmark.html.HtmlRenderer renderer = com.vladsch.flexmark.html.HtmlRenderer.builder().build();
      StringBuilder html = new StringBuilder("<html><head><title>");
      html.append(title);
      html.append("</title></head><body>");
      html.append(renderer.render(document)).append("</body></html>");
      PdfConverterExtension.exportToPdf(outputStream, html.toString(),"resume.pdf", OPTIONS);
   }
}
