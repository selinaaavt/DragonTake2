import java.util.Scanner;

public class DragonSlayer {
    public Player playa;
    private Scanner scan;
    public DragonSlayer() {
        scan = new Scanner(System.in);
    }
    public void play() {
        System.out.print("What is your name? ");
        String name = scan.nextLine();
        playa = new Player(name);
        System.out.println(Color.GREEN + "Welcome to the game, " + playa + Color.RESET);
        System.out.print("Are you ready to take on a mission and join room? " );
        String answer = scan.nextLine();
        if (answer.equals("yes")) {
            start();
        } else {
            System.out.println("Farewell, " + playa);
        }
    }
    public void start() {
        System.out.print("Easy or hard mode: ");
        String answer = scan.nextLine();
        if (answer.equals("easy")) {
            easy();
        } else {
            hard();
        }
    }
    public void easy() {
        Room roomies = new Room(playa);
    }
    public void hard() {

    }
}
