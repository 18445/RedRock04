import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInput {
    public static void Input(){
        ObjectInputStream oips = null;
        FileInputStream path1;
        try {
            path1 = new FileInputStream("object.dat");
        } catch (FileNotFoundException e) {
            System.out.println("路径不存现在");
            e.printStackTrace();
            return;
        }
        try {
            oips = new ObjectInputStream(path1);
            Object object  = oips.readObject();
            System.out.println(object);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (oips != null||path1!=null){
                try {
                    oips.close();
                    path1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
