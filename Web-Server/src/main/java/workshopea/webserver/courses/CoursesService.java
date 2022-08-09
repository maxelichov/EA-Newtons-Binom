package workshopea.webserver.courses;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import logic.Course;
import logic.Group;
import logic.Practice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//This means that it is a class designed to serve spring boot operations.
//When the spring boot comes up, it creates a singleton from this class because the annotation
@Service
public class CoursesService {

    //Arrays.asList(
    //            new Course("logic", 4, 6, null, null, null, true, null),
    //            new Course("java", 4, 6, null, null, null, true, null),
    //            new Course("CPP", 4, 6, null, null, null, true, null),
    //            new Course("calculus", 4, 8, null, null, null, true, null)
    //    )
    private List<Course> coursesList = new ArrayList<Course>();
    private Gson gson=new Gson();

    public List<Course> getAllCourses(){
        return coursesList;
    }


    public Course getCourseByName(String courseName) {
        return coursesList.stream().filter(t->t.isSameName(courseName)).findFirst().get();
    }

    public List<String> addAllByJson(String coursesJson) {
        Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> courses = gson.fromJson(coursesJson , userListType);

        List<String> res = new ArrayList<String>();

        List<String> coursesName = coursesName();

        for(Course newCourse : courses){
            if(coursesName.contains(newCourse.getCourseName())){
                for(int i=0; i<coursesList.size(); i++){
                    if(newCourse.getCourseName().equalsIgnoreCase(coursesList.get(i).getCourseName())) {
                        coursesList.get(i).addGroupsWithoutDup(newCourse.getGroups());
                        res.add(newCourse.getCourseName());
                    }
                }
            }else{
                coursesList.add(newCourse);
            }
        }
        return res;
    }

    private List<String> coursesName() {
        List<String> res = new ArrayList<String>();
        for(Course course : coursesList){
            res.add(course.getCourseName());
        }
        return res;
    }


    public void update(String courseJson) {
        Course course=gson.fromJson(courseJson, Course.class);
        delete(Arrays.asList(course.getCourseName()));
        coursesList.add(course);
    }

    public void delete(List<String> coursesName) {
        coursesList.removeIf(t->coursesName.contains(t.getCourseName()));
    }

    public void deleteAll() {
        coursesList.removeAll(coursesList);
    }


    public Gson getGson() {
        return gson;
    }
}
