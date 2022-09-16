package workshopea.webserver.engine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.uncommons.maths.random.Probability;

import com.google.gson.Gson;

import dto.DtoEA;
import dto.DtoStrategy;
import dto.DtoTerminationCondition;
import logic.Course;
import logic.CourseRepository;
import logic.EaRunTimeParameters;
import logic.LogicManager;
import logic.Preferences;
import logic.RangeTime;
import logic.Schedule;
import logic.WeekSchedule;
import workshopea.webserver.courses.CoursesService;
import workshopea.webserver.exception.CourseException;

@Service
public class EngineService {

    @Autowired
    private CoursesService coursesService;
    private Gson gson = new Gson();
    
    @Autowired
    CourseRepository courseRepo;

    public Schedule getWinningSchedule(String dtoEaJson) throws Exception {
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
    
    public Schedule getWinningSchedule(DtoEAModel dtoEa) throws Exception {
        /*
        Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> courses = gson.fromJson(coursesJson , userListType);
        return courses;
         */
    	
//    	float intensity, int percentageIntensity,
//        float minCredits, int percentageMinCredits,
//        List<Course> prefCourse,
//        float maxHoursForStudyingInWeek, int percentageMaxHoursForStudyingInWeek,
//        WeekSchedule unavailablityWeekSchedule,
//        List<Course> mustHaveCourses
    	
    	WeekSchedule weekSchedule = new WeekSchedule();
    	WeekScheduleModel weekScheduleModel = dtoEa.getPref().getUnavailablityWeekSchedule();
    	List<DayScheduleModel> dayScheduleList = weekScheduleModel.getWeekSchedule();
    	for(DayScheduleModel daySchedule : dayScheduleList) {
    		RangeTime range = new RangeTime(daySchedule.getListStartEnd().get(0).getStartTime(), daySchedule.getListStartEnd().get(0).getEndTime());
    		weekSchedule.insertNewRange(daySchedule.getDay(), range);
    	}
    	
    	
    	Preferences pref = new Preferences(dtoEa.getPref().getIntensity(),
    			dtoEa.getPref().getPercentageIntensity(), 
    			dtoEa.getPref().getMinCredits(),
    			dtoEa.getPref().getPercentageMinCredits(), 
    			dtoEa.getPref().getPrefCourse(), 
    			dtoEa.getPref().getMaxHoursForStudyingInWeek(),
    			dtoEa.getPref().getPercentageMaxHoursForStudyingInWeek(),
    			weekSchedule, 
    			dtoEa.getPref().getMustHaveCourses());
    	
    	EaRunTimeParametersModel eaRunTimeParamModel = dtoEa.getEaRunTimeParameters();
    	
    	DtoStrategy dtoStrategy = new DtoStrategy(eaRunTimeParamModel.getDtoStrategy().getStrategy(),
    			new Probability(eaRunTimeParamModel.getDtoStrategy().getTournamentProbability()),
    			eaRunTimeParamModel.getDtoStrategy().getTruncateSelectionRatio());
    	
    	
//    	TerminationConditions terminationCondition, long maxDuration,
//    	boolean naturalFitness, double targetFitness, boolean natural, 
//    	int generationCount, int generationLimit
    	
    	
    	DtoTerminationCondition dtoTerm = new DtoTerminationCondition(
    			eaRunTimeParamModel.getDtoTerminationCondition().getTerminationCondition(),
    			eaRunTimeParamModel.getDtoTerminationCondition().getMaxDuration(), 
    			eaRunTimeParamModel.getDtoTerminationCondition().isNaturalFitness(),
    			eaRunTimeParamModel.getDtoTerminationCondition().getTargetFitness(), 
    			eaRunTimeParamModel.getDtoTerminationCondition().isNatural(),
    			eaRunTimeParamModel.getDtoTerminationCondition().getGenerationCount(),
    			eaRunTimeParamModel.getDtoTerminationCondition().getGenerationLimit());
    	
    	EaRunTimeParameters param = new EaRunTimeParameters(dtoStrategy, dtoTerm, 
    			eaRunTimeParamModel.getPopulationSize(), eaRunTimeParamModel.getEliteCount());
    	
     //  DtoEA dtoEa = gson.fromJson(dtoEaJson, DtoEA.class);
//       List<Course> courses = new ArrayList<Course>();
//    	for(Course each : dtoEa.getCourses()) {
//    		Course course = courseRepo.findByCourseName(each.getCourseName());
//    		courses.add(course);
//    	}
    	System.out.println("=======================================");
    	System.out.println("course before running: "+dtoEa.getCourses());
    	System.out.println("=======================================");
        DtoEA dto= new DtoEA(dtoEa.getCourses(), pref, param) ;
        System.out.println(dto);

        LogicManager logicManager=new LogicManager(dto.getEaRunTimeParameters());
        logicManager.filterCourses(dto.getPref());
        //List<Course> courseList = new ArrayList<Course>();
        try {
        	Schedule startEngine = logicManager.startEngine();
//        	for(Course each : startEngine.getCourses()) {
//        		Course course = courseRepo.findByCourseName(each.getCourseName());
//        		courseList.add(course);
//        	}
//        	startEngine.setCourses(courseList);
        	return startEngine;
        } catch(Exception e) {
        	e.printStackTrace();
        	throw new CourseException(e.getMessage());
        }
        
    }


}
