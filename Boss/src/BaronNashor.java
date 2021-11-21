import java.util.Objects;

public class BaronNashor extends SubPlayer{
//    private static final String NAME = "BaronNashor";
    private static String NAME = "BaronNashor";
    private double hp;
    private int ad;
    private int ap;
    private int addodge;
    private int apdodge;
    private int evade;

    private BaronNashor(double hp, int ad, int ap, int addodge, int apdodge, int evade) {
        this.hp = hp;
        this.ad = ad;
        this.ap = ap;
        this.addodge = addodge;
        this.apdodge = apdodge;
        this.evade = evade;
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
    public String getName(){
        return NAME;
    }

    private void setHp(double hp) {
        this.hp = hp;
    }

    private void setAd(int ad) {
        this.ad = ad;
    }

    public void setAp(int ap) {
        this.ap = ap;
    }

    public void setAddodge(int addodge) {
        this.addodge = addodge;
    }

    public void setApdodge(int apdodge) {
        this.apdodge = apdodge;
    }

    public void setEvade(int evade) {
        this.evade = evade;
    }


    @Override
    public String toString() {
        return "BaronNashor{" +
                "name=" + NAME +
                ", hp=" + hp +
                ", ad=" + ad +
                ", ap=" + ap +
                ", addodge=" + addodge +
                ", apdodge=" + apdodge +
                ", evade=" + evade +
                '}';
    }

    public void beAttack(double damage2){
        this.hp = this.hp - damage2;
    }

    static BaronNashor baronNashor = null;
    public static synchronized BaronNashor getInstance(){
        return Objects.requireNonNullElseGet(baronNashor, () -> baronNashor = new BaronNashor(99999.99999, 99999, 99999, 99999, 99999, 100));
//        if(baronNashor == null){
//            return baronNashor = new BaronNashor(99999.99999,99999,99999,99999,99999,100);
//        }else{
//            return baronNashor;
//        }
    }

}
