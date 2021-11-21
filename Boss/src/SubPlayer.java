public class SubPlayer {
    private String name;
    private double hp;
    private int ad;
    private int ap;
    private int addodge;
    private int apdodge;
    private int evade;

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

    public void beAttack(double damage2){
    }

    public  static boolean isAlive(SubPlayer subPlayer){
        return subPlayer.getHp() > 0;
    }
}
