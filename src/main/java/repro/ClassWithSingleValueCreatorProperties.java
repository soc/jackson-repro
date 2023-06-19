package repro;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ClassWithSingleValueCreatorProperties {

  private final String value;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public ClassWithSingleValueCreatorProperties(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
