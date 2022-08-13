package logic;

//import com.google.gson.Gson;

import EA.Strategies;
import EA.TerminationConditions;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import dto.DtoEA;
import dto.DtoStrategy;
import dto.DtoTerminationCondition;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.TerminationCondition;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main
{

    public static void main(String[] args) throws IOException
    {

        /*
        todo
        1. work with files
        2. servers
        3. ui platform
        4. let user to control evolution setting
         */








        LogicManager logicManager;

        EaRunTimeParameters eaRunTimeParameters;

        try {


            DtoStrategy dtos = new DtoStrategy(Strategies.rouletteWheelSelection, new Probability(0.8), 0.9);

            DtoTerminationCondition dtoc  = new DtoTerminationCondition(TerminationConditions.generationCount, 10000,true, 500, false, 150, 300);

            eaRunTimeParameters  =   new EaRunTimeParameters(dtos, dtoc, 50,3);

            logicManager = new LogicManager(eaRunTimeParameters);
            WeekSchedule WeekSchedule= new WeekSchedule();
            WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(16, 00),LocalTime.of(00, 00)));
            WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(00, 00),LocalTime.of(17, 00)));
            WeekSchedule.insertNewRange(Days.THURSDAY, new TimeRange(LocalTime.of(7, 00),LocalTime.of(23, 59)));


            String coursesJson = null;

            try {

                BufferedReader br= new BufferedReader(new FileReader("Web-Server/src/main/resources/courses.txt"));
                coursesJson = br.readLine();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println(coursesJson);


            Gson gson = new Gson();

            Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
            ArrayList<Course> coursesArray = gson.fromJson(coursesJson , userListType);



            Preferences pref = new Preferences(25,100,16,100,coursesArray,50,80,WeekSchedule,null);


            DtoEA d=new DtoEA(coursesArray,pref,eaRunTimeParameters);

            System.out.println("++++++++++++++++++++++++++++++++++++");
            System.out.println(gson.toJson(d));


            logicManager.filterCourses(pref); // todo: fix this exception

            logicManager.startEngine();


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
