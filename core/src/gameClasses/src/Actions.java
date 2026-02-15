public class Actions {
    private int damage;
    private String name;
    private String effects;

    public Actions(int damage, String name){
        setName(name);
        setDamage(damage);
    }

    public void setName(String name){
        this.name = name;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }

}
