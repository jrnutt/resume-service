package resumeService;

import org.nuttz.markDownRenderer.*;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.io.FileReader;

import java.io.IOException;

@RestController
@EnableAutoConfiguration
public class App {

   @GetMapping(path="/", produces="text/markdown;charset=UTF-8")
   String markdown() throws IOException {
      Renderer r = new org.nuttz.markDownRenderer.MarkDownRenderer();
      r.setSource("/home/jim/sync/JamesNuttResume.markdown");
      return r.renderToString();
   }

   @GetMapping(path="/", produces="application/vnd.openxmlformats-officedocument.wordprocessingml.document;charset=UTF-8")
   String docx() throws IOException {
      Renderer r = new org.nuttz.markDownRenderer.DocXRenderer();
      r.setSource("/home/jim/sync/JamesNuttResume.markdown");
      return r.renderToString();
   }

   @GetMapping(path="/", produces="application/pdf;charset=UTF-8")
   String pdf() throws IOException {
      Renderer r = new org.nuttz.markDownRenderer.PdfRenderer();
      r.setSource("/home/jim/sync/JamesNuttResume.markdown");
      return r.renderToString();
   }

   @GetMapping(path="/", produces="text/html;charset=UTF-8")
   String html() throws IOException {
      Renderer r = new org.nuttz.markDownRenderer.HtmlRenderer();
      r.setSource("/home/jim/sync/JamesNuttResume.markdown");
      return r.renderToString();
   }

   public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
