import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.*;

/*
    Level 3：简易计算器
    要求：
    假设用户输入的表达式（字符串）具有如下一般形式：
    【数字】【符号】【数字】
    则计算这串表达式的值，并输出，输出保留3位小数。
    如果用户输入不符合上式规范，则抛出自定义的异常（选做）或者直接输出“表达式不符合规范”。
    这里的数字可以是浮点数（如果支持负数则加分）。
    知识需求：
    1. 异常相关知识
    2. 从控制台接受用户输入的数据Scanner
*/
public class Test {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("输入表达式:");
        String experssion = in.next();
//    String pattern = "【\\d*】[+\\-*/]【\\d*】";
        String pattern = "【.*】[+\\-*/]【.*】";
        boolean isMatch = Pattern.matches(pattern, experssion);
        if (!isMatch) {
            throw new TypeError("表达式不规范");
        }
        String regre = "[【】]";
        String result = experssion.replaceAll(regre, "");
        String[] strArr = result.split("[+\\-*/]");
        double first = 0;
        double last = 0;
        try {
            first = Double.parseDouble(strArr[0]);
            last = Double.parseDouble(strArr[1]);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        char math = result.charAt(strArr[0].length());
        double num = switch (math) {
            case 43 -> first + last;
            case 45 -> first - last;
            case 42 -> first * last;
            case 47 -> first / last;
            default -> 0;
        };
        DecimalFormat formatnum = new DecimalFormat("0.000");
        String num0 = formatnum.format(num);
        if (Double.parseDouble(num0) == num) {
            System.out.println(result + " = " + num0);
        } else {
            System.out.println(result + " ≈ " + num0);
        }

    }
}

class TypeError extends Exception {
    public TypeError() {
    }

    public TypeError(String message) {
        super(message);
    }

}
