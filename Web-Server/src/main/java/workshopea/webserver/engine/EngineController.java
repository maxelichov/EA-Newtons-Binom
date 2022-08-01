package workshopea.webserver.engine;

import dto.DtoEA;
import logic.Course;
import logic.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshopea.webserver.courses.CoursesService;

import java.util.List;

@RestController
public class EngineController {

    @Autowired
    private EngineService engineService;

    @RequestMapping("/engine")
    public Schedule getCourses(@RequestBody String dtoEaJson) {
        return engineService.getWinningSchedule(dtoEaJson);
    }
}
