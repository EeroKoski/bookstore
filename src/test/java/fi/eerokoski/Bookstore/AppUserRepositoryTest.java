package fi.eerokoski.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.eerokoski.Bookstore.domain.AppUser;
import fi.eerokoski.Bookstore.domain.AppUserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserRepositoryTest {
	
	@Autowired
	private AppUserRepository urepository;
	
	@Test
	public void findByUserNameShouldReturnUser() {
		List<AppUser> appUsers = urepository.findByUsername("user");
		
		assertThat(appUsers).hasSize(1);
		assertThat(appUsers.get(0).getUsername()).isEqualTo("user");
	}
	
	@Test
	public void createNewUser() {
		AppUser appuser = new AppUser("guest", "oisjf0u89q32roisnehf", "USER");
		urepository.save(appuser);
		assertThat(appuser.getId()).isNotNull();
	}
	
	
	

}
