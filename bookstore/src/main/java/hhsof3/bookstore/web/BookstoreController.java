package hhsof3.bookstore.web;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hhsof3.bookstore.domain.Book;
import hhsof3.bookstore.domain.BookRepository;
import hhsof3.bookstore.domain.Category;
import hhsof3.bookstore.domain.CategoryRepository;




@CrossOrigin
@Controller
public class BookstoreController {
	
	
	
	@GetMapping("/index")
	public String index() {
		return "welcome-template";
	}
	
	@Autowired
	private BookRepository repository;
	
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "book-list";
	}
		
	
	
	@GetMapping("/books")
	public @ResponseBody List<Book> getBooks(){
		return (List<Book>) repository.findAll();
	}
	
	@GetMapping("/books/{id}")
	public @ResponseBody Optional<Book> getOneBook(@PathVariable("id") Long bookId){
		return repository.findById(bookId);
	}
	
	
	
	
	/*@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBook(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("category", categoryRepository.findAll());
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
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editBook(Model model) {
		model.addAttribute(addBook(model));
		return "redirect:../books";
		
	}
	*/

	
	
	
	
	
	
	

}
