package hhsof3.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	private String title;
	private String author;
	@Column(name = "publishing year")
	private int year;
	private int isbn;
	private Double price;
	
	public Book() {
		super();
		this.id = null;
		this.title = null;
		this.author = null;
		this.year = 0;
		this.isbn = 0;
		this.price = null;
	}
	
	public Book(String title, String author, int year, int isbn, Double price) {
		super();
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}
	
	public Book(Long id, String title, String author, int year, int isbn, Double price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.year = year;
		this.isbn = isbn;
		this.price = price;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	

	public Long getId() {
		return id;
	}

	public String getAuthor() {
		return author;
	}

	public Integer getYear() {
		return year;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public Double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

	
	
	

}
