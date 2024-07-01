public class Mana {
    private int maxMana;
    private int currentMana;

    public Mana(int manaPool) {
        this.maxMana = manaPool;
        this.currentMana = manaPool;
    }

    public void increaseMax(int amount) {
        this.maxMana += amount;
    }

    public void fullRestore() {
        this.currentMana = this.maxMana;
    }

    public void regen(int amount) {
        this.currentMana = Math.min(this.currentMana + amount, this.maxMana);
    }

    public void useMana(int amount) {
        this.currentMana = Math.max(this.currentMana - amount, 0);
    }

    public int getCurrent() {
        return this.currentMana;
    }
}
