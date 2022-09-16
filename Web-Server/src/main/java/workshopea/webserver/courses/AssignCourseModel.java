package workshopea.webserver.courses;

import java.util.List;

import lombok.Data;

@Data
public class AssignCourseModel {
	
	List<String> courses;
	long userId;

}
