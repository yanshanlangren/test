package elvis.yaml;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public class YamlReader {
    public Map parseYaml(String cf) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        return yaml.load(new FileInputStream(new File(cf)));
    }

    public static void main(String[] args) throws FileNotFoundException {
        YamlReader yr = new YamlReader();
        Map m = yr.parseYaml("C:\\Users\\Elvis\\Desktop\\config.yaml");
        for(Map m1: (ArrayList<Map>)m.get("redis")) {
            System.out.println(m1.get("host"));
            System.out.println(m1.get("port"));
        }
    }
}
