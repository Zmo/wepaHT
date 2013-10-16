/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import wad.booklibrary.domain.Book;

/**
 *
 * @author simo
 */
public interface BookService
{
    public Book add(Book book);
    public Book readOne(Long id);
    public void delete(Long id);
    public List<Book> list();
}
