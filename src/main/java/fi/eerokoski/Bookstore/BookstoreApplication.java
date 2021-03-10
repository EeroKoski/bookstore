package fi.eerokoski.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.eerokoski.Bookstore.domain.AppUser;
import fi.eerokoski.Bookstore.domain.AppUserRepository;
import fi.eerokoski.Bookstore.domain.Book;
import fi.eerokoski.Bookstore.domain.BookRepository;
import fi.eerokoski.Bookstore.domain.Category;
import fi.eerokoski.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookStore(BookRepository brepository, CategoryRepository crepository, AppUserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
					crepository.save(new Category("Horror"));
					crepository.save(new Category("Horticulture"));
					crepository.save(new Category("Sci-Fi"));
					crepository.save(new Category("DIY"));
			
			
					brepository.save(new Book("Sipulinkasvatusopas", "Seppo Sepilainen", 1976, "978-3-16-148410-0", 19.90, crepository.findByName("Horror").get(0)));
					brepository.save(new Book("Porkkana", "Simo Salo", 1875, "978-3-16-148410-1", 17.95, crepository.findByName("Horticulture").get(0)));
					
					AppUser user1 = new AppUser("user", "\n"
							+ "$2y$12$ZNscmmykeTinqMmLE6aOyOOD3XWjtr8B1lL1qkaQc3xZ3Cv5DbVMG\n"
							+ "", "USER");
					AppUser user2 = new AppUser("admin", "\n"
							+ "$2y$12$IiKoOsYJMyqvV/uTgMnFKOFRF807FGsvd0t40QPypF25kqJ.SECQG\n"
							+ "", "ADMIN");
					// admin + user
					urepository.save(user1);
					urepository.save(user2);
					
					log.info("fetch all books");
					for (Book book : brepository.findAll()) {
							log.info(book.toString());
					}
					
		};
	}
}
