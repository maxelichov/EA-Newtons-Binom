package workshopea.webserver.usersManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserManagerController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserManagerController.class);
	
	@Autowired
	UserManagerService userService;
	

	@PostMapping(path = "/api/signin")
	public ResponseEntity<UserDto> loginUser(@RequestBody final LoginModel loginModel){
		logger.info("Sign in user : {}", loginModel.getUsername());
		final UserDto user = userService.loginUser(loginModel);
		logger.info("Sign in user : {}", user.getEmail()!=null);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(path = "/api/register")
	public ResponseEntity<UserDto> createUser(@RequestBody final User userPayload){
		logger.info("create user triggered : {}", userPayload.getEmail());
		final UserDto user = userService.register(userPayload);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
}
