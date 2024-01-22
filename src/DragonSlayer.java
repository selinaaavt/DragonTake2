import java.util.Scanner;

public class DragonSlayer {
    public Player playa;
    private Scanner scan;
    private Room roomies;
    private String mode;
    public DragonSlayer() {
        scan = new Scanner(System.in);
    }
    public void play() { //basic introduction to the game
        System.out.print("What is your name? ");
        String name = scan.nextLine();
        playa = new Player(name);
        System.out.println(Color.GREEN + "Welcome to the game, " + playa.getName() + Color.RESET);
        System.out.print("Are you ready to take on a mission and join room? " );
        String answer = scan.nextLine();
        if (answer.equals("yes")) { //checks if the player wants to start to play
            start();
        } else {
            System.out.println("Farewell, " + playa.getName());
            System.exit(0); //ends the game if not
        }
    }
    public void start() {
        System.out.print("Easy or hard mode: "); //ask the player to choose easy or hard mode
        mode = scan.nextLine();
        if (mode.equals("easy")) {
            roomies = new Room(playa, "easy");
            roomies.enterRoom();
            fight();
        } else {
            roomies = new Room(playa, "hard");
            roomies.enterRoom();
            fight();
        }
    }
    public void fightDragon(String mode, Dragon dragon) {
        if (mode.equals("easy")) { //checks if the player chose easy mode
            while (dragon.isAlive() && playa.alive) {
                System.out.println("Options: "); //prints out all options the plaayer has
                System.out.println(Color.RED + "a) inspect dragon’s level" + Color.RESET);
                System.out.println(Color.GREEN + "b) attack" + Color.RESET);
                System.out.println(Color.BLUE + "c) use health pot" + Color.RESET);
                System.out.println(Color.PURPLE + "d) view your current health" + Color.RESET);
                System.out.println(Color.YELLOW + "e) view current weapon stats" + Color.RESET);
                System.out.print("What option? ");
                String answer = scan.nextLine();
                if (answer.equals("b")) { //if the player chooses to attack
                    int multiplier = playa.attack(); //uses Attack() method from player class to determine attack, called multiplier
                    dragon.setHealth(dragon.getHealth() - multiplier); //takes off the attack amount from dragon's health
                    System.out.println(Color.YELLOW + "You attack the dragon -" + multiplier + Color.RESET);
                    if (dragon.getHealth() <= 0) { //checks if the dragon is dead and changes the boolean alive from the dragon class
                        dragon.setAlive(false);
                    }
                    if (dragon.isAlive() && playa.alive) {
                        int attackLand = ((int) (Math.random() * 101 + 1));
                        if (attackLand > playa.getSword().getDodge()) { //get the dodge rating and makes it that player randomly dodge on average dodgerating% of dragon attacks
                            int attack = dragon.easyAttack();
                            System.out.println(Color.RED + "The dragon attacks you! -" + attack + Color.RESET);
                            int health = playa.getHealth();
                            playa.setHealth(health - attack);
                            if (playa.getHealth() <= 0) { //checks if the player is dead and if so, tells the player
                                playa.alive = false;
                                playa.setScore(playa.getScore()* playa.getGold());
                                playa.determiningTopScore();
                                System.out.println("You have died!");
                                mainMenu();
                            }
                        } else {
                            System.out.println("The dragon missed his attack!");
                        }
                    }
                } else if (answer.equals("a")) { //other options if the player chooses
                    dragon.dragonInfo();
                } else if (answer.equals("d")) {
                    playa.playerInfo();
                } else if (answer.equals("c")) {
                    playa.checkForPot();
                } else if (answer.equals("e")) {
                    System.out.println(playa.getSword().swordInfo());
                }
            }
            if (playa.alive) {
                System.out.println(Color.YELLOW + "YOU HAVE SUCCESSFULLY SLAINED THE DRAGON" + Color.RESET);
                System.out.println();
                int goodies = ((int) (Math.random() * 100 + 1)); //randomly assigns a number from 1 to 99
                if (goodies > 85) {
                    System.out.print("The dragon dropped something, apply it to your sword? ");
                    String ans = scan.nextLine();
                    if (ans.equals("yes")) {
                        System.out.println("Your sword's attack has increased by 10");
                        playa.getSword().setAttack(playa.getSword().getAttack() + 10);
                    }
                } else if (goodies > 70) {
                    System.out.print("The dragon dropped something, apply it to your sword? ");
                    String ans = scan.nextLine();
                    if (ans.equals("yes")) {
                        System.out.println("Your sword's dodge rating has increased by 5");
                        playa.getSword().setDodge(playa.getSword().getDodge() + 5);
                    } else if (goodies > 65) {
                        if (dragon.getLevel() == 1) {
                            System.out.println("The dragon has dropped 10 gold");
                            playa.setGold(playa.getGold() + 10);
                        } else if (dragon.getLevel() == 2) {
                            System.out.println("The dragon has dropped 15 gold");
                            playa.setGold(playa.getGold() + 15);
                        } else if (dragon.getLevel() == 3) {
                            System.out.println("The dragon has dropped 20 gold");
                            playa.setGold(playa.getGold() + 20);
                        }
                    } else if (goodies > 50) {
                        if (dragon.getLevel() == 1) { //depending on dragon's level, the player's health would increase by a certain percentage
                            System.out.println("Your health increased by 10");
                            playa.setHealth(playa.getHealth() + 10);
                        } else if (dragon.getLevel() == 2) {
                            System.out.println("Your health increased by 15");
                            playa.setHealth(playa.getHealth() + 15);
                        } else if (dragon.getLevel() == 3) {
                            System.out.println("Your health increased by 20");
                            playa.setHealth(playa.getHealth() + 20);
                        }
                    } else {
                        System.out.println("Unlucky you, the dragon didnt drop anything.");
                    }
                }
            }
        } else if (mode.equals("hard")) { //route for the hard mode, which the player chooses
            while (dragon.isAlive() && playa.alive) {
                System.out.println("Options: "); //prints out all options
                System.out.println(Color.YELLOW + "a) inspect dragon’s level" + Color.RESET);
                System.out.println(Color.GREEN + "b) attack" + Color.RESET);
                System.out.println(Color.BLUE + "c) use health pot" + Color.RESET);
                System.out.println(Color.PURPLE + "d) view your current health" + Color.RESET);
                System.out.println(Color.YELLOW + "e) view current weapon stats" + Color.RESET);
                System.out.print("What option? ");
                String answer = scan.nextLine();
                if (answer.equals("b")) { //if the player chooses to attack
                    int multiplier = playa.hardAttack(); //uses hardAttack() method from player class to determine attack, called multiplier
                    dragon.setHealth(dragon.getHealth() - multiplier); //takes off the attack amount from dragon's health
                    System.out.println(Color.YELLOW + "You attack the dragon -" + multiplier + Color.RESET);
                    if (dragon.getHealth() <= 0) { //checks if the dragon is dead and changes the boolean alive from the dragon class
                        dragon.setAlive(false);
                    }
                    if (dragon.isAlive() && playa.alive) {
                        int attackLand = ((int) (Math.random() * 101 + 1));
                        if (attackLand > playa.getSword().getDodge()) { //get the dodge rating and makes it that player randomly dodge on average dodgerating% of dragon attacks
                            int attack = dragon.attack();
                            System.out.println(Color.RED + "The dragon attacks you! -" + attack + Color.RESET);
                            playa.setHealth(playa.getHealth() - attack);
                            if (playa.getHealth() <= 0) { //checks if the player is dead and if so, tells the player
                                playa.alive = false;
                                playa.setScore(playa.getScore()* playa.getGold());
                                playa.determiningTopScore();
                                    System.out.println("You have died!");
                                    mainMenu();
                            }
                        } else {
                                System.out.println("The dragon missed his attack!");
                        }
                    }
                } else if (answer.equals("a")) {
                    dragon.dragonInfo();
                } else if (answer.equals("d")) {
                    playa.playerInfo();
                } else if (answer.equals("c")) {
                    playa.checkForPot();
                } else if (answer.equals("e")) {
                    System.out.println(playa.getSword().swordInfo());
                }
            }
            if (playa.alive) { //player is alive but the dragon is dead
                System.out.println(Color.YELLOW + "YOU HAVE SUCCESSFULLY SLAINED THE DRAGON" + Color.RESET);
                System.out.println();
                int goodies = ((int) (Math.random() * 100 + 1)); //randomly assigns a number from 1 to 99
                if (goodies > 90) { //depending on the number, the player gets different outcomes to slaying the dragon
                    System.out.print("The dragon dropped something, apply it to your sword? ");
                    String ans = scan.nextLine();
                    if (ans.equals("yes")) {
                        System.out.println("Your sword's attack has increased by 5"); //only increases by 5 compared to 10 in easy mode
                        playa.getSword().setAttack(playa.getSword().getAttack() + 5);
                    }
                } else if (goodies > 83) {
                    System.out.print("The dragon dropped something, apply it to your sword? ");
                    String ans = scan.nextLine();
                    if (ans.equals("yes")) {
                        System.out.println("Your sword's dodge rating has increased by 5");
                        playa.getSword().setDodge(playa.getSword().getDodge() + 5);
                    } else if (goodies > 75) {
                        if (dragon.getLevel() == 1) {
                            System.out.println("The dragon has dropped 10 gold");
                            playa.setGold(playa.getGold() + 10);
                        } else if (dragon.getLevel() == 2) {
                            System.out.println("The dragon has dropped 15 gold");
                            playa.setGold(playa.getGold() + 15);
                        } else if (dragon.getLevel() == 3) {
                            System.out.println("The dragon has dropped 20 gold");
                            playa.setGold(playa.getGold() + 20);
                        }
                    } else if (goodies > 65) {
                        if (dragon.getLevel() == 1) { //depending on dragon's level, the player's health would increase by a certain percentage
                            System.out.println("Your health increased by 10");
                            playa.setHealth(playa.getHealth() + 10);
                        } else if (dragon.getLevel() == 2) {
                            System.out.println("Your health increased by 15");
                            playa.setHealth(playa.getHealth() + 15);
                        } else if (dragon.getLevel() == 3) {
                            System.out.println("Your health increased by 20");
                            playa.setHealth(playa.getHealth() + 20);
                        }
                    } else {
                        System.out.println(Color.BLUE + "Unlucky you, the dragon didnt drop anything." + Color.RESET); //nothing!
                    }
                }
            }
        }
    }
    public void fight() {
        while (roomies.roomNumber != 6 && playa.alive) { //checks if the player hasn't completed all 5 rooms and if the player is alive still
            if (playa.alive == true) {
                dragonSpawn();
                if (playa.alive) {
                    System.out.print("Do you wish to search " + roomies.x + "? "); //player can choose to search the room for a pot
                    String answer = scan.nextLine();
                    if (answer.equals("yes")) {
                        roomies.searchRoom();
                    } else {
                        System.out.println("Cool.");
                    }
                    System.out.print("Do you wish to move on to the next room? ");
                    String stuff = scan.nextLine();
                    if (answer.equals("yes")) {
                        roomies.killedDragon(); //updates room number
                        roomies.enterRoom();
                    }
                }
            }
        }
        if (playa.alive) { // if player has completed all 5 rooms
            playa.setScore(playa.getScore()* playa.getGold());
            playa.determiningTopScore(); //determines top score
            System.out.println(Color.YELLOW + "Congratulations! You have won the game!" + Color.RESET); //prints message
            mainMenu(); //mainmenu is presented for the player to choose
        }
    }
    public void dragonSpawn(){
        int howManyDragons = (int) (Math.random()*4 +1);
        System.out.println("The room has " + howManyDragons + " dragons. Beware!");
        for (int i = 0; i < howManyDragons; i++) { //loops through how many dragons had spawn
            if (playa.alive) {
                    Dragon dragon = new Dragon(playa);
                    System.out.println(Color.RED + "A new dragon has SPAWNED !!" + Color.RESET);
                    fightDragon(mode, dragon);
                    playa.setScore(playa.getScore()+1);
                    System.out.println();
            }
        }
    }
    private void mainMenu() { //main menu, prints out all the different options and let player choose
        System.out.println();
        System.out.println("----Main Menu----");
        System.out.println(Color.PURPLE + "a) start a new game" + Color.RESET);
        System.out.println(Color.BLUE + "b) quit" + Color.RESET);
        System.out.println(Color.YELLOW + "c) view top score" + Color.RESET);
        System.out.print("Which option? ");
        String option = scan.nextLine();
        if (option.equals("a")) {
            start();
        } else if (option.equals("b")) {
            System.out.println("Farewell!");
            System.exit(0); //stops the game if the player chooses to quit or b
        } else if (option.equals("c")) {
            System.out.println(playa.getTopScoreForAllGames());
        }
    }
}
