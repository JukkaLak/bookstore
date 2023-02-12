package hhsof3.bookstore.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hhsof3.bookstore.domain.Book;
import hhsof3.bookstore.domain.BookRepository;





@Controller
public class BookstoreController {
	
	
	
	@GetMapping("/index")
	public String index() {
		return "welcome-template";
	}
	
	@Autowired
	
	BookRepository bookRepository;
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
		
		List<Book> books = (List<Book>) bookRepository.findAll();
		
		model.addAttribute("books", books);
		
		return "book-list";
	}
	

	
	
	
	
	
	
	

}
