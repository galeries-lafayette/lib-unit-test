package com.ggl.pojo.tester.arrow.field.monads;

import arrow.data.Validated;
import arrow.data.Validated.Invalid;
import arrow.data.Validated.Valid;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatedValueChangerTest {

  private final ValidatedValueChanger valueChanger = new ValidatedValueChanger();

  @Test
  void should_return_valid_when_value_is_null() {
    // When
    val validated = valueChanger.increaseValue(null, String.class);

    // Then
    assertThat(validated).isNotNull();
    assertThat(validated.isValid()).isTrue();
  }

  @Test
  void should_return_invalid_when_value_is_valid() {
    // When
    val validated = valueChanger.increaseValue(new Valid<Object>("value"), String.class);

    // Then
    assertThat(validated).isNotNull();
    assertThat(validated.isInvalid()).isTrue();
  }

  @Test
  void should_return_valid_when_value_is_invalid() {
    // When
    val validated = valueChanger.increaseValue(new Invalid<Object>("value"), String.class);

    // Then
    assertThat(validated).isNotNull();
    assertThat(validated.isValid()).isTrue();
  }

  @Test
  void can_change_from_validation() {
    // When
    val canChange = valueChanger.canChange(Validated.class);

    // Then
    assertThat(canChange).isTrue();
  }

  @Test
  void cannot_change() {
    // When
    val canChange = valueChanger.canChange(String.class);

    // Then
    assertThat(canChange).isFalse();
  }
}
