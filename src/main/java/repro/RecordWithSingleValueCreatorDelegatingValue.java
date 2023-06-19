package repro;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public record RecordWithSingleValueCreatorDelegatingValue(@JsonValue String value) {

  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  public RecordWithSingleValueCreatorDelegatingValue {}

}
