/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.booklibrary.domain.Author;
import wad.booklibrary.domain.Book;
import wad.booklibrary.domain.Publisher;
import wad.booklibrary.service.AuthorService;
import wad.booklibrary.service.BookService;
import wad.booklibrary.service.PublisherService;

/**
 *
 * @author simo
 */
@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @Autowired
    AuthorService authorService;
    
    @Autowired
    PublisherService publisherService;
    
    @RequestMapping(value="books", method = RequestMethod.GET)
    public String list(Model model)
    {
        model.addAttribute("books", bookService.list());
        model.addAttribute("authors", authorService.list());
        model.addAttribute("publishers", publisherService.list());
        return "books";
    }
    
    @RequestMapping(value="books", method = RequestMethod.POST)
    public String add(@RequestParam Long ISBN, @RequestParam String name, @ModelAttribute List<Author> authors, @RequestParam Long[] publishers, @RequestParam int publishingYear)
    {
        Book book = new Book(ISBN);
        book.setName(name);
        
        /*List<Author> authorList = new ArrayList<Author>();
        for(int i=0; i<authors.length; ++i)
        {
            authorList.add(authorService.readOne(authors[i]));
        }*/
        book.setAuthors(authors);
        
        List<Publisher> publisherList = new ArrayList<Publisher>();
        for(int i=0; i<publishers.length; ++i)
        {
            publisherList.add(publisherService.readOne(publishers[i]));
        }
        book.setPublishers(publisherList);
        
        
        book.setPublishingYear(publishingYear);
        bookService.add(book);
        
        return "redirect:/app/books";
    }
    
    @RequestMapping(value="books/{bookId}", method = RequestMethod.GET)
    public String bookDetails(@PathVariable Long bookId, Model model)
    {
        model.addAttribute("book", bookService.readOne(bookId));
        return "book";
    }
    
    @RequestMapping(value="authors", method=RequestMethod.GET)
    public String getAuthors(Model model)
    {
        model.addAttribute("authors", authorService.list());
        return "redirect:/app/books";
    }
    
    @RequestMapping(value="authors", method=RequestMethod.POST)
    public String addAuthor(@RequestParam String name)
    {
        Author author = new Author();
        author.setName(name);
        authorService.add(author);
        
        return "redirect:/app/books";
    }
    
    @RequestMapping(value="publishers", method=RequestMethod.GET)
    public String getPublishers(Model model)
    {
        model.addAttribute("publishers", publisherService.list());
        return "redirect:/app/books";
    }
    
    @RequestMapping(value="publishers", method=RequestMethod.POST)
    public String addPublisher(@RequestParam String name)
    {
        Publisher publisher = new Publisher();
        publisher.setName(name);
        publisherService.add(publisher);
        
        return "redirect:/app/books";
    }
    
    public List<Author> authorArrayIntoList(String[] authors)
    {
        Author[] authorList;
        for(int i=0; i<authors.length; ++i)
        {
            Author author = new Author();
            author.setName(authors[i]);
            
            //authors[i]
        }
        return null;
    }
    
    public List<Publisher> publisherArrayIntoList(String[] publishers)
    {
        return null;
    }
}
