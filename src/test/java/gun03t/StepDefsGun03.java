package gun03t;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class StepDefsGun03 {
    @Given("my list {int}")
    public void myList(int num, DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        System.out.println(num);
        System.out.println(list);
        list.forEach(e -> System.out.println(e + " : " + (e * e)));
    }

    @Then("conclusion")
    public void conclusion() {
        int x;
    }

    @Given("my lists, list of list")
    public void myListsListOfList(DataTable table) {
        List<List<Integer>> lists = table.asLists(Integer.class);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }


    }

    @Given("my map")
    public void myMap(DataTable table) {
        Map<String, Integer> map = table.asMap(String.class, Integer.class);

        System.out.println(map);
        System.out.println(map.get("key1"));
    }

    @Given("my maps, list of maps")
    public void myMapsListOfMaps(DataTable table) {
        List<Map<String, Integer>> maps = table.asMaps(String.class, Integer.class);
        maps.forEach(System.out::println);
    }
}
