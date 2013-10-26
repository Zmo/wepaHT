/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author simo
 */
@Entity
@Table(name = "BOOK")
public class Book implements Serializable
{
    public Book(long isbn)
    {
        this.ISBN = isbn;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long ISBN;
    
    @Column(name="NAME", nullable=false)
    private String name;
    
    @ManyToMany
    @JoinTable(name="AUTHORS")
    private List<Author> authors;
    
    @ManyToMany
    @JoinTable(name="PUBLISHERS")
    private List<Publisher> publishers;
    
    @Column(name="publishingYear", nullable=false)
    private int publishingYear;

    /**
     * @return the ISBN
     */
    public Long getISBN() {
        return ISBN;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
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
     * @return the authors
     */
    public List<Author> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    /**
     * @return the publishers
     */
    public List<Publisher> getPublishers() {
        return publishers;
    }

    /**
     * @param publishers the publishers to set
     */
    public void setPublishers(List<Publisher> publishers) {
        this.publishers = publishers;
    }

    /**
     * @return the publishingYear
     */
    public int getPublishingYear() {
        return publishingYear;
    }

    /**
     * @param publishingYear the publishingYear to set
     */
    public void setPublishingYear(int publishingYear) {
        this.publishingYear = publishingYear;
    }
    
}
