import java.util.Scanner;

public class DragonSlayer {
    public Player playa;
    private Scanner scan;
    private Room roomies;
    private String mode;
    public DragonSlayer() {
        scan = new Scanner(System.in);
    }
    public void play() {
        System.out.print("What is your name? ");
        String name = scan.nextLine();
        playa = new Player(name);
        System.out.println(Color.GREEN + "Welcome to the game, " + playa.getName() + Color.RESET);
        System.out.print("Are you ready to take on a mission and join room? " );
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            start();
        } else {
            System.out.println("Farewell, " + playa.getName());
        }
    }
    public void start() {
        System.out.print("Easy or hard mode: ");
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
        if (mode.equals("easy")) {
            while (dragon.isAlive() && playa.alive) {
                System.out.println("Options: ");
                System.out.println(Color.RED + "a) inspect dragon’s level" + Color.RESET);
                System.out.println(Color.GREEN + "b) attack" + Color.RESET);
                System.out.println(Color.BLUE + "c) use health pot" + Color.RESET);
                System.out.println(Color.PURPLE + "d) view your current health" + Color.RESET);
                System.out.println(Color.YELLOW + "e) view current weapon stats" + Color.RESET);
                System.out.print("What option? ");
                String answer = scan.nextLine();
                if (answer.equals("b")) {
                    int multiplier = ((int) (Math.random() * 10)) + 1 * playa.getSword().getAttack();
                    dragon.setHealth(dragon.getHealth() - multiplier);
                    System.out.println(Color.YELLOW + "You attack the dragon -" + multiplier + Color.RESET);
                    if (dragon.getHealth() <= 0) {
                        dragon.setAlive(false);
                    }
                    if (dragon.isAlive() && playa.alive) {
                        int attackLand = ((int) (Math.random() * 101 + 1));
                        if (attackLand > playa.getSword().getDodge()) {
                            int attack = ((int) (Math.random() * 10 + 1)) * dragon.getLevel();
                            System.out.println(Color.RED + "The dragon attacks you! -" + attack + Color.RESET);
                            int health = playa.getHealth();
                            playa.setHealth(health - attack);
                            if (playa.getHealth() <= 0) {
                                playa.alive = false;
                                System.out.println("You have died!");
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
            if (playa.alive) {
                System.out.println(Color.YELLOW + "YOU HAVE SUCCESSFULLY SLAINED THE DRAGON" + Color.RESET);
                System.out.println();
                int goodies = ((int) (Math.random() * 100 + 1));
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
                        if (dragon.getLevel() == 1) {
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
        } else if (mode.equals("hard")) {
                while (dragon.isAlive() && playa.alive) {
                    System.out.println("Options: ");
                    System.out.println(Color.YELLOW + "a) inspect dragon’s level" + Color.RESET);
                    System.out.println(Color.GREEN + "b) attack" + Color.RESET);
                    System.out.println(Color.BLUE + "c) use health pot" + Color.RESET);
                    System.out.println(Color.PURPLE + "d) view your current health" + Color.RESET);
                    System.out.println(Color.YELLOW + "e) view current weapon stats" + Color.RESET);
                    System.out.print("What option? ");
                    String answer = scan.nextLine();
                    if (answer.equals("b")) {
                        int multiplier = ((int) (Math.random() * 6) + 1) * playa.getSword().getAttack();
                        dragon.setHealth(dragon.getHealth() - multiplier);
                        System.out.println(Color.YELLOW + "You attack the dragon -" + multiplier + Color.RESET);
                        if (dragon.getHealth() <= 0) {
                            dragon.setAlive(false);
                        }
                        if (dragon.isAlive() && playa.alive) {
                            int attackLand = ((int) (Math.random() * 101 + 1));
                            if (attackLand > playa.getSword().getDodge()) {
                                int attack = ((int) (Math.random() * 10 + 1)) * dragon.getLevel();
                                System.out.println(Color.RED + "The dragon attacks you! -" + attack + Color.RESET);
                                playa.setHealth(playa.getHealth() - attack);
                                if (playa.getHealth() <= 0) {
                                    playa.alive = false;
                                    System.out.println("You have died!");
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
                if (playa.alive) {
                    System.out.println(Color.YELLOW + "YOU HAVE SUCCESSFULLY SLAINED THE DRAGON" + Color.RESET);
                    System.out.println();
                    int goodies = ((int) (Math.random() * 100 + 1));
                    if (goodies > 90) {
                        System.out.print("The dragon dropped something, apply it to your sword? ");
                        String ans = scan.nextLine();
                        if (ans.equals("yes")) {
                            System.out.println("Your sword's attack has increased by 5");
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
                            if (dragon.getLevel() == 1) {
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
            }
    }
    public void fight() {
        while (roomies.roomNumber != 6 && playa.alive) {
            if (playa.alive == true) {
                dragonSpawn();
                System.out.print("Do you wish to search " + roomies.x + "? ");
                String answer = scan.nextLine();
                if (answer.equals("yes")) {
                    roomies.searchRoom();
                } else {
                    System.out.println("Cool.");
                }
                System.out.print("Do you wish to move on to the next room? ");
                String stuff = scan.nextLine();
                if (answer.equals("yes")) {
                    roomies.killedDragon();
                    roomies.enterRoom();
                }
            }
        }
        if (playa.alive) {
            System.out.println(Color.YELLOW + "Congratulations! You have won the game!" + Color.RESET);
        }
    }
    public void dragonSpawn(){
        int howManyDragons = (int) (Math.random()*4 +1);
        System.out.println("The room has " + howManyDragons + " dragons. Beware!");
            for (int i = 0; i < howManyDragons; i++) {
                if (playa.alive) {
                    Dragon dragon = new Dragon(playa);
                    System.out.println(Color.RED + "A new dragon has SPAWNED !!" + Color.RESET);
                    fightDragon(mode, dragon);
                    System.out.println();
                }
            }

    }
}
