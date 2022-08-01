package workshopea.webserver.engine;

import EA.EAManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dto.DtoEA;
import logic.Course;
import logic.LogicManager;
import logic.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshopea.webserver.courses.CoursesService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class EngineService {

    @Autowired
    private CoursesService coursesService;
    private Gson gson = new Gson();

    public Schedule getWinningSchedule(String dtoEaJson) {
        /*
        Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> courses = gson.fromJson(coursesJson , userListType);
        return courses;
         */
        DtoEA dtoEa = gson.fromJson(dtoEaJson, DtoEA.class);
        System.out.println(dtoEa);


        LogicManager logicManager=new LogicManager(dtoEa.getEaRunTimeParameters());
        logicManager.filterCourses(dtoEa.getPref());
        return logicManager.startEngine();
    }


}
