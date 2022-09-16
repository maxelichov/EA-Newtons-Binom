package workshopea.webserver.engine;

import EA.Strategies;
import lombok.Data;

@Data
public class DtoStrategyModel {
	private Strategies strategy;
    private double tournamentProbability; //should be 0 < tournamentProbability < 1
	private double truncateSelectionRatio;
}
