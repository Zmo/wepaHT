/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.booklibrary.service;

import java.util.List;
import wad.booklibrary.domain.Publisher;

/**
 *
 * @author simo
 */
public interface PublisherService
{
    public Publisher add(Publisher publisher);
    public Publisher readOne(Long id);
    public void delete(Long id);
    public List<Publisher> list();
}
