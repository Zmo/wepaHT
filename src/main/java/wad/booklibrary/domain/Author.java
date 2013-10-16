/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author simo
 */
@Entity
@Table(name = "Author")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    
    private String name;
}
