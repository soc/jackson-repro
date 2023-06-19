package repro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassWithSingleValueCreatorPropertiesProperty {

  private final String value;

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public ClassWithSingleValueCreatorPropertiesProperty(@JsonProperty("value") String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
