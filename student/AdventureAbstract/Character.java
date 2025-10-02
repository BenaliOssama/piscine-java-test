import java.util.List;
import java.util.ArrayList;

public abstract class Character {
    private final int maxHealth; 
    private int currentHealth; 
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = this.maxHealth;
        this.name = name;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getCurrentHealth() {
        return this.currentHealth;
    }

protected void setCurrentHealth(int health) {
    this.currentHealth = Math.max(0, health);
}


    public String getName() {
        return this.name;
    }
    
    @Override
    public String toString() {
        if (this.currentHealth == 0) {
            return String.format("%s : KO", this.name);
        }
        return String.format("%s : %d/%d", this.name, this.currentHealth, this.maxHealth);
    }

    // now abstract
    public abstract void takeDamage(int damage);
    public abstract void attack(Character character);

    public static String printStatus() {
        String fighting = "Characters currently fighting :\n";
        String line = "------------------------------------------\n";
        if (allCharacters.size() == 0) {
            return line + "Nobody's fighting right now !\n" + line;
        }
        String res = "";
        for (Character c : allCharacters) {
            res += " - " + c.toString() + "\n";
        }
        return line + fighting + res + line;
    }

    public static Character fight(Character char1, Character char2) {
        while (true) {
            if (char1.currentHealth == 0) {
                return char2;
            }
            char1.attack(char2);
            if (char2.currentHealth == 0) {
                return char1;
            }
            char2.attack(char1);
        }
    }
}

