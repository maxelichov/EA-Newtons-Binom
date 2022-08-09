package EA;

import logic.Schedule;
import org.uncommons.watchmaker.framework.SelectionStrategy;
import org.uncommons.watchmaker.framework.selection.RankSelection;
import org.uncommons.watchmaker.framework.selection.RouletteWheelSelection;
import org.uncommons.watchmaker.framework.selection.SigmaScaling;
import org.uncommons.watchmaker.framework.selection.StochasticUniversalSampling;

public class SelectionStrategyFactory {


    public static SelectionStrategy<Object> getStrategy(Strategies strategy){
        switch (strategy){
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
        }
        return null;
    }
}
