package hhsof3.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hhsof3.bookstore.domain.Book;
import hhsof3.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository bookRepository) {
		return (args) -> {
			Book book1 = new Book("Myyrä", "Jari Tervo", 2004, 0001, 15.0);
			Book book2 = new Book("1984", "George Orwell", 1949, 0002, 10.0);
			bookRepository.save(book1);
			bookRepository.save(book2);
			
			for(Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}
		};
	}

}
