package logic;

public class EaRunTimeParameters {
    int populationSize;//50
    int eliteCount;//3
    int numOfGenerations;//150

    public EaRunTimeParameters(int populationSize, int eliteCount, int numOfGenerations) throws Exception {
        if(populationSize<0 || eliteCount<0 || numOfGenerations<0){
            throw new Exception("parameters must be positive number or 0");
        }
        this.populationSize = populationSize;
        this.eliteCount = eliteCount;
        this.numOfGenerations = numOfGenerations;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public int getEliteCount() {
        return eliteCount;
    }

    public int getNumOfGenerations() {
        return numOfGenerations;
    }
}
