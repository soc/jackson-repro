package repro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record RecordWithSingleValueCreatorPropertiesValue(@JsonValue String value) {

  @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
  public RecordWithSingleValueCreatorPropertiesValue {}

}
