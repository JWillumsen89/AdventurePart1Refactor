import java.util.ArrayList;
import java.util.List;

public class Item {
  private String name;
  private String description;

  Item(String name, String description) {
    this.name = name;
    this.description = description;
  }

  void itemm() {
    String[] items = {"item 1", "item 2", "item 4", "osv..."};
    ArrayList<String> item = new ArrayList<>(List.of(items));

    item.add("item 4");
    item.add("item 5");
    System.out.println(item);
  }


}
