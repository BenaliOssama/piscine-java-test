public class Monster extends Character {
    public Monster (String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character character) {
        int dmg = (getWeapon() != null) ? getWeapon().getDamage() : 7;
        character.takeDamage(dmg);

    }

    @Override
    public void takeDamage(int damage) {
        int reduced = (damage * 80) / 100; // 80% of damage, floor
        this.setCurrentHealth(this.getCurrentHealth() - reduced);
    }

    @Override
    public String toString(){
        if (this.getCurrentHealth() != 0 ){
            return String.format(
                "%s is a monster with %d HP", this.getName(), this.getCurrentHealth()
            );
        }else{
            return String.format("%s is a monster and is dead", this.getName());
        }
    }
}
