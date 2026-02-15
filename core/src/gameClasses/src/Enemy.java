import java.util.ArrayList;

public class Enemy {
    private String name;
    private int health;
    private int maxHealth;
    private ArrayList<Actions> actions = new Actions<>();

    public Enemy(String name, int maxHealth){
        setName(name);
        setMaxHealth(maxHealth);
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
    public void setActions(){
        actions.add()
    }
    public String getName{
        return name;
    }
    public int getHealth{
        return health;
    }
    public Actions getActions{
        return actions;
    }

}
