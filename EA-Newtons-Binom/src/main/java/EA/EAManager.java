package EA;

import logic.Course;
import logic.EaRunTimeParameters;
import logic.Preferences;
import logic.Schedule;

import org.uncommons.maths.random.MersenneTwisterRNG;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.GenerationalEvolutionEngine;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.termination.GenerationCount;


import java.util.ArrayList;
import java.util.List;



public class EAManager
{

    private final EaRunTimeParameters eaRunTimeParameters;
    private Preferences preferences;
    private List<Course> courses;
    private ArrayList<EvolutionaryOperator<Schedule>> operators = new ArrayList<EvolutionaryOperator<Schedule>>();
    private EvolutionaryOperator<Schedule> pipeline;
    private GenerationalEvolutionEngine<Schedule> engine;
    private ScheduleMutation scheduleMutation;
    private ScheduleCrossover scheduleCrossover;



    public EAManager(List<Course> filteredCourses, Preferences pref, EaRunTimeParameters eaRunTimeParameters)
    {
        preferences = pref;
        courses=new ArrayList<Course>(filteredCourses.size());
        cloneAndSetCourses(filteredCourses);
        scheduleMutation = new ScheduleMutation(new Probability(.001d), new Probability(.005d),courses, pref.getMustHaveCourses());
        scheduleCrossover = new ScheduleCrossover(new Probability(.9d), pref.getMustHaveCourses());
        this.eaRunTimeParameters=eaRunTimeParameters;
    }



    public void cloneAndSetCourses(List<Course> coursesToClone)
    {


        try
        {
            for (Course course: coursesToClone)
            {
                courses.add((Course)course.clone());
            }
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }


    }

    public void initOperators()
    {

        //TODO: implement crossover and mutation

        operators.add(scheduleMutation);
        operators.add(scheduleCrossover);
        pipeline = new EvolutionPipeline<Schedule>(operators);


    }


    public Schedule runEngine(List<Course> courses, EaRunTimeParameters eaRunTimeParameters)
    {


        initOperators();
        engine = new GenerationalEvolutionEngine<Schedule>(
                new ScheduleFactory(courses, preferences.getMustHaveCourses()),
                pipeline,
                new src.main.java.EA.ScheduleFitnessFunction(preferences),
                SelectionStrategyFactory.getStrategy(eaRunTimeParameters),
                new MersenneTwisterRNG());

        engine.setSingleThreaded(false);

        return generateGeneration(engine, eaRunTimeParameters);

    }


    public Schedule generateGeneration(GenerationalEvolutionEngine<Schedule> engine, EaRunTimeParameters eaRunTimeParameters)
    {

        Schedule winningSchedule = null;

        try{

            winningSchedule = engine.evolve(eaRunTimeParameters.getPopulationSize(), // individuals per generation
                    eaRunTimeParameters.getEliteCount(), // Elites per generation
                    TerminationConditionsFactory.getTerminationConditions(eaRunTimeParameters));



            engine.addEvolutionObserver(new ScheduleObserver());

        }catch (Exception e)
        {

            System.out.println(e.getMessage());

        }

        
        winningSchedule.printSchedule();

        return winningSchedule;
        // Display the health of each generation
        //engine.addEvolutionObserver(new EAPackage.ScheduleObserver());


        // Go!

    }

}
