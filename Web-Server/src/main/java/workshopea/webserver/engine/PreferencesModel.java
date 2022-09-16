package workshopea.webserver.engine;

import java.util.List;

import logic.Course;
import lombok.Data;

@Data
public class PreferencesModel {
	private int percentageIntensity;
    private int percentageMaxHoursForStudyingInWeek;
    private int percentageMinCredits;
    private float intensity;
    private float minCredits;
    private List<Course> prefCourse;
    private float maxHoursForStudyingInWeek;
    private WeekScheduleModel unavailablityWeekSchedule;
    private List<Course> mustHaveCourses;
}
