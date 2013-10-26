/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.booklibrary.domain.Author;
import wad.booklibrary.repository.AuthorRepository;

/**
 *
 * @author simo
 */
@Service
public class JpaAuthorService implements AuthorService
{
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author add(Author author)
    {
        return authorRepository.save(author);
    }

    @Override
    public Author readOne(Long id)
    {
        return authorRepository.findOne(id);
    }

    @Override
    public void delete(Long id)
    {
        authorRepository.delete(id);
    }

    @Override
    public List<Author> list()
    {
        return authorRepository.findAll();
    }
    
}
