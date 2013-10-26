/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wad.booklibrary.domain.Publisher;

/**
 *
 * @author simo
 */
@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    
}
