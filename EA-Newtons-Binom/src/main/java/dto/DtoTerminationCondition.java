package dto;

import EA.TerminationConditions;
import org.uncommons.watchmaker.framework.TerminationCondition;

public class DtoTerminationCondition
{

    private TerminationConditions terminationCondition;
    private long maxDuration;
    private boolean naturalFitness;
    private double targetFitness;
    private boolean natural;
    private int generationCount;
    private int generationLimit;


    public DtoTerminationCondition(TerminationConditions terminationCondition, long maxDuration, boolean naturalFitness, double targetFitness, boolean natural, int generationCount, int generationLimit)
    {
        this.terminationCondition = terminationCondition;
        this.maxDuration = maxDuration;
        this.naturalFitness = naturalFitness;
        this.targetFitness = targetFitness;
        this.natural = natural;
        this.generationCount = generationCount;
        this.generationLimit = generationLimit;
    }

    public TerminationConditions getTerminationCondition()
    {
        return terminationCondition;
    }



    public long getMaxDuration()
    {
        return maxDuration;
    }

    public boolean getNatural()
    {
        return natural;
    }

    public double geTtargetFitness()
    {
        return targetFitness;
    }

    public int getGenerationCount()
    {

        return generationCount;
    }



    public boolean getNaturalFitness()
    {
        return naturalFitness;
    }

    public int getGenerationLimit()
    {
        return generationLimit;
    }
}
