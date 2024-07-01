public class Energy {
    private int maxEnergy = 100;
    private int currentEnergy;

    public Energy() {
        this.currentEnergy = this.maxEnergy;
    }

    public void addEnergy(int amount) {
        this.currentEnergy = Math.min(this.currentEnergy + amount, this.maxEnergy);
    }

    public void addEnergy() {
        this.currentEnergy = Math.min(this.currentEnergy + 10, this.maxEnergy);
    }

    public void decrease(int amount) {
        this.currentEnergy = Math.max(this.currentEnergy - amount, 0);
    }

    public int getCurrent() {
        return this.currentEnergy;
    }
}
