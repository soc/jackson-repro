package repro;

import com.fasterxml.jackson.annotation.JsonCreator;

public record RecordWithSingleValueCreatorProperties(String value) {

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public RecordWithSingleValueCreatorProperties {}

}
