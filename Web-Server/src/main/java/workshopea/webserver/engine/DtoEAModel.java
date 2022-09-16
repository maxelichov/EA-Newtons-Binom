package workshopea.webserver.engine;

import java.util.List;

import logic.Course;
import lombok.Data;

@Data
public class DtoEAModel {
	private List<Course> courses;
    private PreferencesModel pref;
    private EaRunTimeParametersModel eaRunTimeParameters;
}
