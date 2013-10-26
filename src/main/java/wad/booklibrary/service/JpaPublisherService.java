/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wad.booklibrary.domain.Publisher;
import wad.booklibrary.repository.PublisherRepository;

/**
 *
 * @author simo
 */
@Service
public class JpaPublisherService implements PublisherService
{
    @Autowired
    PublisherRepository publisherRepository;

    @Override
    public Publisher add(Publisher publisher)
    {
        return publisherRepository.save(publisher);
    }

    @Override
    public Publisher readOne(Long id)
    {
        return publisherRepository.findOne(id);
    }

    @Override
    public void delete(Long id)
    {
        publisherRepository.delete(id);
    }

    @Override
    public List<Publisher> list()
    {
        return publisherRepository.findAll();
    }
    
}
