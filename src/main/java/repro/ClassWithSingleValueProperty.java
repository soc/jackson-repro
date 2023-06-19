package repro;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassWithSingleValueProperty {

  private final String value;

  public ClassWithSingleValueProperty(@JsonProperty String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
