public class Dragon {
    private int level;
    private int health;
    public Dragon() {
        health = 100;
        level = (int) (Math.random()*2 +1);
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
    public void fightDragon() {

    }
    public void dragonInfo() {
        System.out.println( Color.BLUE + "[Health: " + health + "%] ");
        if (health <= 10) {
            System.out.println("█▒▒▒▒▒▒▒▒▒ ☠\uFE0F");
        } else if (health <= 20) {
            System.out.println("██▒▒▒▒▒▒▒▒ ");
        } else if (health <= 30) {
            System.out.println("███▒▒▒▒▒▒▒");
        } else if (health <= 40) {
            System.out.println("████▒▒▒▒▒▒ ");
        } else if (health <= 50) {
            System.out.println("█████▒▒▒▒▒ ");
        } else if (health <= 60) {
            System.out.println("██████▒▒▒▒ ");
        } else if (health <= 70) {
            System.out.println("███████▒▒▒");
        } else if (health <= 80){
            System.out.println("████████▒▒");
        } else if (health <= 93 ) {
            System.out.println("█████████▒ ");
        } else {
            System.out.println("██████████ ");
        }
    }
}
