package gun03t.loginWithMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListAndMap {

    public static void main(String[] args) {

        int[] arr = {1, 2};
        arr[0] = 5;


        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.set(1, 10);

        Map<String, String> map = new HashMap<>();
        map.put("Name", "Ali");
        map.put("Address", "Ist");
        map.put("Age", "12");
        map.get("Name");


        map.forEach((k, v) -> {
            System.out.println(k + ", " + v + " --- " + map.get(k));
        });
    }
}
