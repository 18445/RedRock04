import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerTest {
    public static int intScanner() throws InputMismatchException {
        System.out.println("输入数字");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        return num;
    }
}
