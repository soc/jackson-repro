package repro;

public class ClassWithSingleValueGetConstructor {

  private final String value;

  public ClassWithSingleValueGetConstructor(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
