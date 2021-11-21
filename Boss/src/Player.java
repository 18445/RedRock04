import java.util.Objects;

public class Player extends SubPlayer{
    private String name;
    private double hp;
    private int ad;
    private int ap;
    private int addodge;
    private int apdodge;
    private int evade;
    private BaronNashor baronNashor;

    private Player(String name, double hp, int ad, int ap, int addodge, int apdodge, int evade) {
        this.name = name;
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
        this.addodge = addodge;
        this.apdodge = apdodge;
        this.evade = evade;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }

    public int getAddodge() {
        return addodge;
    }

    public int getApdodge() {
        return apdodge;
    }

    public int getEvade() {
        return evade;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setHp(double hp) {
        this.hp = hp;
    }

    private void setAd(int ad) {
        this.ad = ad;
    }

    private void setAp(int ap) {
        this.ap = ap;
    }

    private void setAddodge(int addodge) {
        this.addodge = addodge;
    }

    private void setApdodge(int apdodge) {
        this.apdodge = apdodge;
    }

    private void setEvade(int evade) {
        this.evade = evade;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", ad=" + ad +
                ", ap=" + ap +
                ", addodge=" + addodge +
                ", apdodge=" + apdodge +
                ", evade=" + evade +
                '}';
    }

    static Player player = null;
    public static synchronized Player getInstance(){
        return Objects.requireNonNullElseGet(player, () -> player = new Player("英雄", 2021.214171, 202, 121, 41, 71, 30));
//        if(player == null ){
//            return player = new Player("英雄",2021.214171,202,121,41,71,30);
//        }else {
//            return player;
//        }
    }

    public void beAttack(double damage2){
        this.hp = this.hp - damage2;
    }




}