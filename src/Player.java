public class Player {
    private String name;
    public int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;

    public Player(String name) {
        this.name = name;
        health = 100;

    }
    public void checkForPot(){
        if (healthPotStatus) {
            health += (100-health)/2;
        }
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
