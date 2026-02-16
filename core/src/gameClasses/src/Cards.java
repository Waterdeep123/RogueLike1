
public class Cards {
    private String name;
    private String description;
    private int manaCost;
    private int damage;
    private String effect;
    private String rarity;
    public int weight;
    public int targetAmount;

    public Cards(String aName, String aDescription, String anEffect, int aManaCost, int aDamage, int aTargetAmount, String aRarity){
        setName(aName);
        setDescription(aDescription);
        setManaCost(aManaCost);
        setDamage(aDamage);
        setEffect(anEffect);
        setRarity(aRarity);
    }
    public void setName(String aName){
        name = aName;
    }
    public void setDescription(String aDescription){
        description = aDescription;
    }
    public void setEffect(String anEffect){
        effect = anEffect;
    }
    public void setManaCost(int aManaCost){
        manaCost = aManaCost;
    }
    public void setDamage(int aDamage){
        damage = aDamage;
    }
    public void setRarity(String aRarity){
        rarity = aRarity;
        setWeight(aRarity);
    }
    public void setWeight(String aRarity){
        if (aRarity.equals("Common")){
            weight = 50;
        } else if (aRarity.equals("Uncommon")) {
            weight = 30;
        } else if (aRarity.equals("Rare")) {
            weight = 10;
        } else if (aRarity.equals("Legendary")){
            weight = 5;
        } else if (aRarity.equals("Mythical")){
            weight = -1;
        }
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getEffect(){
        return effect;
    }
    public int getManaCost(){
        return manaCost;
    }
    public int getDamage(){
        return damage;
    }
    public String getRarity(){
        return rarity;
    }
    public int getWeight(){
        return weight;
    }

}
