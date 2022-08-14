package dto;

import EA.Strategies;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.TerminationCondition;

public class DtoStrategy
{

    private Strategies strategy;
    private Probability tournamentProbability;
    private double truncateSelectionRatio; //todo: should be 0 < truncateSelectionRatio < 1


    public DtoStrategy(Strategies strategy, Probability tournamentProbability, double truncateSelectionRatio)
    {
        this.strategy = strategy;
        this.tournamentProbability = tournamentProbability;
        this.truncateSelectionRatio = truncateSelectionRatio;

    }


    public Strategies getStrategy()
    {
        return strategy;
    }

    public Probability getTournamentProbability()
    {
        return tournamentProbability;
    }

    public double getTruncateSelectionRatio()
    {
        return truncateSelectionRatio;
    }





}
