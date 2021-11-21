import java.io.*;
public class WriteMethod {
    public static void write(String path,String message){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            //提供File类的对象，指明写出到的文件
            File file = new File(path);
            //提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file,true);
            bw = new BufferedWriter(fw);
            //写出的操作
            bw.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //流资源的关闭
            if(fw != null||bw != null){
                try {
                    bw.close();
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
