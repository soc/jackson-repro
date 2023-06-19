package repro;

import com.fasterxml.jackson.annotation.JsonValue;

public record RecordWithSingleValueValue(@JsonValue String value) {}
