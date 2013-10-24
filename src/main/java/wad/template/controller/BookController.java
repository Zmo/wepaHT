/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import wad.booklibrary.domain.Book;
import wad.booklibrary.service.BookService;

/**
 *
 * @author simo
 */
@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    @RequestMapping(value="books", method = RequestMethod.GET)
    public String list(Model model)
    {
        model.addAttribute("books", bookService.list());
        return "books";
    }
    
    @RequestMapping(value="books", method = RequestMethod.POST)
    public String add(@RequestBody Book book)
    {
        bookService.add(book);
        return "redirect:/books";
    }
    
    @RequestMapping(value="books/{bookId}", method = RequestMethod.GET)
    public String bookDetails(@RequestParam Long bookId, Model model)
    {
        model.addAttribute("book", bookService.readOne(bookId));
        return "book";
    }
    
}
