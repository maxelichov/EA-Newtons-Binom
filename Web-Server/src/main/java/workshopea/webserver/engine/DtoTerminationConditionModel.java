package workshopea.webserver.engine;

import EA.TerminationConditions;
import lombok.Data;

@Data
public class DtoTerminationConditionModel {
	private TerminationConditions terminationCondition;
    private long maxDuration;
    private boolean naturalFitness;
    private double targetFitness;
    private boolean natural;
    private int generationCount;
    private int generationLimit;
}
