package workshopea.webserver.usersManager;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
	private long id;
	private String email;
	private String userName;
	private String role;
}
