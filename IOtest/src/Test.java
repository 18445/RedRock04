import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("1: 文档读写");
        System.out.println("2: 对象读写");
        System.out.println("0：  退出");
        Scanner in = new Scanner(System.in);
//        for(;;){
            int choice = in.nextInt();
            switch(choice){
                case 1:
                    Scanner text = new Scanner(System.in);
                    System.out.println("文件路径：");
                    String path = text.next();
                    System.out.println("输入内容：(0退出)");
                    StringBuilder con = new StringBuilder();
                    for(;;){
                        String con1 = in.next();
                        char judge = con1.charAt(0);
                        int len = con1.length();
                        if(judge == '0' && len == 1){
                            break;
                        }
                        con.append(con1);
                    }
                    text.close();
                    WriteMethod.write(path, con.toString());
                    System.out.println("输入内容为：");
                    ReadMethod.read(path);
                    break;
                case 2:
                    Scanner player = new Scanner(System.in);
                    System.out.println("姓名");
                    String name = player.next();
                    System.out.println("年龄");
                    int age = player.nextInt();
                    System.out.println("身高");
                    double height = player.nextDouble();
                    System.out.println("体重");
                    double weight = player.nextDouble();
                    player.close();
                    Person person = new Person(name,age,height,weight);
                    ObjectOutput.Output(person);
                    System.out.println("对象读取成功……");
                    System.out.println("储存的对象为:");
                    ObjectInput.Input();
                    break;
                case 0:
                    in.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误");

//            }
        }
    }
}
