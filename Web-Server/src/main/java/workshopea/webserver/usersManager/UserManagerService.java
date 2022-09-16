package workshopea.webserver.usersManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workshopea.webserver.exception.CourseException;

@Service
public class UserManagerService {

	private static final Logger logger = LoggerFactory.getLogger(UserManagerService.class);
	
	@Autowired
	UserRepository userRepo;

	public UserDto register(User user) {
		logger.info("Registering user : {}", user.getEmail());
		User userBasedOnEmail = userRepo.findByEmail(user.getEmail());
		if(userBasedOnEmail != null) {
			logger.error("Email already taken");
			throw new CourseException("Email already taken");
		}
		User userBasedOnUsername = userRepo.findByUsername(user.getUsername());
		if(userBasedOnUsername != null) {
			logger.error("Username already taken");
			throw new CourseException("Username already taken");
		}
		User userFromDb = userRepo.save(user);
		logger.info("Registered user successfully : {}", user.getEmail());
		return formUserDto(userFromDb);
	}
	
	public UserDto loginUser(LoginModel login) {
		User user = userRepo.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		if(user==null) {
			logger.error("User credentials is not valid");
			throw new CourseException("User credentials is not valid");
		} else {
			logger.info("login user successfully : {}", user.getUsername());
			return formUserDto(user);
		}
	}

	public boolean isAdmin(long id) {
		logger.info("Checking user is admin : userId : {}", id);
		User user = userRepo.findById(id);
		return (user!=null) ? user.getRole().equals("admin") : false;
	}
	
	private UserDto formUserDto(User user) {
		return new UserDto(user.getId(), user.getEmail(), user.getUsername(), user.getRole());
	}
}
