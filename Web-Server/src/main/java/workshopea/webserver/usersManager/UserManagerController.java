package workshopea.webserver.usersManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public String addUser(@RequestBody User newUser){
        return userManagerService.addUser(newUser);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public String removeUser(@RequestBody User newUser){
        return userManagerService.remove(newUser.getUserName(), newUser.getPassword());
    }
}
