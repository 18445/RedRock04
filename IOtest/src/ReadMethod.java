import java.io.*;
public class ReadMethod {
    public static void read(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            //File类的实例化
            File file = new File(path);
            if (!file.exists()) {
                System.out.println("文件不存在");
            }
            //FileReader流的实例化
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];
            int len;
            br.read(cbuf);
            while ((len = br.read(cbuf)) != -1) {
                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null || br != null) {
                //资源的关闭
                try {
                    br.close();
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String ReadfromKeyborad() {
        System.out.println("请输入数据:");
        InputStreamReader is;
        BufferedReader br = null;
        String con = null;
        try {
            is = new InputStreamReader(System.in);
            br = new BufferedReader(is);
            con = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return con;

    }
}
