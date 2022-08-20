package logic;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CoursesDemoFactory
{




    public static List<Course> createCourses() {



        List<Course>res = new ArrayList<Course>();





        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> logicGroups = new ArrayList<Group>();
        List<Lesson> logicPractices = new ArrayList<Lesson>();
        List<Lesson> logicLessonsG1= new ArrayList<Lesson>();

        //for new lesson
        Lesson logiclesson1G1=new Lesson(Days.SUNDAY, new RangeTime(LocalTime.of(9, 15),LocalTime.of(11, 45)));
        logicLessonsG1.add(logiclesson1G1);
        //

        Group logicGroup1=new Group(logicLessonsG1);
        logicGroups.add(logicGroup1);
        //////////////////////another group


        List<Lesson> logicLessonsG2= new ArrayList<Lesson>();

        Lesson logiclesson1G2=new Lesson(Days.MONDAY, new RangeTime(LocalTime.of(8, 15),LocalTime.of(10, 45)));
        logicLessonsG1.add(logiclesson1G2);


        Group logicGroup2=new Group(logicLessonsG1);
        logicGroups.add(logicGroup2);
        /////



        Date logicTestA = new Date(2022,1,17);
        Date logicTestB = new Date(2022,2,7);


        Lesson logicPractice1=new Lesson(Days.WEDNESDAY, new RangeTime(LocalTime.of(14, 15),LocalTime.of(15, 45)));
        logicPractices.add(logicPractice1);


        Course logic = new Course("Logic",4,7,logicGroups,logicTestA,logicTestB,true,logicPractices);
        res.add(logic);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        List<Group> osGroups = new ArrayList<Group>();
        List<Lesson> osPractices = new ArrayList<Lesson>();
        List<Lesson> osLessonsG1= new ArrayList<Lesson>();

        //for new lesson
        Lesson oslesson1G1=new Lesson(Days.SUNDAY, new RangeTime(LocalTime.of(9, 15),LocalTime.of(11, 45)));
        osLessonsG1.add(oslesson1G1);
        //

        Group osGroup1=new Group(osLessonsG1);
        osGroups.add(osGroup1);
        //////////////////////another group


        List<Lesson> osLessonsG2= new ArrayList<Lesson>();

        Lesson oslesson1G2=new Lesson(Days.FRIDAY, new RangeTime(LocalTime.of(10, 15),LocalTime.of(12, 45)));
        osLessonsG1.add(oslesson1G2);


        Group osGroup2=new Group(osLessonsG1);
        osGroups.add(osGroup2);
        /////



        Date osTestA = new Date(2022,1,17);
        Date osTestB = new Date(2022,2,7);


        Lesson osPractice1=new Lesson(Days.THURSDAY, new RangeTime(LocalTime.of(10, 00),LocalTime.of(11, 45)));
        osPractices.add(osPractice1);


        Course os = new Course("os",5,8,osGroups,osTestA,osTestB,true,osPractices);

        res.add(os);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        List<Group> compGroups = new ArrayList<Group>();
        List<Lesson> compPractices = new ArrayList<Lesson>();
        List<Lesson> compLessonsG1= new ArrayList<Lesson>();
        List<Lesson> compLessonsG2= new ArrayList<Lesson>();

        //for new lesson
        Lesson complesson1G1=new Lesson(Days.WEDNESDAY, new RangeTime(LocalTime.of(11, 00),LocalTime.of(12, 45)));
        compLessonsG1.add(complesson1G1);
        //

        Group compGroup1=new Group(compLessonsG1);
        compGroups.add(compGroup1);
        //////////////////////another group




        Lesson complesson1G2=new Lesson(Days.THURSDAY, new RangeTime(LocalTime.of(10, 15),LocalTime.of(12, 00)));
        compLessonsG1.add(complesson1G2);


        Group compGroup2=new Group(compLessonsG1);
        compGroups.add(compGroup2);
        /////



        Date compTestA = new Date(2022,1,25);
        Date compTestB = new Date(2022,2,13);


        //Lesson compPractice1=new Lesson(Days.THURSDAY, new TimeRange(LocalTime.of(10, 00),LocalTime.of(11, 45)));
        //compPractices.add(compPractice1);


        Course comp = new Course("comp",5,8,compGroups,compTestA,compTestB,true,compPractices);

        res.add(comp);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



        List<Group> dataBasesGroups = new ArrayList<Group>();
        List<Lesson> dataBasesPractices = new ArrayList<Lesson>();
        List<Lesson> dataBasesLessonsG1= new ArrayList<Lesson>();
        List<Lesson> dataBasesLessonsG2= new ArrayList<Lesson>();

        //for new lesson
        Lesson dataBaseslesson1G1=new Lesson(Days.SUNDAY, new RangeTime(LocalTime.of(14, 00),LocalTime.of(16, 45)));
        dataBasesLessonsG1.add(dataBaseslesson1G1);
        //

        Group dataBasesGroup1=new Group(dataBasesLessonsG1);
        dataBasesGroups.add(dataBasesGroup1);
        //////////////////////another group




        Lesson dataBaseslesson1G2=new Lesson(Days.WEDNESDAY, new RangeTime(LocalTime.of(13, 00),LocalTime.of(14, 45)));
        dataBasesLessonsG1.add(dataBaseslesson1G2);


        Group dataBasesGroup2=new Group(dataBasesLessonsG1);
        dataBasesGroups.add(dataBasesGroup2);
        /////



        Date dataBasesTestA = new Date(2022,1,28);
        Date dataBasesTestB = new Date(2022,2,14);


        // Lesson dataBasesPractice1=new Lesson(Days.THURSDAY, new TimeRange(LocalTime.of(10, 00),LocalTime.of(11, 45)));//dataBasesPractices.add(dataBasesPractice1);


        Course dataBases = new Course("dataBases",4,6,dataBasesGroups,dataBasesTestA,dataBasesTestB,true,dataBasesPractices);

        res.add(dataBases);

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




        List<Group> networkingGroups = new ArrayList<Group>();
        List<Lesson> networkingPractices = new ArrayList<Lesson>();
        List<Lesson> networkingLessonsG1= new ArrayList<Lesson>();
        List<Lesson> networkingLessonsG2= new ArrayList<Lesson>();

        //for new lesson
        Lesson networkinglesson1G1=new Lesson(Days.MONDAY, new RangeTime(LocalTime.of(9, 45),LocalTime.of(12, 30)));
        networkingLessonsG1.add(networkinglesson1G1);
        //

        Group networkingGroup1=new Group(networkingLessonsG1);
        networkingGroups.add(networkingGroup1);
        //////////////////////another group




        Lesson networkinglesson1G2=new Lesson(Days.TUESDAY, new RangeTime(LocalTime.of(12, 30),LocalTime.of(14, 00)));
        networkingLessonsG1.add(networkinglesson1G2);


        Group networkingGroup2=new Group(networkingLessonsG1);
        networkingGroups.add(networkingGroup2);
        /////



        Date networkingTestA = new Date(2022,2,1);
        Date networkingTestB = new Date(2022,2,25);


        //Lesson networkingPractice1=new Lesson(Days.THURSDAY, new TimeRange(LocalTime.of(10, 00),LocalTime.of(11, 45)));
        //networkingPractices.add(networkingPractice1);


        Course networking = new Course("networking",4,7,networkingGroups,networkingTestA,networkingTestB,true,networkingPractices);

        res.add(networking);





        return res;
    }


}
