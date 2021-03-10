package fi.eerokoski.Bookstore;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.Bookstore.domain.Category;
import fi.eerokoski.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CategoryRepositoryTest {
	
	@Autowired
	private CategoryRepository crepository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Horror");
		
	}
	

}
