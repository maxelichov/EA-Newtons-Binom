package workshopea.webserver.engine;

import java.util.List;

import logic.Days;
import lombok.Data;
import workshopea.webserver.courses.RangeTimeModel;

@Data
public class DayScheduleModel {
	private Days day;
    private List<RangeTimeModel> listStartEnd;
}
