
public class PoisonEffect extends StatusEffect {
    public PoisonEffect(Character target, int damagePerTurn, int duration) {
        super(target, damagePerTurn, duration);
    }

    @Override
    public void applyEffect() {
        if (!isFinished()) {
            // Apply damage to the target
            target.takeDamage(damagePerTurn);
            System.out.println(target.getName() + " takes " + damagePerTurn + " poison damage!");
            decrementTurns();
        }
    }
}
