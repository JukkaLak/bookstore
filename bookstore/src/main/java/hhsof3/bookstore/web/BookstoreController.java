package hhsof3.bookstore.web;


import java.util.List;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		return "addbook";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book) {
		bookRepository.save(book);
		return "redirect:books";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}

	
	
	
	
	
	
	

}
