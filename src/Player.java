public class Player {
    private String name;
    public int health;
    private int gold;
    private boolean healthPotStatus;
    private Sword sword;
    public boolean alive;
    public int score;
    public static int topScoreForAllGames;
    public Player(String name) { //starting stats
        this.name = name;
        health = 100;
        sword = new Sword();
        alive = true;
        score = 0;
        topScoreForAllGames =0;
    }
    public void checkForPot(){
        if (healthPotStatus) { //if the player wants to use pot, we check if they have a pot in the first place
            health += (100-health)/2;
            healthPotStatus = false;
        } else {
            System.out.println("You do not owe a health pot!");
        }
    }
    public static int getTopScoreForAllGames() {
        return topScoreForAllGames;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int zx) {
        health = zx;
    }
    public void sethealthPotStatus(boolean trueOrFalse) {
        healthPotStatus = trueOrFalse;
    }
    public Sword getSword() {
        return sword;
    }

    public String getName() {
        return name;
    }
    public void setGold(int x) {
        gold = x;
    }
    public int getGold() {
        return gold;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getScore() {
        return score;
    }
    public void determiningTopScore() {
        if (score > topScoreForAllGames){
            topScoreForAllGames = score;
        }
    }
    public int attack() {
        return ((int) (Math.random() * 10)) + 1 * getSword().getAttack();
    }
    public int hardAttack() {
        return ((int) (Math.random() * 6)) + 1 * getSword().getAttack();
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
