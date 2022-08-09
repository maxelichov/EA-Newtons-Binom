package workshopea.webserver.usersManager;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserManagerService {
    private Map<String,User> users = new HashMap<>();
    private Gson gson = new Gson();

    public String addUser(String newUserJson){
        User newUser = gson.fromJson(newUserJson,User.class);

        if(users.containsKey(newUser.getUserName())){
            return newUser.getUserName()+" already exist";
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

    public String login(String userName, String password){
        if(!users.containsKey(userName)){
            return userName + " doesn't exist!";
        }else {
            if(!password.equals(users.get(userName).getPassword())){
                return password + " isn't correct";
            }else{
                return String.valueOf(users.get(userName).isManager());
            }
        }
    }

    public Gson getGson() {
        return gson;
    }
}
