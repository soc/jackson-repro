package repro;

import com.fasterxml.jackson.annotation.JsonCreator;

public class ClassWithSingleValueCreatorDelegating {

  private final String value;

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public ClassWithSingleValueCreatorDelegating(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

}
