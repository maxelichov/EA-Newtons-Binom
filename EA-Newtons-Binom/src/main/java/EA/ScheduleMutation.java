package EA;

import logic.Course;
import logic.Group;
import logic.Lesson;
import logic.Schedule;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;




public class ScheduleMutation implements EvolutionaryOperator<Schedule>
{


    private final List<Course> mustHaveCourses;
    private List<Course> filteredCourses;


    public ScheduleMutation(Probability probability, Probability probability1, List<Course> courses , List<Course>mustHaveCourses)
    {
        filteredCourses=courses;
        this.mustHaveCourses=mustHaveCourses;
    }




    // TODO: all possible mutations:
    //1. change group
    //2. change course
    //3. add course
    //4. drop course




    @Override
    public List<Schedule> apply(List<Schedule> list, Random random)
    {

        //TODO:It is important to note that this method operates on the list of candidates returned by the selection
        // strategy and not on the current population
        // . Each entry in the list (not each individual - the list may contain the same individual more than once) must be operated on exactly once.

        //list contains the all the schedules individuals

        List<Schedule> res = cloneSchedules(list);






        for(Schedule currSchedule:res)
        {
            int num=random.nextInt(101);

            switch (num)
            {
                case 0:
                {
                    mutationRemoveCourse(currSchedule);
                    break;
                }
                case 1:
                {
                    mutationAddCourse(currSchedule);
                    break;
                }
                case 2:
                {
                    mutationChangeCourse(currSchedule);
                }
                case 3:
                {
                    mutationChangeGroup(currSchedule);
                }
                case 4:
                    mutationChangePractice(currSchedule);
                default:
                {
                    //System.out.println("some problem. its never can get here!");
                }

            }

        }

        return res;
    }

    private void mutationChangePractice(Schedule currSchedule)
    {
        Random rnd=new Random();
        Course course = null;

        if(currSchedule.getCourses().size() != 0)
        {
            course = currSchedule.getCourses().get(rnd.nextInt(currSchedule.getCourses().size()));
        }
        
        else
        {
            return;
        }

        for(Course currCourse: filteredCourses)
        {
            if(currCourse.isSameName(course.getCourseName())){
                Lesson newPractice = null;
                try
                {
                    if(currCourse.getCoursePractices().size()==0){
                        return;
                    }
                    newPractice = (Lesson) currCourse.getCoursePractices().get(rnd.nextInt(currCourse.getCoursePractices().size())).clone();
                    List<Lesson> newPracticeList=new ArrayList<Lesson>();
                    newPracticeList.add(newPractice);
                    course.setPractices(newPracticeList);
                } catch (CloneNotSupportedException e)
                {
                    e.printStackTrace();
                }
                break;
            }
        }
    }


    private void mutationChangeGroup(Schedule currSchedule)
    {
        Random rnd=new Random();
        Course course = null;
      if(currSchedule.getCourses().size() != 0)
      {
          course = currSchedule.getCourses().get(rnd.nextInt(currSchedule.getCourses().size()));


      }

      else {
          return;
      }

        for(Course currCourse: filteredCourses)
        {
            if(currCourse.isSameName(course.getCourseName())){
                Group newGroup = null;
                try
                {
                    newGroup = (Group) currCourse.getGroups().get(rnd.nextInt(currCourse.getGroups().size())).clone();
                    List<Group> newListGroup=new ArrayList<Group>();
                    newListGroup.add(newGroup);
                    course.setGroups(newListGroup);
                } catch (CloneNotSupportedException e)
                {
                    e.printStackTrace();
                }
                break;
            }
        }
    }



    private void mutationChangeCourse(Schedule currSchedule)
    {
        Random rnd=new Random();

       if(currSchedule.getCourses().size() != 0)
       {
           Course courseAboutToBeRemoved=currSchedule.getCourses().get(rnd.nextInt(currSchedule.getCourses().size()));
           if(! isInMustHaveCourse(courseAboutToBeRemoved)){
               currSchedule.removeCourse(courseAboutToBeRemoved);
               currSchedule.addCourseToSchedule(createRandomCourseFromFilterList());
           }

       }

    }

    private void mutationRemoveCourse(Schedule currSchedule)
    {

        Random randomCourse=new Random();

        if(currSchedule.getCourses().size() != 0)
        {

            Course courseForRemove = currSchedule.getCourses().get(randomCourse.nextInt(currSchedule.getCourses().size()));
            if(! isInMustHaveCourse(courseForRemove)){
                currSchedule.removeCourse(courseForRemove);
            }
        }


    }


    private boolean isInMustHaveCourse(Course course) {
        for(Course mustHaveCourse : mustHaveCourses){
            if(course.isSameName(mustHaveCourse.getCourseName())){
                return true;
            }
        }
        return false;
    }

    private void mutationAddCourse(Schedule currSchedule)
    {
        currSchedule.addCourseToSchedule(createRandomCourseFromFilterList());
    }

    private List<Schedule> cloneSchedules(List<Schedule> listOfIndividuals)
    {
        List<Schedule> res = new ArrayList<Schedule>(listOfIndividuals.size());

        for (Schedule clonedSchedule: listOfIndividuals)
        {

            try {


                res.add((Schedule)clonedSchedule.clone());

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


        }

        return res;
    }

    private Course createRandomCourseFromFilterList()
    {
        Random rnd = new Random();
        Course course = null;
        try
        {
            course = (Course) filteredCourses.get(rnd.nextInt(filteredCourses.size())).clone();
        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        Group group = course.getGroups().get(rnd.nextInt(course.getGroups().size()));
        List<Group> newListGroup = new ArrayList<Group>();
        newListGroup.add(group);
        course.setGroups(newListGroup);
        return course;
    }

}



