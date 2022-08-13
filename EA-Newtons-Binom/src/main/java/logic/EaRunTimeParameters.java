package logic;

import EA.Strategies;
import EA.TerminationConditions;
import dto.DtoStrategy;
import dto.DtoTerminationCondition;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.TerminationCondition;

public class EaRunTimeParameters {

    private DtoStrategy dtoStrategy;
    private DtoTerminationCondition dtoTerminationCondition;


    int populationSize;//50
    int eliteCount;//3



    public EaRunTimeParameters(DtoStrategy dtoStrategy, DtoTerminationCondition dtoTerminationCondition,int populationSize, int eliteCount) throws Exception{
        if(populationSize<0 || eliteCount<0){
            throw new Exception("parameters must be positive number or 0");
        }
        this.populationSize = populationSize;
        this.eliteCount = eliteCount;
        this.dtoStrategy=dtoStrategy;
        this.dtoTerminationCondition=dtoTerminationCondition;
    }

    public DtoStrategy getDtoStrategy()
    {
        return dtoStrategy;
    }

    public DtoTerminationCondition getDtoTerminationCondition(){
        return dtoTerminationCondition;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getEliteCount() {
        return eliteCount;
    }



}
