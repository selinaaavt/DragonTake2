public class Player {
    private String name;
    public int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    public boolean alive;

    public Player(String name) {
        this.name = name;
        health = 100;
        sword = new Sword();
        alive = true;
    }
    public void checkForPot(){
        if (healthPotStatus) {
            health += (100-health)/2;
            healthPotStatus = false;
        } else {
            System.out.println("You do not owe a health pot!");
        }
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int zx) {
        health = zx;
    }
    public void sethealthPotStatus(boolean s) {
        healthPotStatus = s;
    }
    public Sword getSword() {
        return sword;
    }

    public String getName() {
        return name;
    }
    public void setGold(int x) {
        gold += x;
    }
    public int getGold() {
        return gold;
    }

    public void playerInfo() {
        System.out.println( Color.RED + "[Health: " + health + "%] ");
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
