package refactor.me.json;

import com.google.gson.Gson;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import refactor.me.json.GSONHelper;
import refactor.me.json.SomeSettingsClass;

/**
 *
 * @author Luke
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        SomeSettingsClass cl = new SomeSettingsClass();
        cl.other = 323;
        cl.stringSetting = "This is one setting";
        cl.floatingPoint = 33421.3621115f;
        cl.arrayOfStrings = new String[]{"string one", "string two", "string three\\with some\ncrazy ,characters \"' to spice things up:\\\\"};
        cl.hashmap.put("Even hashmaps work", "like they should");
        GSONHelper helper = new GSONHelper();
        helper.saveClass(new FileOutputStream("./test4.gson"), cl);

        
        
        SomeSettingsClass loaded = (SomeSettingsClass) helper.loadClass(new FileInputStream("./test4.gson"), SomeSettingsClass.class);
        System.out.println("other: " + loaded.other);
        System.out.println("stringSetting: " + loaded.stringSetting);
        System.out.println("floatingPoint: " + loaded.floatingPoint);
        for(String s : loaded.arrayOfStrings){
            System.out.println("arrayOfStrings[n]=" + s);
        }
        for(String s : loaded.hashmap.keySet()){
            System.out.println("Hashmap: [" + s + ": " + loaded.hashmap.get(s) + "]");
        }
    }
    
}
