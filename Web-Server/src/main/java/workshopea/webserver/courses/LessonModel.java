package workshopea.webserver.courses;

import logic.Days;
import lombok.Data;

@Data
public class LessonModel {
	private Days day;
    private RangeTimeModel timeRange;
}
