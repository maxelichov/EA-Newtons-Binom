package workshopea.webserver.courses;

import java.util.List;

import lombok.Data;

@Data
public class GroupModel {
	List<LessonModel> lessons;
}
