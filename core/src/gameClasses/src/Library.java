import java.util.ArrayList;

public class Library {
    private int maxSize;
    private int currentSize;
    private ArrayList<Cards> spellList;
    private int MaxLibrary = 100;

    public Library(){
        spellList = new ArrayList<Cards>();

    }

    public void addSpell(Cards aSpell){
        spellList.add(aSpell);
    }
    public void removeSpell(Cards aSpell){
        spellList.remove(aSpell);
    }
}
