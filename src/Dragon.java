public class Dragon {
    private int level;
    private int health;
    public Dragon() {
        health = 100;
        level = 1;
    }
    public int getHealth() {
        return health;
    }
    public int getLevel() {
        return level;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
