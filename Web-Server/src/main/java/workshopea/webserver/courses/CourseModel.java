package workshopea.webserver.courses;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CourseModel {
	private String courseName;
    private List<GroupModel> groups;
    private List<LessonModel> practice;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private Date testA;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss", timezone = JsonFormat.DEFAULT_TIMEZONE)
    private Date testB;
    private double credits;
    private int difficulty;
    private Boolean isMandatory;
}
