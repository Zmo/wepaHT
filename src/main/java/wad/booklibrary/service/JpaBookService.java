/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.booklibrary.domain.Book;
import wad.booklibrary.repository.BookRepository;

/**
 *
 * @author simo
 */
@Service
public class JpaBookService implements BookService
{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book book)
    {
        return bookRepository.save(book);
    }

    @Override
    public Book readOne(Long id)
    {
        return bookRepository.findOne(id);
    }

    @Override
    public void delete(Long id)
    {
        bookRepository.delete(id);
    }

    @Override
    public List<Book> list()
    {
        return bookRepository.findAll();
    }
    
}
