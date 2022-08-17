package workshopea.webserver.courses;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

//what is the URL that you are mapping into and what should happen when the request comes to that URL
@RestController
public class CoursesController {

    //linking the singleton (in this case) CoursesService that the spring boot create for us
    @Autowired
    private CoursesService coursesService;

    //this annotation that if you will come with URL ../addCourse, tou will execute this method
    //the @RequestMapping maps only to the GET method by default.
    //to map other HTTP methods you'll have to specify it in the annotation
    @RequestMapping("/courses")
    public List<Course> getCourses() {

         Gson gson = new Gson();
         List<Course> res = coursesService.getAllCourses();
          String s = gson.toJson(res);
        System.out.println(s);
        return res;

    }

    // {XXX} means we want to be able to get URL dynamically by variable. in this case XXX=courseName.
    //the name in {} must be the same as the variable after the @PathVariable - who connect them.
    //other option is:
    //    @RequestMapping("/course/{foo}")
    //    public Course getCourse(@PathVariable("foo") String courseName)
    //by doing that you mean that foo in the URL is courseName as variable
    @RequestMapping("/courses/{courseName}")
    public Course getCourse(@PathVariable String courseName){
        return coursesService.getCourseByName(courseName);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCoursesFromJson(@RequestBody String coursesJson){
        coursesService.addAllByJson(coursesJson);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/courses")
    public void updateCourse(@RequestBody String courseJson){
        coursesService.update(courseJson);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses")
    public void deleteCourse(@RequestBody String coursesNameJson){
        Type userListType = new TypeToken<ArrayList<String>>(){}.getType();
        List<String> coursesName = coursesService.getGson().fromJson(coursesNameJson,userListType);
        coursesService.delete(coursesName);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/courses/deleteAll")
    public void deleteCourse(){
        coursesService.deleteAll();
    }
}
