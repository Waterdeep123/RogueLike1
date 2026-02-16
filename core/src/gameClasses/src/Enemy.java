
import java.util.ArrayList;
import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private ArrayList<Actions> enemyActions = new ArrayList<>();
    public boolean isAlive = true;


    public Enemy(String name, int maxHealth){
        setName(name);
        setMaxHealth(maxHealth);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }
    public void setActions(Actions action1){
        enemyActions.add(action1);
    }
    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public Actions getAnAction(){
        Random rand = new Random();
        int randomAction = rand.nextInt(enemyActions.size());
        return enemyActions.get(randomAction);
    }
    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println(name + " took " + damage + " damage!");

        if (this.health <= 0) {
            this.isAlive = false;
            System.out.println(name + " has been defeated!");
        } else {
            System.out.println(name + " has " + this.health + " health remaining.");
        }
    }

    public void healDamage(int damage){
        this.health += damage;
        if (this.health>this.maxHealth){
            health = maxHealth;
        }
        System.out.println(name + " healed "+ damage + " damage!");
        System.out.println(name + " has " + this.health + " health remaining.");
    }

    public static class Actions {
        private int damage;
        private String name;
        private DoTs dot;
        private String effects;

        public Actions(int damage, String name, String effects){
            setName(name);
            setDamage(damage);
            setEffects(effects);
        }

        public void setName(String name){
            this.name = name;
        }
        public void setDamage(int damage){
            this.damage = damage;
        }
        public void setEffects(String effects, Character target){
            target.addEffect(new DoTs(target, 5, 3));

        }

    }
}
