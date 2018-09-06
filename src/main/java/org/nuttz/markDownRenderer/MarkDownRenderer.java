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
    * Copies the source to the passed <code>Writer</code>
    *
    * @param writer a <code>Writer</code> destination
    * @exception IOException if an error occurs
    */
   public void renderToStream(final Writer writer) throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(source.getPath()));
      // I would use a lambda here and foreach, but that doesn't
      // handle exceptions properly
      for (String line : lines) {
         writer.write(line);
      }
   }

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
    * Describe <code>renderToString</code> method here.
    *
    * @return a <code>String</code> value
    * @exception IOException if an error occurs
    */
   public String renderToString() throws IOException {
      List<String> lines = Files.readAllLines(Paths.get(source.getPath()));
      return String.join("\n",lines);
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
