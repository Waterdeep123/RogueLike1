
public abstract class StatusEffect {
    protected int turnsRemaining;
    protected int damagePerTurn;
    protected Character target;

    public StatusEffect(Character target, int damagePerTurn, int duration) {
        this.target = target;
        this.damagePerTurn = damagePerTurn;
        this.turnsRemaining = duration;
    }

    // This method will be called at the appropriate turn event
    public abstract void applyEffect();

    // Called to check if the effect is finished and should be removed
    public boolean isFinished() {
        return turnsRemaining <= 0;
    }

    // Decrement the turn count
    public void decrementTurns() {
        turnsRemaining--;
    }
}
