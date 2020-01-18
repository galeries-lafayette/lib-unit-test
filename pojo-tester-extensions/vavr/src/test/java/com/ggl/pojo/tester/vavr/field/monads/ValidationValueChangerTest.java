package com.ggl.pojo.tester.vavr.field.monads;

import io.vavr.control.Validation;
import org.junit.jupiter.api.Test;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

class ValidationValueChangerTest {

  private final ValidationValueChanger valueChanger = new ValidationValueChanger();

  @Test
  void should_return_valid_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull().isValid();
  }

  @Test
  void should_return_invalid_when_value_is_valid() {
    assertThat(valueChanger.increaseValue(Valid("value"), String.class)).isNotNull().isInvalid();
  }

  @Test
  void should_return_valid_when_value_is_invalid() {
    assertThat(valueChanger.increaseValue(Invalid("value"), String.class)).isNotNull().isValid();
  }

  @Test
  void can_change_from_validation() {
    assertThat(valueChanger.canChange(Validation.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
