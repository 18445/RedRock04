import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Player player = Player.getInstance();
        BaronNashor baronNashor = BaronNashor.getInstance();
        System.out.println("balabalabala……");
        System.out.println("经过重重难关，你成功遇到了纳什 男爵");
        boolean game = true;
        Scanner in = new Scanner(System.in);
        System.out.println("面对强大的纳什男爵，你陷入了思考…………");
        int count = 0;
        boolean isCheat = false;
        while (game) {
            if(count>0){
                System.out.println("你重生了");
                System.out.println("你感到自己地属性收到了增益");
                System.out.println("你的战斗技巧更加熟练");
                int random;
                if(count<10){
                    random = (int)Math.sqrt((1+Math.random()*count));
                }else if(count <25){
                    random =  (int)Math.sqrt(Math.sqrt((1+Math.random()*count)));
                }else{
                    random = 1;
                }
                try {
                    Cheat.changeAttribute(player,random);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("你的选择是——");
            System.out.println("1： 攻击");
            System.out.println("2： 开挂 ");
            System.out.println("0:退出游戏");
            int choice = in.nextInt();
            switch (choice) {
                case 1 -> {
                    if (count > 0) {
                        System.out.println("你第" + count + "次发起了攻击");
                    } else {
                        System.out.println("你奋力一击");
                    }
                    Attack.attack(Player.getInstance(), BaronNashor.getInstance());
                    System.out.println("纳什男爵的血量是" + baronNashor.getHp());
                    if (baronNashor.getHp() > 50000) {
                        System.out.println("纳什男爵感到身上有点痒");
                        System.out.println("纳什男爵拍了一下你");
                    } else if (baronNashor.getHp() > 5000) {
                        System.out.println("纳什男爵感到有点痛");
                        System.out.println("男神男爵吼了你一下");
                    } else if (baronNashor.getHp() > 500) {
                        System.out.println("纳什很生气并冲向了你");
                    } else if (baronNashor.getHp() > 0) {
                        System.out.println("纳什男爵无力地发出了反抗");
                    }
                    if(SubPlayer.isAlive(baronNashor)){
                    Attack.attack(baronNashor, player);
                    }
                    count++;
                    if (!SubPlayer.isAlive(baronNashor)) {
                        game = false;
                        System.out.println("你获得了游戏胜利");
                    }
                }
                case 2 -> {
                    isCheat = true;
                    System.out.println("你选择了开启外挂");
                    System.out.println("1：修改角色属性");
                    System.out.println("2：修改大龙属性");
                    System.out.println("3: 创造一个右方大龙大龙攻击敌方");
                    System.out.println("4: 直接获得游戏胜利");
                    int cheatchoice = in.nextInt();
                    switch (cheatchoice) {
                        case 1:
                            try {
                                Cheat.changeAttribute(Player.getInstance());
                            } catch (NoSuchFieldException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            try {
                                Cheat.changeAttribute(BaronNashor.getInstance());
                            } catch (NoSuchFieldException | InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 3:
                            try {
                                Attack.attack(Cheat.create(), baronNashor);
                            } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            if (!SubPlayer.isAlive(baronNashor)) {
                                game = false;
                                System.out.println("你获得了游戏胜利");
                            }
                            break;
                        case 4:
                            try {
                                Cheat.win(baronNashor);
                            } catch (NoSuchFieldException | IllegalAccessException e) {
                                e.printStackTrace();
                            }
                            game = false;
                            break;
                    }
                }
                case 0 -> System.exit(0);
                default -> System.out.println("输入有误");
            }

        }
        if(!isCheat){
            System.out.println("凭借你的坚持，你击败了大龙");
            System.out.println("你获得了队友的称赞");
        }else{
            System.out.println("卑鄙的外乡人用科技击败了大龙");
            System.out.println("你收到了队友的鄙视");
        }
    }
}
