package workshopea.webserver.engine;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeekScheduleModel {
	@JsonProperty("weekSchedule")
    private List<DayScheduleModel> weekSchedule;
}
