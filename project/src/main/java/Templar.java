public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    // From Healer
    @Override
    public int getHealCapacity() {
        return this.healCapacity;
    }

    @Override
    public void attack(Character character) {
        this.heal(this);
        character.takeDamage(6);
    }

    @Override
    public void takeDamage(int damage) {
        int reduced = damage - this.shield;
        if (reduced < 0) reduced = 0;
        this.setCurrentHealth(this.getCurrentHealth() - reduced);
    }



    @Override
    public void heal(Character ch) {
        ch.setCurrentHealth(ch.getCurrentHealth() + this.healCapacity);
        if (ch.getCurrentHealth() > ch.getMaxHealth()) {
            ch.setCurrentHealth(ch.getMaxHealth());
        }
    }

    // From Tank
    @Override
    public int getShield() {
        return this.shield;
    }

    // Custom toString
    @Override
    public String toString() {
        if (this.getCurrentHealth() > 0) {
            return String.format(
                "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                this.getName(),
                this.getCurrentHealth(),
                this.healCapacity,
                this.shield
            );
        } else {
            return String.format(
                "%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                this.getName(),
                this.shield,
                this.healCapacity
            );
        }
    }
}

