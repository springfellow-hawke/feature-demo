package za.co.sfh.features.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.sfh.features.repository.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
