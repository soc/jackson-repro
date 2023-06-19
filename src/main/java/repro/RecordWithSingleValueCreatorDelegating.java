package repro;

import com.fasterxml.jackson.annotation.JsonCreator;

public record RecordWithSingleValueCreatorDelegating(String value) {

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public RecordWithSingleValueCreatorDelegating {}

}
