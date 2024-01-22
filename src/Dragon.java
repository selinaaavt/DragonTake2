import java.util.Scanner;

public class Dragon {
    private int level;
    private int health;
    private boolean alive;
    private Scanner scan;
    private Player player;
    public Dragon(Player player) {
        health = 100;
        level = (int) (Math.random()*3 +1);
        alive = true;
        scan = new Scanner(System.in);
        this.player = player;
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
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean trueOrFalse) {
        alive = trueOrFalse;
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
        System.out.println(Color.PURPLE + "Dragon's level: " + level + Color.RESET);
    }
}
