package workshopea.webserver.usersManager;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserManagerService {
    private Map<String,User> users = new HashMap<>();

    public String addUser(User newUser){
        if(users.containsKey(newUser.getUserName())){
            return newUser.getUserName()+" already exist";
            //Todo excepton
        }else{
            users.put(newUser.getUserName(),newUser);
            return newUser.getUserName()+" add successfully";
        }
    }

    public String remove(String userName, String password){
        if(!users.containsKey(userName)){
            return userName + " doesn't exist";
        }else{
            if(password.equals(users.get(userName).getPassword())){
                users.remove(userName);
                return userName + " remove successfully";
            }else{
                return "incorrect password";
            }

        }
    }

    public boolean login(String userName, String password){
        if(!users.containsKey(userName)){
            return false;
        }else {
            return password.equals(users.get(userName).getPassword());
        }
    }

}
