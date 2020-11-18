import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName aaaa
 * @Description: TODO
 * @Author BYJ
 * @Date 2020/7/13
 * @Version V1.0
 **/
public class aaaa {
    public static void main(String[] args) {
        Map<String,String> a = new HashMap<String,String>();
        a.put("a","1");
        a.put("b","2");
        String value = a.get("a");
        System.out.println(value);
        Set<Map.Entry<String, String>> entries = a.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        for (String s : a.keySet()) {
            System.out.println(a.get(s));
            System.out.println(a);

        }


    }
    private String[] getLineResult (String a){

        String substring = a.substring(0, 20);
        String substring1 = a.substring(50, 61);
        String[] strings = {substring,substring1};
        return  strings;
    }
}
