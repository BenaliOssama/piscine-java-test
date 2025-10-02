public class Sorcerer extends Character implements Healer {
    private final int healCapacity;
    private final int defaultDamage = 5; // fallback if no weapon

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);  
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void heal(Character ch) {
        ch.setCurrentHealth(ch.getCurrentHealth() + this.healCapacity);
        if (ch.getCurrentHealth() > ch.getMaxHealth()) {  
            ch.setCurrentHealth(ch.getMaxHealth());     
        }
    }
    
    @Override
    public void attack(Character character) {
        int dmg = (getWeapon() != null) ? getWeapon().getDamage() : defaultDamage;
        character.takeDamage(dmg);
    }

    @Override
    public void takeDamage(int damage) {
        this.setCurrentHealth(this.getCurrentHealth() - damage);
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return String.format(
                "%s is a sorcerer with %d HP. It can heal %d HP.",
                this.getName(),
                this.getCurrentHealth(),
                this.healCapacity
            );
        } else {
            return String.format(
                "%s is a dead sorcerer. So bad, it could heal %d HP.",
                this.getName(),
                this.healCapacity
            );
        }
    }
}

