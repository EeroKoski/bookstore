package fi.eerokoski.Bookstore.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.eerokoski.Bookstore.domain.BookRepository;
import fi.eerokoski.Bookstore.domain.Book;
import fi.eerokoski.Bookstore.domain.CategoryRepository;
import fi.eerokoski.Bookstore.domain.Category;


@RestController
public class RestBookController {

	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping("/kirjat")
	public List <Book>bookListRest() {
			return (List<Book>) brepository.findAll();
	}
	
	@RequestMapping("/categories")
	public List <Category>categoryListRest() {
			return (List<Category>) crepository.findAll();
	}
}
