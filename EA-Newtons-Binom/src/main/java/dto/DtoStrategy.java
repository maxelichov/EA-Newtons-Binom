package dto;

import EA.Strategies;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.TerminationCondition;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DtoStrategy
{
    private Strategies strategy;
    private Probability tournamentProbability; //should be 0 < tournamentProbability < 1
	private double truncateSelectionRatio; //todo: should be 0 < truncateSelectionRatio < 1

//	public DtoStrategy() {
//		super();
//	}
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
	public void setStrategy(Strategies strategy) {
		this.strategy = strategy;
	}
	public void setTournamentProbability(Probability tournamentProbability) {
		this.tournamentProbability = tournamentProbability;
	}
	public void setTruncateSelectionRatio(double truncateSelectionRatio) {
		this.truncateSelectionRatio = truncateSelectionRatio;
	}
	




}
