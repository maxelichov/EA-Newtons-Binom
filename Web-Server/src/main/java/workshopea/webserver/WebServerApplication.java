package workshopea.webserver;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshopea.webserver.usersManager.User;

//it says that it is the entry point for spring boot app
@SpringBootApplication
public class WebServerApplication {

    public static void main(String[] args) {SpringApplication.run(WebServerApplication.class, args);}

}
