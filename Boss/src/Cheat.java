import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Cheat {
    public static void changeAttribute(SubPlayer subPlayer) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
//        SubPlayer.class.getDeclaredField()
//        System.out.println("角色修改为X倍 \nX = ");
//        Scanner in = new Scanner(System.in);
//        int x = in.nextInt();
//        Class<SubPlayer> playclass = SubPlayer.class;
//        Constructor constructor = playclass.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        SubPlayer subPlayer1 = (SubPlayer) constructor.newInstance();
//        Field ad = playclass.getDeclaredField("ad");
//        Field ap = playclass.getDeclaredField("ap");
//        Field hp = playclass.getDeclaredField("hp");
//        Field addodge = playclass.getDeclaredField("addodge");
//        Field apdodge = playclass.getDeclaredField("apdodge");
//        Field evade = playclass.getDeclaredField("evade");
//        ad.setAccessible(true);
//        ap.setAccessible(true);
//        hp.setAccessible(true);
//        addodge.setAccessible(true);
//        apdodge.setAccessible(true);
//        evade.setAccessible(true);
//        ad.set(subPlayer,subPlayer.getAd()*x);
//        ap.set(subPlayer,subPlayer.getAp()*x);
//        hp.set(subPlayer,subPlayer.getHp()*x);
//        addodge.set(subPlayer,subPlayer.getAddodge()*x);
//        apdodge.set(subPlayer,subPlayer.getApdodge()*x);
//        evade.set(subPlayer,subPlayer.getEvade()*x);
        //更改的属性是父类的，无法返回到子类 ——> 通过方法修改?

//        Method setHp = playclass.getDeclaredMethod("setHp",double.class);
//        Method setAd = playclass.getDeclaredMethod("setAd",int.class);
//        Method setAp = playclass.getDeclaredMethod("setAp",int.class);
//        Method setAddodge = playclass.getDeclaredMethod("setAddodge",int.class);
//        Method setApdodge = playclass.getDeclaredMethod("setApdodge",int.class);
//        Method setEvade = playclass.getDeclaredMethod("setEvade",int.class);
//        setHp.setAccessible(true);
//        setAd.setAccessible(true);
//        setAp.setAccessible(true);
//        setAddodge.setAccessible(true);
//        setApdodge.setAccessible(true);
//        setEvade.setAccessible(true);
//        setHp.invoke(subPlayer,subPlayer.getHp()*x);
//        setAd.invoke(subPlayer,subPlayer.getAd()*x);
//        setAp.invoke(subPlayer,subPlayer.getAp()*x);
//        setAddodge.invoke(subPlayer,subPlayer.getAddodge()*x);
//        setApdodge.invoke(subPlayer,subPlayer.getApdodge()*x);
        //通过父类的方法修改也不行 无法体现多态？

        Player player = null;
        BaronNashor baronNashor = null;
        if (subPlayer instanceof Player) {
            System.out.println("角色修改为X倍 \nX = ");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            player = (Player) (subPlayer);
            Class<Player> playclass = Player.class;
            Field ad = playclass.getDeclaredField("ad");
            Field ap = playclass.getDeclaredField("ap");
            Field hp = playclass.getDeclaredField("hp");
            Field addodge = playclass.getDeclaredField("addodge");
            Field apdodge = playclass.getDeclaredField("apdodge");
            Field evade = playclass.getDeclaredField("evade");
            ad.setAccessible(true);
            ap.setAccessible(true);
            hp.setAccessible(true);
            addodge.setAccessible(true);
            apdodge.setAccessible(true);
            evade.setAccessible(true);
            ad.set(player, player.getAd() * x);
            ap.set(player, player.getAp() * x);
            hp.set(player, player.getHp() * x);
            addodge.set(player, player.getAddodge() * x);
            apdodge.set(player, player.getApdodge() * x);
            evade.set(player, player.getEvade() * x);
        } else {
            System.out.println("大龙修改修1/X倍 \nX = ");
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            baronNashor = (BaronNashor) subPlayer;
            Class<BaronNashor> playclass = BaronNashor.class;
            Field NAME = playclass.getDeclaredField("NAME");
            Field ad = playclass.getDeclaredField("ad");
            Field ap = playclass.getDeclaredField("ap");
            Field hp = playclass.getDeclaredField("hp");
            Field addodge = playclass.getDeclaredField("addodge");
            Field apdodge = playclass.getDeclaredField("apdodge");
            Field evade = playclass.getDeclaredField("evade");
            ad.setAccessible(true);
            ap.setAccessible(true);
            hp.setAccessible(true);
            addodge.setAccessible(true);
            apdodge.setAccessible(true);
            evade.setAccessible(true);
            ad.set(baronNashor, baronNashor.getAd() / x);
            ap.set(baronNashor, baronNashor.getAp() / x);
            hp.set(baronNashor, baronNashor.getHp() / x);
            addodge.set(baronNashor, baronNashor.getAddodge() / x);
            apdodge.set(baronNashor, baronNashor.getApdodge() / x);
            evade.set(baronNashor, baronNashor.getEvade() / x);
        }
    }

    public static BaronNashor create() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<BaronNashor> nashorClass = BaronNashor.class;
        //private BaronNashor(double hp, int ad, int ap, int addodge, int apdodge, int evade)
        Constructor constructor = nashorClass.getDeclaredConstructor(double.class, int.class, int.class, int.class, int.class, int.class);
        constructor.setAccessible(true);
        BaronNashor myBaronNashor = (BaronNashor) constructor.newInstance(99999.99999, 99999, 99999, 99999, 99999, 100);
        return myBaronNashor;
    }

    public static void changeAttribute(Player player,int x) throws NoSuchFieldException, IllegalAccessException {
        Class<Player> playclass = Player.class;
        Field ad = playclass.getDeclaredField("ad");
        Field ap = playclass.getDeclaredField("ap");
        Field hp = playclass.getDeclaredField("hp");
        Field addodge = playclass.getDeclaredField("addodge");
        Field apdodge = playclass.getDeclaredField("apdodge");
        Field evade = playclass.getDeclaredField("evade");
        ad.setAccessible(true);
        ap.setAccessible(true);
        hp.setAccessible(true);
        addodge.setAccessible(true);
        apdodge.setAccessible(true);
        evade.setAccessible(true);
        ad.set(player, player.getAd() * x);
        ap.set(player, player.getAp() * x);
        hp.set(player, player.getHp() * x);
        addodge.set(player, player.getAddodge() * x);
        apdodge.set(player, player.getApdodge() * x);
        evade.set(player, player.getEvade() * x);
    }

    public static void win(BaronNashor baronNashor) throws NoSuchFieldException, IllegalAccessException {
        Class<BaronNashor> Nashorclass = BaronNashor.class;
        Field hp = Nashorclass.getDeclaredField("hp");
        hp.setAccessible(true);
        System.out.println("一股神秘力量对"+baronNashor.getName()+"造成了"+baronNashor.getHp()+"伤害");
        hp.set(baronNashor,0);
        System.out.println("纳什男爵死亡，你获得了胜利");
    }
}
