package workshopea.webserver.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import logic.Schedule;

@RestController
@RequestMapping("/api/engine")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @PostMapping
    public ResponseEntity<Schedule> getCourses(@RequestBody DtoEAModel dto) throws Exception {
    	Schedule schedule = engineService.getWinningSchedule(dto);
    	System.out.println("----->"+schedule);
    	return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
