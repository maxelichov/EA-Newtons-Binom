package workshopea.webserver.usersManager;

import com.google.gson.Gson;
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
    public String addUser(@RequestBody String newUserString){

        return userManagerService.addUser(newUserString);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/user")
    public String removeUser(@RequestBody User newUser){
        return userManagerService.remove(newUser.getUserName(), newUser.getPassword());
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user")
    public String loginUser(@RequestBody String userJson){
        User user = userManagerService.getGson().fromJson(userJson,User.class);
        return userManagerService.login(user.getUserName(), user.getPassword());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public void loginUser(){
        User max = new User("max", "1234" , true);
        User ohad = new User("ohad", "hskf" , false);

        Gson g= new Gson();
        System.out.println(g.toJson(max));
        System.out.println(g.toJson(ohad));
    }
}
