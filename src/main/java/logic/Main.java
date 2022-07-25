package logic;

//import com.google.gson.Gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main
{

    public static void main(String[] args)
    {

        /*
        todo
        1. work with files
        2. servers
        3. ui platform
        4. let user to control evolution setting
         */
        LogicManager logicManager = new LogicManager();

        WeekSchedule WeekSchedule= new WeekSchedule();
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(16, 00),LocalTime.of(00, 00)));
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(00, 00),LocalTime.of(17, 00)));
        WeekSchedule.insertNewRange(Days.THURSDAY, new TimeRange(LocalTime.of(7, 00),LocalTime.of(23, 59)));


        List<Course> courses = new ArrayList<Course>();

        List<Lesson> logicLList1=new ArrayList<Lesson>();
        logicLList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(9,15),LocalTime.of(11,45))));
        Group logicG1=new Group(logicLList1);
        List<Group> logicGList = new ArrayList<Group>();
        logicGList.add(logicG1);

        List<Lesson> logicLList2=new ArrayList<Lesson>();
        logicLList2.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(10,45))));
        Group logicG2=new Group(logicLList2);
        logicGList.add(logicG2);

        List<Lesson> logicLList3=new ArrayList<Lesson>();
        logicLList3.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(14,45))));
        Group logicG3=new Group(logicLList3);
        logicGList.add(logicG3);

        List<Lesson> logicLList4=new ArrayList<Lesson>();
        logicLList4.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(9,15),LocalTime.of(12,45))));
        Group logicG4=new Group(logicLList4);
        logicGList.add(logicG4);


        List<Lesson> logicLList5=new ArrayList<Lesson>();
        logicLList5.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(16,15),LocalTime.of(18,45))));
        Group logicG5=new Group(logicLList5);
        logicGList.add(logicG5);

        Course logic=new Course("logic",4,7,logicGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(logic);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> reasoningGList = new ArrayList<Group>();
        List<Lesson> reasoningLList1, reasoningLList2, reasoningLList3, reasoningLList4, reasoningLList5;
        Group reasoningG1, reasoningG2, reasoningG3, reasoningG4, reasoningG5;
        Course reasoning;


        reasoningLList1=new ArrayList<Lesson>();
        reasoningLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(12,45))));
        reasoningG1=new Group(reasoningLList1);
        reasoningGList.add(reasoningG1);

        reasoningLList2=new ArrayList<Lesson>();
        reasoningLList2.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(13,45))));
        reasoningG2=new Group(reasoningLList2);
        reasoningGList.add(reasoningG2);

        reasoningLList3=new ArrayList<Lesson>();
        reasoningLList3.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(9,15),LocalTime.of(11,45))));
        reasoningG3=new Group(reasoningLList3);
        reasoningGList.add(reasoningG3);

        reasoningLList4=new ArrayList<Lesson>();
        reasoningLList4.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(10,45))));
        reasoningG4=new Group(reasoningLList4);
        reasoningGList.add(reasoningG4);

        reasoningLList5=new ArrayList<Lesson>();
        reasoningLList5.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(19,15),LocalTime.of(21,45))));
        reasoningG5=new Group(reasoningLList5);
        reasoningGList.add(reasoningG5);


        reasoning=new Course("reasoning",3,7,reasoningGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(reasoning);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<Group> calculus1GList = new ArrayList<Group>();
        List<Lesson> calculus1LList1, calculus1LList2, calculus1LList3, calculus1LList4;
        Group calculus1G1, calculus1G2, calculus1G3, calculus1G4;
        Course calculus1;


        calculus1LList1=new ArrayList<Lesson>();
        calculus1LList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        calculus1LList1.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(9,45))));
        calculus1G1=new Group(calculus1LList1);
        calculus1GList.add(calculus1G1);

        calculus1LList2=new ArrayList<Lesson>();
        calculus1LList2.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        calculus1LList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        calculus1G2=new Group(calculus1LList2);
        calculus1GList.add(calculus1G2);

        calculus1LList3=new ArrayList<Lesson>();
        calculus1LList3.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        calculus1LList3.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        calculus1G3=new Group(calculus1LList3);
        calculus1GList.add(calculus1G3);

        calculus1LList4=new ArrayList<Lesson>();
        calculus1LList4.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        calculus1LList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(14,15),LocalTime.of(15,45))));
        calculus1G4=new Group(calculus1LList4);
        calculus1GList.add(calculus1G4);



        calculus1=new Course("calculus1",4,7,calculus1GList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(calculus1);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<Group> computerScienceIntroductionGList = new ArrayList<Group>();
        List<Lesson> computerScienceIntroductionLList1, computerScienceIntroductionLList2, computerScienceIntroductionLList3, computerScienceIntroductionLList4, computerScienceIntroductionLList5;
        Group computerScienceIntroductionG1, computerScienceIntroductionG2, computerScienceIntroductionG3, computerScienceIntroductionG4, computerScienceIntroductionG5;
        Course computerScienceIntroduction;


        computerScienceIntroductionLList1=new ArrayList<Lesson>();
        computerScienceIntroductionLList1.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(13,45))));
        computerScienceIntroductionLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        computerScienceIntroductionG1=new Group(computerScienceIntroductionLList1);
        computerScienceIntroductionGList.add(computerScienceIntroductionG1);

        computerScienceIntroductionLList2=new ArrayList<Lesson>();
        computerScienceIntroductionLList2.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(12,45))));
        computerScienceIntroductionLList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        computerScienceIntroductionG2=new Group(computerScienceIntroductionLList2);
        computerScienceIntroductionGList.add(computerScienceIntroductionG2);

        computerScienceIntroductionLList3=new ArrayList<Lesson>();
        computerScienceIntroductionLList3.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        computerScienceIntroductionLList3.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(14,45))));
        computerScienceIntroductionG3=new Group(computerScienceIntroductionLList3);
        computerScienceIntroductionGList.add(computerScienceIntroductionG3);

        computerScienceIntroductionLList4=new ArrayList<Lesson>();
        computerScienceIntroductionLList4.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(9,15),LocalTime.of(11,45))));
        computerScienceIntroductionLList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        computerScienceIntroductionG4=new Group(computerScienceIntroductionLList4);
        computerScienceIntroductionGList.add(computerScienceIntroductionG4);

        computerScienceIntroductionLList5=new ArrayList<Lesson>();
        computerScienceIntroductionLList5.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(15,45))));
        computerScienceIntroductionLList5.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(8,30),LocalTime.of(10,00))));
        computerScienceIntroductionG5=new Group(computerScienceIntroductionLList5);
        computerScienceIntroductionGList.add(computerScienceIntroductionG5);



        computerScienceIntroduction=new Course("computerScienceIntroduction",5,7,computerScienceIntroductionGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(computerScienceIntroduction);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> linearGList = new ArrayList<Group>();
        List<Lesson> linearLList1, linearLList2, linearLList3, linearLList4, linearLList5;
        Group linearG1, linearG2, linearG3, linearG4, linearG5;
        Course linear;


        linearLList1=new ArrayList<Lesson>();
        linearLList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(14,30))));
        linearLList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        linearG1=new Group(linearLList1);
        linearGList.add(linearG1);

        linearLList2=new ArrayList<Lesson>();
        linearLList2.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(13,30),LocalTime.of(15,00))));
        linearLList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(8,00),LocalTime.of(9,30))));
        linearG2=new Group(linearLList2);
        linearGList.add(linearG2);

        linearLList3=new ArrayList<Lesson>();
        linearLList3.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(9,45))));
        linearLList3.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        linearG3=new Group(linearLList3);
        linearGList.add(linearG3);

        linearLList4=new ArrayList<Lesson>();
        linearLList4.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        linearLList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        linearG4=new Group(linearLList4);
        linearGList.add(linearG4);

        linearLList5=new ArrayList<Lesson>();
        linearLList5.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(15,15),LocalTime.of(16,45))));
        linearLList5.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        linearG5=new Group(linearLList5);
        linearGList.add(linearG5);



        linear=new Course("linear",6,7,linearGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(linear);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> logic2GList = new ArrayList<Group>();
        List<Lesson> logic2LList1;
        Group logic2G1;
        Course logic2;


        logic2LList1=new ArrayList<Lesson>();
        logic2LList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(12,45))));
        logic2G1=new Group(logic2LList1);
        logic2GList.add(logic2G1);

        logic2=new Course("logic2",4,7,linearGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(logic2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> introductionToProbabilityGList = new ArrayList<Group>();
        List<Lesson> introductionToProbabilityLList1;
        Group introductionToProbabilityG1;
        Course introductionToProbability;


        introductionToProbabilityLList1=new ArrayList<Lesson>();
        introductionToProbabilityLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(17,45))));
        introductionToProbabilityG1=new Group(introductionToProbabilityLList1);
        introductionToProbabilityGList.add(introductionToProbabilityG1);

        introductionToProbability=new Course("Introduction To Probability",4,7,linearGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(introductionToProbability);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> advancedProgrammingCGList = new ArrayList<Group>();
        List<Lesson> advancedProgrammingCLList1;
        Group advancedProgrammingCG1;
        Course advancedProgrammingC;


        advancedProgrammingCLList1=new ArrayList<Lesson>();
        advancedProgrammingCLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(18,00),LocalTime.of(20,30))));
        advancedProgrammingCG1=new Group(advancedProgrammingCLList1);
        advancedProgrammingCGList.add(advancedProgrammingCG1);

        advancedProgrammingC=new Course("advanced Programming C",4,7,linearGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(advancedProgrammingC);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Group> calculus2GList = new ArrayList<Group>();
        List<Lesson> calculus2LList1;
        Group calculus2G1;
        Course calculus2;


        calculus2LList1=new ArrayList<Lesson>();
        calculus2LList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(9,45))));
        calculus2LList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        calculus2G1=new Group(calculus2LList1);
        calculus2GList.add(calculus2G1);

        calculus2=new Course("calculus 2",4,7,linearGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(calculus2);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<Group> dataStructuresGList = new ArrayList<Group>();
        List<Lesson> dataStructuresLList1, dataStructuresLList2, dataStructuresLList3, dataStructuresLList4;
        Group dataStructuresG1, dataStructuresG2, dataStructuresG3, dataStructuresG4;
        Course dataStructures;


        dataStructuresLList1=new ArrayList<Lesson>();
        dataStructuresLList1.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(8,00),LocalTime.of(10,30))));
        dataStructuresLList1.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(11,30),LocalTime.of(13,00))));
        dataStructuresG1=new Group(dataStructuresLList1);
        dataStructuresGList.add(dataStructuresG1);

        dataStructuresLList2=new ArrayList<Lesson>();
        dataStructuresLList2.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(11,30),LocalTime.of(13,00))));
        dataStructuresLList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(8,00),LocalTime.of(10,30))));
        dataStructuresG2=new Group(dataStructuresLList2);
        dataStructuresGList.add(dataStructuresG2);

        dataStructuresLList3=new ArrayList<Lesson>();
        dataStructuresLList3.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        dataStructuresLList3.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(14,15),LocalTime.of(16,45))));
        dataStructuresG3=new Group(dataStructuresLList3);
        dataStructuresGList.add(dataStructuresG3);

        dataStructuresLList4=new ArrayList<Lesson>();
        dataStructuresLList4.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(15,15),LocalTime.of(17,45))));
        dataStructuresLList4.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        dataStructuresG4=new Group(dataStructuresLList4);
        dataStructuresGList.add(dataStructuresG4);



        dataStructures=new Course("Data Structures",5,7,dataStructuresGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(dataStructures);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<Group> linear2GList = new ArrayList<Group>();
        List<Lesson> linear2LList1, linear2LList2, linear2LList3, linear2LList4;
        Group linear2G1, linear2G2, linear2G3, linear2G4;
        Course linear2;


        linear2LList1=new ArrayList<Lesson>();
        linear2LList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(11,30))));
        linear2LList1.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(13,30),LocalTime.of(15,00))));
        linear2G1=new Group(linear2LList1);
        linear2GList.add(linear2G1);

        linear2LList2=new ArrayList<Lesson>();
        linear2LList2.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,30),LocalTime.of(16,00))));
        linear2LList2.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(11,00),LocalTime.of(12,30))));
        linear2G2=new Group(linear2LList2);
        linear2GList.add(linear2G2);

        linear2LList3=new ArrayList<Lesson>();
        linear2LList3.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(10,15),LocalTime.of(11,45))));
        linear2LList3.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        linear2G3=new Group(linear2LList3);
        linear2GList.add(linear2G3);

        linear2LList4=new ArrayList<Lesson>();
        linear2LList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        linear2LList4.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(9,45))));
        linear2G4=new Group(linear2LList4);
        linear2GList.add(linear2G4);



        linear2=new Course("linear 2",4,7,linear2GList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(linear2);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> computerStructureGList = new ArrayList<Group>();
        List<Lesson> computerStructureLList1, computerStructureLList2, computerStructureLList3, computerStructureLList4;
        Group computerStructureG1, computerStructureG2, computerStructureG3, computerStructureG4;
        Course computerStructure;


        computerStructureLList1=new ArrayList<Lesson>();
        computerStructureLList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,15),LocalTime.of(13,45))));
        computerStructureLList1.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(15,15),LocalTime.of(16,45))));
        computerStructureG1=new Group(computerStructureLList1);
        computerStructureGList.add(computerStructureG1);

        computerStructureLList2=new ArrayList<Lesson>();
        computerStructureLList2.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(14,15),LocalTime.of(15,45))));
        computerStructureLList2.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        computerStructureG2=new Group(computerStructureLList2);
        computerStructureGList.add(computerStructureG2);

        computerStructureLList3=new ArrayList<Lesson>();
        computerStructureLList3.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        computerStructureLList3.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        computerStructureG3=new Group(computerStructureLList3);
        computerStructureGList.add(computerStructureG3);

        computerStructureLList4=new ArrayList<Lesson>();
        computerStructureLList4.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        computerStructureLList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(14,45))));
        computerStructureG4=new Group(computerStructureLList4);
        computerStructureGList.add(computerStructureG4);



        computerStructure=new Course("Computer structure",4,7,computerStructureGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(computerStructure);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        List<Group> computerArchitectureGList = new ArrayList<Group>();
        List<Lesson> computerArchitectureLList1;
        Group computerArchitectureG1;
        Course computerArchitecture;


        computerArchitectureLList1=new ArrayList<Lesson>();
        computerArchitectureLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(12,45))));
        computerArchitectureLList1.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(9,15),LocalTime.of(10,45))));
        computerArchitectureG1=new Group(computerArchitectureLList1);
        computerArchitectureGList.add(computerArchitectureG1);

        computerArchitecture=new Course("Computer architecture",4,7,computerArchitectureGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(computerArchitecture);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> objectOrientedProgrammingCPPGList = new ArrayList<Group>();
        List<Lesson> objectOrientedProgrammingCPPLList1, objectOrientedProgrammingCPPLList2, objectOrientedProgrammingCPPLList3, objectOrientedProgrammingCPPLList4;
        Group objectOrientedProgrammingCPPG1, objectOrientedProgrammingCPPG2, objectOrientedProgrammingCPPG3, objectOrientedProgrammingCPPG4;
        Course objectOrientedProgrammingCPP;


        objectOrientedProgrammingCPPLList1=new ArrayList<Lesson>();
        objectOrientedProgrammingCPPLList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(11,15),LocalTime.of(13,45))));
        objectOrientedProgrammingCPPG1=new Group(objectOrientedProgrammingCPPLList1);
        objectOrientedProgrammingCPPGList.add(objectOrientedProgrammingCPPG1);

        objectOrientedProgrammingCPPLList2=new ArrayList<Lesson>();
        objectOrientedProgrammingCPPLList2.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(8,30),LocalTime.of(11,00))));
        objectOrientedProgrammingCPPG2=new Group(objectOrientedProgrammingCPPLList2);
        objectOrientedProgrammingCPPGList.add(objectOrientedProgrammingCPPG2);

        objectOrientedProgrammingCPPLList3=new ArrayList<Lesson>();
        objectOrientedProgrammingCPPLList3.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(8,15),LocalTime.of(10,45))));
        objectOrientedProgrammingCPPG3=new Group(objectOrientedProgrammingCPPLList3);
        objectOrientedProgrammingCPPGList.add(objectOrientedProgrammingCPPG3);

        objectOrientedProgrammingCPPLList4=new ArrayList<Lesson>();
        objectOrientedProgrammingCPPLList4.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,15),LocalTime.of(15,45))));
        objectOrientedProgrammingCPPG4=new Group(objectOrientedProgrammingCPPLList4);
        objectOrientedProgrammingCPPGList.add(objectOrientedProgrammingCPPG4);



        objectOrientedProgrammingCPP=new Course("Object Oriented Programming CPP",4,7,objectOrientedProgrammingCPPGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(objectOrientedProgrammingCPP);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        List<Group> algorithmsGList = new ArrayList<Group>();
        List<Lesson> algorithmsLList1;
        Group algorithmsG1;
        Course algorithms;


        algorithmsLList1=new ArrayList<Lesson>();
        algorithmsLList1.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(16,00))));
        algorithmsLList1.add(new Lesson(Days.TUESDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(15,45))));
        algorithmsG1=new Group(algorithmsLList1);
        algorithmsGList.add(algorithmsG1);

        algorithms=new Course("algorithms",5,7,algorithmsGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(algorithms);


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

















        List<Lesson> computabilityLList1=new ArrayList<Lesson>();
        computabilityLList1.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG1=new Group(computabilityLList1);
        List<Group> computabilityGList = new ArrayList<Group>();
        computabilityGList.add(computabilityG1);

        List<Lesson> computabilityLList2=new ArrayList<Lesson>();
        computabilityLList2.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(18,00))));
        computabilityLList2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(16,00),LocalTime.of(19,00))));
        Group computabilityG2=new Group(computabilityLList2);
        computabilityGList.add(computabilityG2);

        Course computability=new Course("computability",4,7,computabilityGList, new Date(2022,7,13) ,new Date(2022,8,21),true, null);
        courses.add(computability);



        Gson t=new Gson();
        String coursesJsons = t.toJson(courses);

        System.out.println(coursesJsons);



        /////////////////////////////////////////////////////////////////////

        List<Lesson> designPatternsList1=new ArrayList<Lesson>();
        designPatternsList1.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(12,00))));
        Group designPatternsG1=new Group(designPatternsList1);
        List<Group> designPatternsGList = new ArrayList<Group>();
        designPatternsGList.add(designPatternsG1);


        Course designPatterns=new Course("design patterns",4,6,designPatternsGList, null ,null,false, null);
        courses.add(designPatterns);


        /////////////////////////////////////////////////////////////////////

        /////////////////////////////////////////////////////////////////////





        /////////////////////////////////////////////////////////////////////



        List<Lesson> osLList=new ArrayList<Lesson>();
        osLList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        osLList.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group osG=new Group(osLList);//todo: more groups
        List<Group> osGList = new ArrayList<Group>();
        osGList.add(osG);
        Course os=new Course("operating systems",4,8,osGList, new Date(2022,8,30) ,new Date(2022,9,10),true, null);
        courses.add(os);



        List<Lesson> javaList=new ArrayList<Lesson>();
        javaList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        javaList.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group javaG=new Group(javaList);//todo: more groups
        List<Group> javaGList = new ArrayList<Group>();
        javaGList.add(javaG);
        Course java=new Course("JAVA",4,10,javaGList, new Date(2022,7,17) ,new Date(2022,8,29),true, null);
        courses.add(java);



        List<Lesson> csharpList=new ArrayList<Lesson>();
        csharpList.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        csharpList.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group csharpG=new Group(csharpList);//todo: more groups
        List<Group> csharpGList = new ArrayList<Group>();
        csharpGList.add(csharpG);
        Course csharp=new Course("CSharp",4,7,csharpGList, new Date(2022,7,20) ,new Date(2022,9,5),true, null);
        courses.add(csharp);

        List<Lesson> networkingL=new ArrayList<Lesson>();
        networkingL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        networkingL.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group networkingG = new Group(networkingL);//todo: more groups
        List<Group> networkingGList = new ArrayList<Group>();
        networkingGList.add(networkingG);
        Course networking =new Course("Networking",4,7,networkingGList, new Date(2022,7,27) ,new Date(2022,8,24),true, null);
        courses.add(networking);



        List<Lesson> dataBasesL=new ArrayList<Lesson>();
        dataBasesL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        dataBasesL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));


        List<Lesson> dataBasesL2=new ArrayList<Lesson>();
        dataBasesL2.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(12,30))));
        dataBasesL2.add(new Lesson(Days.WEDNESDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(16,00))));



        Group dataBasesG = new Group(dataBasesL);//todo: more groups

        Group dataBasesG2 = new Group(dataBasesL2);//todo: more groups

        List<Group> dataBasesGList = new ArrayList<Group>();


        dataBasesGList.add(dataBasesG);
        dataBasesGList.add(dataBasesG2);

        Course dataBasess =new Course("Data Bases",3,5,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true, null);
        courses.add(dataBasess);


        List<Lesson> complexityL=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));

        List<Lesson> complexityL2=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.MONDAY,new TimeRange(LocalTime.of(10,00),LocalTime.of(14,30))));
        complexityL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(14,00),LocalTime.of(18,00))));

        List<Lesson> complexityL3=new ArrayList<Lesson>();
        complexityL.add(new Lesson(Days.THURSDAY,new TimeRange(LocalTime.of(13,20),LocalTime.of(15,40))));
        complexityL.add(new Lesson(Days.SATURDAY,new TimeRange(LocalTime.of(17,10),LocalTime.of(19,30))));

        Group complexityG = new Group(complexityL);
        Group complexityG2 = new Group(complexityL2);
        Group complexityG3 = new Group(complexityL3);

        List<Group> complexityGList = new ArrayList<Group>();
        complexityGList.add(complexityG);
        complexityGList.add(complexityG2);
        complexityGList.add(complexityG3);

        Course complexity =new Course("Complexity",5,10,dataBasesGList, new Date(2022,7,27) ,new Date(2022,8,24),true, null);
        courses.add(complexity);



        List<Lesson> workshopL=new ArrayList<Lesson>();
        workshopL.add(new Lesson(Days.SUNDAY,new TimeRange(LocalTime.of(12,00),LocalTime.of(14,30))));
        workshopL.add(new Lesson(Days.FRIDAY,new TimeRange(LocalTime.of(13,00),LocalTime.of(15,00))));
        Group workshopG = new Group(workshopL);
        List<Group> workshopGList = new ArrayList<Group>();
        workshopGList.add(workshopG);
        Course workshop = new Course("WorkShop",6,6,workshopGList, null ,null,true, null);
        courses.add(workshop);



        List<Course> mustCourses=new ArrayList<Course>();
        mustCourses.add(java);
        mustCourses.add(calculus1);




        Gson g=new Gson();
        String coursesJson = g.toJson(courses);

        System.out.println(coursesJson);


        Gson gson = new Gson();

        Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> coursesArray = gson.fromJson(coursesJson , userListType);



        Preferences pref = new Preferences(20,100,13,100,coursesArray,40,100,WeekSchedule,null);


        logicManager.filterCourses(pref);

        logicManager.startEngine();

    }
}
