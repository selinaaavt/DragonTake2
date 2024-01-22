public class Sword {
    private int attack;
    private int dodge;
    public Sword() { //starting stats
        attack = 10;
        dodge = 20;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDodge(int dodge) {
        this.dodge = dodge;
    }
    public int getAttack() {
        return attack;
    }
    public int getDodge() {
        return dodge;
    }
    public String swordInfo() { //prints out basic information of the sword
        return "---Sword Info---\n" + "attack: " + getAttack() + "\ndodge: " + getDodge();
    }
}
