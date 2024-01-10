public class Player {
    private String name;
    private int health;
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
}
