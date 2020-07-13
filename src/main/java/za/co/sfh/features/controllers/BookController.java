package za.co.sfh.features.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.co.sfh.features.services.BookService;

@Slf4j
@RestController
@RequestMapping("/api")
public class BookController {

     private BookService bookService;

     public BookController(BookService bookService) {
          this.bookService = bookService;
     }

     @GetMapping
     @RequestMapping("/book")
     public void testRepo() {
          log.debug("Doing book testing");
          bookService.testSpringRepository();
     }

     @DeleteMapping("/book/{id}")
     public void deleteBook(@PathVariable("id") Long id) {
          bookService.deleteBook(id);
     }
}
