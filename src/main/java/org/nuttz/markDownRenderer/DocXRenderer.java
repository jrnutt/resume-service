package org.nuttz.markDownRenderer;

import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Arrays;
import java.lang.Runtime;

/**
 * Describe class DocXRenderer here.
 *
 *
 * Created: Thu Sep  6 14:48:59 2018
 *
 * @author <a href="mailto:jim@nuttz.org">Jim Nutt</a>
 * @version 1.0
 */
public class DocXRenderer extends MarkDownRenderer {

   /**
    * Creates a new <code>DocXRenderer</code> instance.
    *
    */
   public DocXRenderer() {

   }

   /**
    * Writes the rendered docx to an <code>OutputStream</code>
    *
    * @param outputStream an <code>OutputStream</code> value
    * @exception IOException if an error occurs
    */
   @Override
   public void renderToStream(final OutputStream outputStream) throws IOException {
      List<String> command = Arrays.asList("/usr/bin/pandoc", "-f","gfm", "-t","docx", source.getPath());
      ProcessBuilder pb = new ProcessBuilder(command);
      Process p = pb.start();
      InputStream is = p.getInputStream();
      final int MAXBYTES = 16384;
      while (p.isAlive()) {
         int avail = is.available();
         byte[] buffer = new byte[avail];
         is.read(buffer);
         outputStream.write(buffer);
      }
      is.close();
      outputStream.close();
   }
}
