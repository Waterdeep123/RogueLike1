import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Character {
    private String name;
    private int manaPool;
    private int stability = 100;
    private List<StatusEffect> activeEffects = new ArrayList<>();
    private int health;
    private int maxHp;
    private int currentMana;

    public Character(String name, int maxHp, int manaPool, int health){
        setName(name);
        setManaPool(manaPool);
        setHealth(health);
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setManaPool(int manaPool){
        this.manaPool = manaPool;
    }
    public void setStability(int stability){
        this.stability = stability;
    }

    public String getName(){
        return name;
    }
    public int getHealth(){
        return health;
    }
    public int getManaPool(){
        return manaPool;
    }
    public int getStability(){
        return stability;
    }
    public void addEffect(StatusEffect effect) {
        activeEffects.add(effect);
    }
    public void applyTurnEffects() {
        Iterator<StatusEffect> iterator = activeEffects.iterator();
        while (iterator.hasNext()) {
            StatusEffect effect = iterator.next();
            effect.applyEffect();
            if (effect.isFinished()) {
                iterator.remove(); // Safely remove finished effects
                System.out.println(name + "'s " + effect.getClass().getSimpleName() + " has worn off.");
            }
        }
    }





}
