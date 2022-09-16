package workshopea.webserver.courses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.google.gson.Gson;

import logic.Course;
import logic.CourseRepository;
import logic.Group;
import logic.Lesson;
import logic.RangeTime;

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
	
	@Autowired
	CourseRepository courseRepo;
	
//    private List<Course> coursesList = new ArrayList<Course>();
    private Gson gson=new Gson();

    @CrossOrigin(origins = "http://localhost:3000")
    public List<Course> getAllCourses(){
        return courseRepo.findAll();
    }
    
    public Course addCourse(CourseModel courseModel){
    	System.out.println("courseModel.getMandatory()=="+courseModel.getIsMandatory());
    	Course course = new Course();
    	course.setCourseName(courseModel.getCourseName());
    	course.setCredits(courseModel.getCredits());
    	course.setDifficulty(courseModel.getDifficulty());
    	course.setIsMandatory(courseModel.getIsMandatory());
    	course.setTestA(courseModel.getTestA());
    	course.setTestB(courseModel.getTestB());
    	
    	List<Group> groupList = new ArrayList<Group>();
    	List<GroupModel> groups = courseModel.getGroups();
    	for(GroupModel each : groups) {
    		Group group = new Group();
    		group.setCourse(course);
    		
    		List<LessonModel> lessons = each.getLessons();
    		List<Lesson> lessonList = new ArrayList<Lesson>();
    		for(LessonModel eachLesson : lessons) {
    			Lesson lesson = new Lesson();
    			lesson.setDay(eachLesson.getDay());
    			if(eachLesson.getTimeRange() != null) {
    				RangeTime time = new RangeTime(eachLesson.getTimeRange().getStartTime(), eachLesson.getTimeRange().getEndTime());
	    			lesson.setTimeRange(time);
    			}
    			lesson.setGroup(group);
    			lessonList.add(lesson);
    		}
    		group.setLessons(lessonList);
    		groupList.add(group);
    	}
    	course.setGroups(groupList);
    	
    	
    	List<LessonModel> practiceLessons = courseModel.getPractice();
		List<Lesson> practiceLessonList = new ArrayList<Lesson>();
		for(LessonModel eachLesson : practiceLessons) {
			Lesson lesson = new Lesson();
			lesson.setDay(eachLesson.getDay());
			if(eachLesson.getTimeRange() != null) {
				RangeTime time = new RangeTime(eachLesson.getTimeRange().getStartTime(), eachLesson.getTimeRange().getEndTime());
    			lesson.setTimeRange(time);
			}
			lesson.setCourse(course);
			practiceLessonList.add(lesson);
		}
		course.setPractices(practiceLessonList);
        return courseRepo.save(course);
    }
    
    
    public Course updateCourse(long id, CourseModel courseModel) {
    	Course course = courseRepo.findById(id).get();
    	course.setCourseName(courseModel.getCourseName());
    	course.setCredits(courseModel.getCredits());
    	course.setDifficulty(courseModel.getDifficulty());
    	course.setIsMandatory(courseModel.getIsMandatory());
    	course.setTestA(courseModel.getTestA());
    	course.setTestB(courseModel.getTestB());
    	course.getPractices().clear();
    	course.getGroups().clear();
    	
    	List<Group> groupList = new ArrayList<Group>();
    	List<GroupModel> groups = courseModel.getGroups();
    	for(GroupModel each : groups) {
    		Group group = new Group();
    		group.setCourse(course);
    		
    		List<LessonModel> lessons = each.getLessons();
    		List<Lesson> lessonList = new ArrayList<Lesson>();
    		for(LessonModel eachLesson : lessons) {
    			Lesson lesson = new Lesson();
    			lesson.setDay(eachLesson.getDay());
    			if(eachLesson.getTimeRange() != null) {
    				RangeTime time = new RangeTime(eachLesson.getTimeRange().getStartTime(), eachLesson.getTimeRange().getEndTime());
	    			lesson.setTimeRange(time);
    			}
    			lesson.setGroup(group);
    			lessonList.add(lesson);
    		}
    		group.setLessons(lessonList);
    		groupList.add(group);
    	}
    	course.getGroups().addAll(groupList);
    	
    	
    	List<LessonModel> practiceLessons = courseModel.getPractice();
		List<Lesson> practiceLessonList = new ArrayList<Lesson>();
		for(LessonModel eachLesson : practiceLessons) {
			Lesson lesson = new Lesson();
			lesson.setDay(eachLesson.getDay());
			if(eachLesson.getTimeRange() != null) {
				RangeTime time = new RangeTime(eachLesson.getTimeRange().getStartTime(), eachLesson.getTimeRange().getEndTime());
    			lesson.setTimeRange(time);
			}
			lesson.setCourse(course);
			practiceLessonList.add(lesson);
		}
		course.getPractices().addAll(practiceLessonList);
    	
    	return courseRepo.save(course);
	}
    
    public void deleteCourses(DeleteCoursesModel courseIds) {
    	courseRepo.deleteAllById(courseIds.getCourseIds());
	}
    
    public Course getCourse(long id) {
    	return courseRepo.findById(id).get();
	}


//    public Course getCourseByName(String courseName) {
//        return coursesList.stream().filter(t->t.isSameName(courseName)).findFirst().get();
//    }
//
//    public List<String> addAllByJson(String coursesJson) {
//        Type userListType = new TypeToken<ArrayList<logic.Course>>(){}.getType();
//        ArrayList<logic.Course> courses = gson.fromJson(coursesJson , userListType);
//        List<String> res = new ArrayList<String>();
//
//        List<String> coursesName = coursesName();
//
//        for(logic.Course newCourse : courses){
//            if(coursesName.contains(newCourse.getCourseName())){
//                for(int i=0; i<coursesList.size(); i++){
//                    if(newCourse.getCourseName().equalsIgnoreCase(coursesList.get(i).getCourseName())) {
//                        coursesList.get(i).addGroupsWithoutDup(newCourse.getGroups());
//                        coursesList.get(i).addPracticeWithoutDup(newCourse.getCoursePractices());
//                        res.add(newCourse.getCourseName());
//                    }
//                }
//            }else{
//                coursesList.add(newCourse);
//            }
//        }
//        return res;
//    }
//
//    private List<String> coursesName() {
//        List<String> res = new ArrayList<String>();
//        for(logic.Course course : coursesList){
//            res.add(course.getCourseName());
//        }
//        return res;
//    }
//
//
//    public void update(String courseJson) {
//        Course course=gson.fromJson(courseJson, Course.class);
//        delete(Arrays.asList(course.getCourseName()));
//        coursesList.add(course);
//    }
//
//    public void delete(List<String> coursesName) {
//        coursesList.removeIf(t->coursesName.contains(t.getCourseName()));
//    }
//
//    public void deleteAll() {
//        coursesList.removeAll(coursesList);
//    }


    public Gson getGson() {
        return gson;
    }

	

	

	
}
