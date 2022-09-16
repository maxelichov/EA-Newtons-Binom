package EA;

import dto.DtoTerminationCondition;
import logic.EaRunTimeParameters;
import org.uncommons.watchmaker.framework.TerminationCondition;
import org.uncommons.watchmaker.framework.selection.*;
import org.uncommons.watchmaker.framework.termination.*;

public class TerminationConditionsFactory
{


    public static TerminationCondition getTerminationConditions(EaRunTimeParameters eaParameters){
        DtoTerminationCondition dtoTerminationCondition=  eaParameters.getDtoTerminationCondition();

        switch (dtoTerminationCondition.getTerminationCondition())
        {
            case elapsedTime:{
                return new ElapsedTime(dtoTerminationCondition.getMaxDuration());
            }
            case generationCount:{
                return new GenerationCount(dtoTerminationCondition.getGenerationCount());
            }
            case stagnation:{
                return new Stagnation(dtoTerminationCondition.getGenerationLimit(), dtoTerminationCondition.getNaturalFitness());
            }
            case targetFitness:{
                return new TargetFitness(dtoTerminationCondition.geTtargetFitness(), dtoTerminationCondition.getNatural());
            }

            case userAbort:{
                return new UserAbort();
            }
        }



        return null;
    }
}
