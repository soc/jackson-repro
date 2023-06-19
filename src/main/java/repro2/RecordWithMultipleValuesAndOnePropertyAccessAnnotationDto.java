package repro2;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RecordWithMultipleValuesAndOnePropertyAccessAnnotationDto(
    String a,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    String b) {}
