package Assignment.SectorQube;

import Assignment.SectorQube.model.User;
import Assignment.SectorQube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SectorQubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SectorQubeApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

		@Component
		class usercommandliner implements CommandLineRunner {

			@Autowired
			private UserRepository userrepository;

			@Override
			public void run(String... args) throws Exception {

				User user3=new User();
				user3.setUserid(1);
				user3.setUsername("master");
				user3.setFullname("Administrator");
				user3.setPassword("admin");
				user3.setRoleid("1");
				userrepository.save(user3);

				User user4=new User();
				user4.setUserid(2);
				user4.setUsername("support");
				user4.setFullname("Support1");
				user4.setPassword("admin");
				user4.setRoleid("2");
				userrepository.save(user4);

				User user1=new User();
				user1.setUserid(3);
				user1.setUsername("user1");
				user1.setFullname("User");
				user1.setPassword("user1_123");
				user1.setRoleid("3");
				userrepository.save(user1);

				User user2=new User();
				user2.setUserid(4);
				user2.setUsername("user2");
				user2.setFullname("User");
				user2.setPassword("user2_123");
				user2.setRoleid("3");
				userrepository.save(user2);
				
				
			}
		}
	}





