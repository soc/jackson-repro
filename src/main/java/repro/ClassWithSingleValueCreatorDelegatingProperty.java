package repro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClassWithSingleValueCreatorDelegatingProperty {

  private final String value;

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ClassWithSingleValueCreatorDelegatingProperty(@JsonProperty String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
