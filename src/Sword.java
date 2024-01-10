public class Sword {
    private int attack;
    private int dodge;
    public Sword() {
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
}
