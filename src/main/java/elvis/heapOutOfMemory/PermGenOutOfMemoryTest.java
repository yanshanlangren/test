package elvis.heapOutOfMemory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PermGenOutOfMemoryTest {

    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        URL url = null;
        int i = 0;
        List classLoaderList = new ArrayList();
        try {
            url = new File("/tmp").toURI().toURL();
            URL[] urls = {url};
            while (true){
                i++;
                ClassLoader loader = new URLClassLoader(urls);
                classLoaderList.add(loader);
                loader.loadClass("elvis.heapOutOfMemory.PermGenOutOfMemoryTest");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(i);
            System.out.println(LocalDateTime.now());
        }
    }
}
