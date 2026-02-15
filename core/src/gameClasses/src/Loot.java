import java.util.ArrayList;
import java.util.List;

public class Loot {
    private List<Cards> commons = new ArrayList<>();

    public void commonCards() {

        Cards c1 = new Cards("Firebolt", "Deal 3 Fire Damage to 1 Target Enemy", "None", 1, 3, 1, "Common"); // Common
        commons.add(c1);
        Cards c2 = new Cards("Frostbite", "Deals 3 Ice Damage to 1 Target Enemy", "None", 1, 3, 1, "Common"); // Uncommon
        commons.add(c2);
        Cards c3 = new Cards("Shocking Grasp", "Deals 3 Lightning Damage to 1 Target Enemy", "None", 1, 3, 1, "Common"); // Rare
        commons.add(c3);
        Cards c4 = new Cards("Gust", "Deals 3 Wind Damage to 1 Target Enemy", "None", 1, 3, 1, "Common"); // Very Rare
        commons.add(c4);
//        Cards c5 = new Cards();

    }

}
