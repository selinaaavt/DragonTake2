import java.util.Scanner;

public class Room {
    public int roomNumber;
    private boolean searched;
    private Scanner scan;
    private Player player;
    private String mode;
    public String x;
    public Room(Player player, String mode) {
        roomNumber = 1;
        searched = false;
        scan = new Scanner(System.in);
        this.player = player;
        this.mode = mode;
    }
    public void enterRoom() { //different names of the rooms, determined by roomNumber
        x = "";
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
        System.out.println(Color.BLUE + "You have entered the a new room called, " + x + "." + Color.RESET);

    }
    public void searchRoom(){
            int x = (int) (Math.random()*5 +1); //random number is generated
            if (x >= 3) { //if the number is greater than or equal to 3, the player would find a healthpot
                System.out.println("You found a health pot!");
                System.out.print("Do you want to use it now? y/n: ");
                String answer = scan.nextLine();
                if (answer.equals("y")) {
                    player.setHealth(player.getHealth() + (100 - player.getHealth())/2);
                } else {
                    System.out.println("Great! Lets reserve it for later");
                    player.sethealthPotStatus(true);
                }
            } else {
                System.out.println("You found nothing!");
            }
    }
    public void killedDragon() {
        roomNumber +=1;
    }
}
