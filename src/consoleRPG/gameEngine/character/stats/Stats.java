package consoleRPG.gameEngine.character.stats;

import consoleRPG.gameEngine.character.equipment.Weapon;

public class Stats {
    /* NOT CALCULABLE */
    private int attackMin, attackMax;

    private int strength, dexterity, intelligence, constitution, speed;

    private int statsPointsRemaining;

    private int actionPointsMax, actionPointsCurrent;
    /* CALCULABLE */
    private int lifeMax, lifeCurrent, threat, initiative, criticChance;

    public Stats() {
        strength = StatsConstants.DEFAULT.getInitialStatValue();
        dexterity = StatsConstants.DEFAULT.getInitialStatValue();
        intelligence = StatsConstants.DEFAULT.getInitialStatValue();
        constitution = StatsConstants.DEFAULT.getInitialStatValue();
        speed = StatsConstants.DEFAULT.getInitialStatValue();

        statsPointsRemaining = StatsConstants.DEFAULT.getInitialStatValue();

        actionPointsMax = StatsConstants.DEFAULT.getActionPointsMax();

        calculateStatsCalculable();
    }

    public Stats(int attackMin, int attackMax, int strength, int dexterity, int intelligence, int constitution, int speed) {
        this.attackMin = attackMin;
        this.attackMax = attackMax;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.constitution = constitution;
        this.speed = speed;

        actionPointsMax = StatsConstants.DEFAULT.getActionPointsMax();

        calculateStatsCalculable();
    }

    private void calculateStatsCalculable() {
        lifeMax = (int) (constitution * StatsConstants.DEFAULT.getLifeScaled());
        lifeCurrent = lifeMax;
        threat = strength + constitution;
        initiative = speed;
        criticChance = dexterity;

        //add equipment
    }

    public String toString(){
        return "/////////////////////////////////////////////////////////////////////////////////////////" + "\n" +

                "Basic attack: " + attackMin + "-" + attackMax + "\n" +

                "*****************************************************************************************" + "\n" +

                "Strength: " + strength + "\n" +
                "Dexterity: " + dexterity + "\n" +
                "Intelligence: " + intelligence + "\n" +
                "Constitution: " + constitution + "\n" +
                "Speed: " + speed + "\n" +

                "*****************************************************************************************" + "\n" +

                "Life: " + lifeCurrent + "/" + lifeMax + "\n" +
                "Threat: " + threat + "\n" +
                "Initiative: " + initiative + "\n" +
                "Critic chance (%): " + criticChance + "\n" +
                "/////////////////////////////////////////////////////////////////////////////////////////" + "\n";
    }

    public  void addWeaponStats(Weapon weapon){
        this.attackMin += weapon.getAttackMin();
        this.attackMax += weapon.getAttackMax();
        this.criticChance += weapon.getCriticChance();
    }

    public void removeWeaponStats(Weapon weapon){
        this.attackMin -= weapon.getAttackMin();
        this.attackMax -= weapon.getAttackMax();
        this.criticChance -= weapon.getCriticChance();
    }

    public void modifyLifeCurrent(int currentLifeModification) {
        this.lifeCurrent += currentLifeModification;
        if (this.lifeCurrent > this.lifeMax) {
            this.lifeCurrent = this.lifeMax;
        }
    }

    public void modifyStatsPointsRemaining(int modification) {
        this.statsPointsRemaining += modification;
    }

    public void modifyStrength(int modification) {
        strength += modification;
        threat += modification;
    }

    public void modifyDexterity(int modification) {
        dexterity += modification;
        criticChance += modification;
    }

    public void modifyIntelligence(int modification) {
        intelligence += modification;
    }

    public void modifyConstitution(int modification) {
        constitution += modification;
        threat += modification;
        lifeMax += (int) (modification * StatsConstants.DEFAULT.getLifeScaled());
        lifeCurrent = lifeMax;
    }

    public void modifySpeed(int modification) {
        speed += modification;
        initiative += modification;
    }

    public int getAttackMin() {
        return attackMin;
    }

    public int getAttackMax() {
        return attackMax;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getSpeed() {
        return speed;
    }

    public int getStatsPointsRemaining() {
        return statsPointsRemaining;
    }

    public int getActionPointsMax() {
        return actionPointsMax;
    }

    public int getActionPointsCurrent() {
        return actionPointsCurrent;
    }

    public int getLifeMax() {
        return lifeMax;
    }

    public int getLifeCurrent() {
        return lifeCurrent;
    }

    public int getThreat() {
        return threat;
    }

    public int getInitiative() {
        return initiative;
    }

    public int getCriticChance() {
        return criticChance;
    }

    public void setActionPointsCurrent(int actionPointsCurrent) {
        this.actionPointsCurrent = actionPointsCurrent;
    }

    public void addOneActionPointsCurrent(){
        if(this.actionPointsCurrent < actionPointsMax){
            this.actionPointsCurrent++;
        }
    }
}
