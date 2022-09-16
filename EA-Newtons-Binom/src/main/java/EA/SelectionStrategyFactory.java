package EA;

import dto.DtoStrategy;
import logic.EaRunTimeParameters;
import logic.Schedule;
import org.uncommons.maths.random.Probability;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.selection.*;

public class SelectionStrategyFactory {


    public static SelectionStrategy<Object> getStrategy(EaRunTimeParameters eaParameters){
        DtoStrategy dtoStrategy = eaParameters.getDtoStrategy();

        switch (eaParameters.getDtoStrategy().getStrategy())
        {


            case rankSelection:{
                return new RankSelection();
            }
            case rouletteWheelSelection:{
                return new RouletteWheelSelection();
            }
            case sigmaScaling:{
                return new SigmaScaling();
            }
            case stochasticUniversalSampling:{
                return new StochasticUniversalSampling();
            }
            case tournamentSelection:{
                return new TournamentSelection(dtoStrategy.getTournamentProbability());
            }
            case truncationSelection:{
                return new TruncationSelection(dtoStrategy.getTruncateSelectionRatio());
            }
        }
        return null;
    }
}
