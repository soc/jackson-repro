package repro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;

/**
 * This test is intended to ...
 * a) defend against regressions in Jackson
 * b) document some of our Jackson usage patterns
 * c) answer recurring questions like
 *    "when do we need JsonCreator.Mode.DELEGATING?" or
 *    "why @JsonCreator *and* @JsonValue, isn't @JsonValue sufficient?".
 */
public class JacksonSerializationTest {

  private static final ObjectMapper mapper = new ObjectMapper();

  @Test
  public void classWithSingleValueCreatorDelegating() throws JsonProcessingException {
    var instance = new ClassWithSingleValueCreatorDelegating("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueCreatorDelegating.class));
  }

  @Test
  public void classWithSingleValueCreatorDelegatingProperty() throws JsonProcessingException {
    var instance = new ClassWithSingleValueCreatorDelegatingProperty("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueCreatorDelegatingProperty.class));
  }

  @Test
  public void classWithSingleValueCreatorProperties() throws JsonProcessingException {
    var instance = new ClassWithSingleValueCreatorProperties("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing @JsonProperty
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueCreatorProperties.class));
  }

  @Test
  public void classWithSingleValueCreatorPropertiesProperty() throws JsonProcessingException {
    var instance = new ClassWithSingleValueCreatorPropertiesProperty("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueCreatorPropertiesProperty.class));
  }

  @Test
  public void classWithSingleValueGetConstructor() throws JsonProcessingException {
    var instance = new ClassWithSingleValueGetConstructor("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueGetConstructor.class));
  }

  @Test
  public void classWithSingleValueGetSet() throws JsonProcessingException {
    var instance = new ClassWithSingleValueGetSet();
    instance.setValue("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    mapper.readValue(result, ClassWithSingleValueGetSet.class);
  }

  @Test
  public void classWithSingleValueProperty() throws JsonProcessingException {
    var instance = new ClassWithSingleValueProperty("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, ClassWithSingleValueProperty.class));
  }

  @Test
  public void recordWithSingleValue() throws JsonProcessingException {
    var instance = new RecordWithSingleValue("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, RecordWithSingleValue.class));
  }

  @Test
  public void recordWithSingleValueCreatorDelegating() throws JsonProcessingException {
    var instance = new RecordWithSingleValueCreatorDelegating("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, RecordWithSingleValueCreatorDelegating.class));
  }

  @Test
  public void recordWithSingleValueCreatorDelegatingValue() throws JsonProcessingException {
    var instance = new RecordWithSingleValueCreatorDelegatingValue("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("\"foo\"", result);
    mapper.readValue(result, RecordWithSingleValueCreatorDelegatingValue.class);
  }

  @Test
  public void recordWithSingleValueCreatorProperties() throws JsonProcessingException {
    var instance = new RecordWithSingleValueCreatorProperties("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("{\"value\":\"foo\"}", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, RecordWithSingleValueCreatorProperties.class));
  }

  @Test
  public void recordWithSingleValueCreatorPropertiesValue() throws JsonProcessingException {
    var instance = new RecordWithSingleValueCreatorPropertiesValue("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("\"foo\"", result);
    // serialized as delegated value, tries to deserialize as properties, i. e. `"{\"value\":\"foo\"}"` would work
    assertThrows(MismatchedInputException.class,
        () -> mapper.readValue(result, RecordWithSingleValueCreatorPropertiesValue.class));
  }

  @Test
  public void recordWithSingleValueValue() throws JsonProcessingException {
    var instance = new RecordWithSingleValueValue("foo");
    var result = mapper.writeValueAsString(instance);
    assertEquals("\"foo\"", result);
    // missing setter
    assertThrows(InvalidDefinitionException.class,
        () -> mapper.readValue(result, RecordWithSingleValue.class));
  }

}
