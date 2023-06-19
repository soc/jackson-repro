package repro2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerialization2Test {

  private static final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void recordWithMultipleValuesAndOnePropertyAccessAnnotationDto() throws JsonProcessingException {
    var instance = new RecordWithMultipleValuesAndOnePropertyAccessAnnotationDto("foo", "val1");
    var result = mapper.writeValueAsString(instance);
    assertEquals("""
        {"a":"foo","b":"val1"}""", result);
    mapper.readValue(result, RecordWithMultipleValuesAndOnePropertyAccessAnnotationDto.class);
  }

}
