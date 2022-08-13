package logic;

import EA.EAManager;

import java.util.ArrayList;
import java.util.List;


public class LogicManager
{


    private EAManager EAEngineManager;
    private List<Course> filteredCourses;
    //private Preferences pref;
    private EaRunTimeParameters eaRunTimeParameters;

    public LogicManager(EaRunTimeParameters eaRunTimeParameters){
        this.eaRunTimeParameters=eaRunTimeParameters;
    }

    public void filterCourses(Preferences pref)
    {
        List<Course>res = new ArrayList<Course>();
        for(Course currCourse : pref.getPrefCourse())
        {
            Course newCourse = new Course(currCourse.getCourseName(),currCourse.getCredits(),currCourse.getDifficulty(),currCourse.getTestA(),currCourse.getTestB(),currCourse.getMandatory());


            for(Group currGroup : currCourse.getGroups()){

                Group newGroup = isAllLessonAvailableInAGroup(currGroup, pref.getUnavailablityWeekSchedule());

                if(newGroup != null)
                {
                    newCourse.addGroup(newGroup);
                }

            }

            for(Lesson practice: currCourse.getCoursePractices()) //todo: fix coursePractice is null
            {

                if (pref.getUnavailablityWeekSchedule().isAvailabile(practice.getDay(), practice.getRangeTime()))
                {
                    newCourse.addCoursePractice(practice);
                }

            }

            if(newCourse.getGroups().size() > 0 && newCourse.getCoursePractices().size() > 0)
            {
                res.add(newCourse);
            }



        }

        setFilteredCourses(res);
        EAEngineManager = new EAManager(res, pref,eaRunTimeParameters);

    }




    public Group isAllLessonAvailableInAGroup(Group group, WeekSchedule unAvailableAt)
    {
        Group newGroup = new Group();

        for(Lesson currLesson : group.getLessons())
        {
            if (unAvailableAt.isAvailabile(currLesson.getDay(), currLesson.getRangeTime()))
            {
                newGroup.addLesson(currLesson);
            }

            else
            {
                return null;
            }

        }
        return newGroup;
    }


    public void setFilteredCourses(List<Course> courses)
    {


        filteredCourses = courses;


    }

    public Schedule startEngine()
    {

        return EAEngineManager.runEngine(filteredCourses, eaRunTimeParameters);

    }

    /*
    public List<Course> getValidCourses()
    {

        return this.filteredCourses;

    }

     */



}
