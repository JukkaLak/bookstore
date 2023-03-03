package hhsof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhsof3.bookstore.domain.Book;
import hhsof3.bookstore.domain.BookRepository;
import hhsof3.bookstore.domain.Category;
import hhsof3.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			log.info("Save some categories");
			Category category1 = new Category("Scifi");
			categoryRepository.save(category1);
			Category category2 = new Category("Fantasy");
			categoryRepository.save(category2);
			Category category3 = new Category("History");
			categoryRepository.save(category3);
			log.info("Save some books");
			bookRepository.save(new Book("Myyrä", "Jari Tervo", 2004, 0001, 10.0, category3));
			bookRepository.save(new Book("1984", "George Orwell", 1949, 0002, 12.0, category1));
			
			log.info("Fetch all books");
			for(Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
