package org.nuttz.markDownRenderer;

import java.io.OutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.Writer;

/**
 * This interface describes the API for the various markdown
 * renderers.
 * *
 * Created: Tue Sep  4 14:35:41 2018
 *
 * @author <a href="mailto:jim@nuttz.org">Jim Nutt</a>
 * @version 1.0
 */
public interface Renderer {
   public void renderToStream(OutputStream stream) throws IOException;
   public void setSource(String filename) throws FileNotFoundException;
   public String getSource();
   public String getTitle();
   public void setTitle(String title);
}

