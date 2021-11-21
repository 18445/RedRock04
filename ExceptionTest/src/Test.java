import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        try {
            int age = ScannerTest.intScanner();
            if (age < 0 ){
                throw new AgeOutOfLimitException("你输入的数字为负，有异常");
            }else if (age > 180){
                throw new AgeOutOfLimitException("你输入的数字过大，有异常");
            }else{
                System.out.println("你的年龄为："+age);
            }
        } catch (InputMismatchException e) {
            System.out.println("输入不为数字");
            e.printStackTrace();
        } catch(AgeOutOfLimitException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("输入完毕");
        }

        int[] arr = new int[10];
        for (int i:arr) {
            arr[i] = (int)(Math.random()*99+1);
        }
        System.out.println("输入1-10内的数字抽取一个幸运数字");
        try (Scanner in = new Scanner(System.in)) {
            int random = in.nextInt();
            System.out.println("你的幸运数字为：" + arr[random]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("你输入的数字有误");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("你的操作有误");
            e.printStackTrace();
        }


    }

}
