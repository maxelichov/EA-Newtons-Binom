package workshopea.webserver.engine;

import lombok.Data;

@Data
public class EaRunTimeParametersModel {
	private DtoStrategyModel dtoStrategy;
    private DtoTerminationConditionModel dtoTerminationCondition;
    private int populationSize;//50
    private int eliteCount;
}
