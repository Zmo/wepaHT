/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author simo
 */
@Entity
@Table(name = "Publisher")
public class Publisher implements Serializable
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name="ID")
    private Long id;
    
    @Column(name = "NAME")
    private String name;
    
    @ManyToMany(mappedBy="publishers")
    private List<Book> books;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the books
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
