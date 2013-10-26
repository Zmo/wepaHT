/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import wad.booklibrary.domain.Author;

/**
 *
 * @author simo
 */
public interface AuthorService
{
    public Author add(Author author);
    public Author readOne(Long id);
    public void delete(Long id);
    public List<Author> list();
}
