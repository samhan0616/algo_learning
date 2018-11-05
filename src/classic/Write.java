package classic;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author create by Xiao Han 10/25/18
 * @version 1.0
 * @since jdk 1.8
 */
public class Write {

  public static void main(String[] args) throws IOException {
    File file =  new File("test");
    file.createNewFile();
    String str = "我饿了";
    FileOutputStream fio = new FileOutputStream(file);
    fio.write(str.getBytes("GBK"));
    fio.flush();
    fio.close();
  }
}
