import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutput {
    public static void Output(Object object) {
        ObjectOutputStream oops = null;
        try {
            oops = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oops.writeObject(object);
            oops.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oops != null) {
                try {
                    oops.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
