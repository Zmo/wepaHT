/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wad.booklibrary.domain.Book;

/**
 *
 * @author simo
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
