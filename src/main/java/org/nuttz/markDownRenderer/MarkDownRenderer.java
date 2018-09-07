package org.nuttz.markDownRenderer;

import java.io.IOException;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.File;

import org.nuttz.exceptions.*;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;

/**
 * Base class for the other renderers, basically a no-op in this case.
 *
 *
 * Created: Thu Sep  6 09:52:00 2018
 *
 * @author <a href="mailto:jim@nuttz.org">Jim Nutt</a>
 * @version 1.0
 */
public class MarkDownRenderer implements Renderer {
   File source;

   /**
    * Creates a new <code>MarkDownRenderer</code> instance.
    *
    */
   public MarkDownRenderer() {

   }

   // Implementation of org.nuttz.markDownRenderer.Renderer

   /**
    * Describe <code>renderToStream</code> method here.
    *
    * @param outputStream an <code>OutputStream</code> value
    * @exception IOException if an error occurs
    */
   public void renderToStream(final OutputStream outputStream) throws IOException {
      Files.copy(Paths.get(source.getPath()), outputStream);
   }

   /**
    * Sets the source path for the markdown file to be rendered/
    *
    * @param string a <code>String</code> value
    * @exception FileNotFoundException if an error occurs
    */
   public void setSource(String filename) throws FileNotFoundException {
      source = new File(filename);
   }

   public String getSource() {
      return source.getPath();
   }
}
