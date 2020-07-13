package za.co.sfh.features.repository;

import lombok.extern.slf4j.Slf4j;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import za.co.sfh.features.repository.entities.Book;
import za.co.sfh.features.repository.entities.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestUnidirectionalOneToMany {

     private EntityManagerFactory emf;

     @Before
     public void init() {
          emf = Persistence.createEntityManagerFactory("my-persistence-unit");
     }

     @After
     public void close() {
          emf.close();
     }

     @Test
     public void unidirectionalOneToMany() {
          log.info("... unidirectionalOneToMany ...");

          // Add a new Review
          EntityManager em = emf.createEntityManager();
          em.getTransaction().begin();

          Book b = em.find(Book.class, 1L);

          Review r = new Review();
          r.setComment("This is a comment");

          b.getReviews().add(r);

          em.persist(r);

          em.getTransaction().commit();
          em.close();

          // Get Book entity with Reviews
          em = emf.createEntityManager();
          em.getTransaction().begin();

          b = em.find(Book.class, 1L);

          List<Review> reviews = b.getReviews();
          assertTrue(reviews.contains(r));

          em.getTransaction().commit();
          em.close();
     }
}
