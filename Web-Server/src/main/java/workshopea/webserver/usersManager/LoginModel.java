package workshopea.webserver.usersManager;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginModel {
	private String username;
	private String password;
}
