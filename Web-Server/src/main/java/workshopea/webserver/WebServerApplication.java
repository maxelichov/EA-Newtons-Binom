package workshopea.webserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//it says that it is the entry point for spring boot app
@SpringBootApplication
@EntityScan(basePackages = {"logic", "workshopea.webserver"})
@EnableJpaRepositories({"logic", "workshopea.webserver"})
public class WebServerApplication {

    public static void main(String[] args) {SpringApplication.run(WebServerApplication.class, args);}

}

