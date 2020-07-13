package za.co.sfh.features.services;

import org.springframework.stereotype.Service;
import za.co.sfh.features.repository.BookRepository;
import za.co.sfh.features.repository.entities.Book;
import za.co.sfh.features.repository.ReviewRepository;

//import za.co.sfh.features.repository.BookManualRepository;

@Service
public class BookService {

     private BookRepository bookRepository;

     private ReviewRepository reviewRepository;

     public BookService(BookRepository bookRepository, ReviewRepository reviewRepository) {
          this.bookRepository = bookRepository;
          this.reviewRepository = reviewRepository;
     }

     public void testSpringRepository() {
          Book book = new Book();
          book.setTitle("test title");
          bookRepository.save(book);
//          bookManualRepository.refresh(book);
     }

     public void deleteBook(Long id) {
          bookRepository.deleteById(id);
     }
}
