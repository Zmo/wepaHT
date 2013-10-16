/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author simo
 */
@Controller
public class BookController {
    
    @Autowired
    BookService bookService;
    
    
}
