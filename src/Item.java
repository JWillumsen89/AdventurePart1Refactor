public abstract class Item {

  private String name;
  private String description;
  private int weight;

  Item(String name, String description, int weight) {
    this.name = name;
    this.description = description;
    this.weight = weight;
  }

  public Item(String name) {
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return description;
  }
}