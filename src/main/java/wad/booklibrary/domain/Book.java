/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author simo
 */
@Entity
@Table(name = "Book")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="id", nullable=false)
    private Long id;
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="")
    private List<Author> authors;
    
    @Column(name="")
    private List<Publisher> publishers;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="publishingYear", nullable=false)
    private Date publishingYear;
    
}
