
public class DoTs extends StatusEffect {

    private DoTs(Character target, int damagePerTurn, int duration) {
            super(target, damagePerTurn, duration);
    }
    public void applyEffect() {
        if (!isFinished()) {
            // Apply damage to the target
            target.takeDamage(damagePerTurn);
            System.out.println(target.getName() + " takes " + damagePerTurn + " damage!");
            decrementTurns();
        }
    }
}
