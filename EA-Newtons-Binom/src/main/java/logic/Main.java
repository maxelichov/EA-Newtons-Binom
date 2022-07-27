package logic;

//import com.google.gson.Gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.util.ArrayList;

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

        logic.WeekSchedule WeekSchedule= new WeekSchedule();
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(16, 00),LocalTime.of(00, 00)));
        WeekSchedule.insertNewRange(Days.SATURDAY, new TimeRange(LocalTime.of(00, 00),LocalTime.of(17, 00)));
        WeekSchedule.insertNewRange(Days.THURSDAY, new TimeRange(LocalTime.of(7, 00),LocalTime.of(23, 59)));


        String coursesJson = null;
        try {
            BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\Ohad Hodefi\\Desktop\\courses.txt"));
            coursesJson = br.readLine();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(coursesJson);


        Gson gson = new Gson();

        Type userListType = new TypeToken<ArrayList<Course>>(){}.getType();
        ArrayList<Course> coursesArray = gson.fromJson(coursesJson , userListType);



        Preferences pref = new Preferences(20,100,13,100,coursesArray,40,100,WeekSchedule,null);


        logicManager.filterCourses(pref);

        logicManager.startEngine();

    }
}
