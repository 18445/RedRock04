public class Attack {
    public static void attack(SubPlayer subPlayer1 , SubPlayer subPlayer2){//1攻击2
        double damage;
        if(subPlayer1.getEvade()<subPlayer2.getEvade()){
        damage = (((double) subPlayer1.getAd() - (subPlayer2.getAddodge()/(double)subPlayer1.getAd()))
                +   ((double) subPlayer1.getAp()- (subPlayer2.getApdodge()/(double)subPlayer1.getAp())))
                *   (subPlayer1.getEvade()/(double)subPlayer2.getEvade()) ;
        }else {
            damage = (((double) subPlayer1.getAd() - (subPlayer2.getAddodge() / (double) subPlayer1.getAd()))
                    + ((double) subPlayer1.getAp() - (subPlayer2.getApdodge() / (double) subPlayer1.getAp())));
        }
        if(damage <= 0 ){
            damage = 0;
        }
        subPlayer2.beAttack(damage);
        System.out.println(subPlayer1.getName()+"对"+subPlayer2.getName()+"造成了"+damage+"伤害");
        if(!SubPlayer.isAlive(subPlayer2)){
            System.out.println(subPlayer2.getName()+"死亡");
        }
    }

}
