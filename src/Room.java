public class Room {
    private int roomNumber;

    public Room() {
        roomNumber = 1;

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
        System.out.println("You have entered the a room called, ");
    }
    public void searchRoom( ){

    }
    public void killedDragon() {
        roomNumber +=1;
    }
}
