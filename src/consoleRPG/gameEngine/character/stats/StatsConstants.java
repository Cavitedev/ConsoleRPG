package consoleRPG.gameEngine.character.stats;

public enum StatsConstants {
    /* Provisional way*/
    DEFAULT(5, 3, 2,10);

    private final int initialStatValue, actionPointsMax, actionPointsInitial;
    private final double lifeScaled;

    StatsConstants (int initialStatValue, int actionPointsMax, int actionPointsInitial, int lifeScaled){
        this.initialStatValue = initialStatValue;
        this.actionPointsMax = actionPointsMax;
        this.actionPointsInitial = actionPointsInitial;
        this.lifeScaled = lifeScaled;
    }

    public int getInitialStatValue() {
        return initialStatValue;
    }

    public int getActionPointsMax() {
        return actionPointsMax;
    }

    public int getActionPointsInitial() {
        return actionPointsInitial;
    }

    public double getLifeScaled() {
        return lifeScaled;
    }
}
