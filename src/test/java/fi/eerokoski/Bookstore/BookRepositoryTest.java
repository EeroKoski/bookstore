package fi.eerokoski.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.Bookstore.domain.Book;
import fi.eerokoski.Bookstore.domain.BookRepository;
import fi.eerokoski.Bookstore.domain.Category;

	@RunWith(SpringRunner.class)
	@DataJpaTest
public class BookRepositoryTest {

		@Autowired
		private BookRepository brepository;
		
		@Test
		public void findByAuthorShouldReturnBook() {
			List<Book> books = brepository.findByAuthor("Simo Salo");
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getTitle()).isEqualTo("Porkkana");
		}
	@Test
	public void createNewBook() {
		Book book = new Book("Porkkana", "Simo Salo", 1875, "978-3-16-148410-1", 17.95, new Category("Sipuli"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	
}
