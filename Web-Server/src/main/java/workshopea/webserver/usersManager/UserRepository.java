package workshopea.webserver.usersManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsernameAndPassword(String username, String password);
	User findByEmail(String email);
	User findByUsername(String username);
	User findById(long id);
}
