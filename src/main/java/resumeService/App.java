package resumeService;

import org.nuttz.markDownRenderer.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.mvc.method.annotation.*;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.io.OutputStream;

@RestController
@EnableAutoConfiguration
public class App {

   @GetMapping(path="/resume.markdown", produces="text/markdown;charset=UTF-8")
   StreamingResponseBody markdown() throws IOException {
      return new StreamingResponseBody() {
         @Override
         public void writeTo(OutputStream outputStream) throws IOException {
            Renderer r = new org.nuttz.markDownRenderer.MarkDownRenderer();
            r.setSource("/home/jim/sync/JamesNuttResume.markdown");
            r.renderToStream(outputStream);
         }
      };
   }

   @GetMapping(path="/resume.docx", produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document;charset=UTF-8")
   StreamingResponseBody docx() throws IOException {
      return new StreamingResponseBody() {
         @Override
         public void writeTo(OutputStream outputStream) throws IOException {
            Renderer r = new org.nuttz.markDownRenderer.PdfRenderer();
            r.setSource("/home/jim/sync/JamesNuttResume.markdown");
            r.renderToStream(outputStream);
         }
      };
   }

   @GetMapping(path="/resume.pdf", produces="application/pdf;charset=UTF-8")
   StreamingResponseBody pdf() throws IOException {
      return new StreamingResponseBody() {
         @Override
         public void writeTo(OutputStream outputStream) throws IOException {
            Renderer r = new org.nuttz.markDownRenderer.PdfRenderer();
            r.setSource("/home/jim/sync/JamesNuttResume.markdown");
            r.renderToStream(outputStream);
         }
      };
   }

   @GetMapping(path="/resume.html", produces="text/html;charset=UTF-8")
   StreamingResponseBody html() throws IOException {
      return new StreamingResponseBody() {
         @Override
         public void writeTo(OutputStream outputStream) throws IOException {
            Renderer r = new org.nuttz.markDownRenderer.HtmlRenderer();
            r.setSource("/home/jim/sync/JamesNuttResume.markdown");
            r.renderToStream(outputStream);
         }
      };
   }

   public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
