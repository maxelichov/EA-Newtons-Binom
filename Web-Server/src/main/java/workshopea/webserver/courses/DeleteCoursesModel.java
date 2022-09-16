package workshopea.webserver.courses;

import java.util.List;

import lombok.Data;
@Data
public class DeleteCoursesModel {
	List<Long> courseIds;
}
