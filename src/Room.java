import java.sql.SQLOutput;
import java.util.Scanner;

public class Room {
    private int roomNumber;
    private boolean searched;
    private Scanner scan;
    private Player player;

    public Room(Player player) {
        roomNumber = 1;
        searched = false;
        scan = new Scanner(System.in);
        this.player = player;
    }
    public void enterRoom() {
        String x = "";
        if (roomNumber == 1) {
            x = "the lair";
        } else if (roomNumber == 2) {
            x = "the lab";
        } else if (roomNumber == 3) {
            x = "the cove";
        } else if (roomNumber == 4) {
            x = "the hatching";
        } else if (roomNumber == 5) {
            x = "the room";
        }
        System.out.println("You have entered the a room called, " + x);
        fight();
    }

    public void fight() {
        if (roomNumber == 1) {

        }
    }

    public void searchRoom(){
        if (searched == false) {
            int x = (int) (Math.random()*5 +1);
            if (x >= 4) {
                System.out.println("You found a health pot!");
                System.out.print("Do you want to use it now? y/n: ");
                String answer = scan.nextLine();
                if (answer.equals("y")) {
                    player.setHealth(player.getHealth() + (100 - player.getHealth())/2);
                } else {
                    System.out.println("Great! Lets reserve it for later");
                }
            }
        }
        searched = true;
    }
    public void dragonSpawn(){
        int x = (int) (Math.random()*3 +1);
        if (x == 1) {
            Dragon dragon = new Dragon();
        } else if (x == 2) {
            Dragon dragon = new Dragon();
            Dragon dragon1 = new Dragon();
        } else if (x == 3) {
            Dragon dragon = new Dragon();
            Dragon dragon1 = new Dragon();
            Dragon dragon2 = new Dragon();
        }
    }
    public void killedDragon() {
        roomNumber +=1;
    }
}
