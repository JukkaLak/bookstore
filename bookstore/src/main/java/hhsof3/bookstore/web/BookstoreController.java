package hhsof3.bookstore.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class BookstoreController {
	
	
	
	@GetMapping("/index")
	public String index() {
		return "welcome-template";
	}
	
	
	
	
	
	
	

}
