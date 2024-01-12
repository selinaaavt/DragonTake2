public class Room {
    private int roomNumber;
    private boolean searched;

    public Room() {
        roomNumber = 1;
        searched = false;
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

    }
    public void searchRoom(){
        searched = true;
    }
    public void dragonSpawn(){
        int x = (int) (Math.random()*2 +1);
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
