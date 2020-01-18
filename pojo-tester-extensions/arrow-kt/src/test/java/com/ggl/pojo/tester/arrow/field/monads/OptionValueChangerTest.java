package com.ggl.pojo.tester.arrow.field.monads;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionValueChangerTest {

  private final OptionValueChanger valueChanger = new OptionValueChanger();

  @Test
  void should_return_some_when_value_is_null() {
    // When
    val option = valueChanger.increaseValue(null, String.class);

    // Then
    assertThat(option).isNotNull();
    assertThat(option.isDefined()).isTrue();
  }

  @Test
  void should_return_none_when_value_is_defined() {
    // When
    val option = valueChanger.increaseValue(new Some<>("value"), String.class);

    // Then
    assertThat(option).isNotNull();
    assertThat(option.isEmpty()).isTrue();
  }

  @Test
  void should_return_some_when_value_is_empty() {
    // When
    val option = valueChanger.increaseValue(None.INSTANCE, String.class);

    // Then
    assertThat(option).isNotNull();
    assertThat(option.isDefined()).isTrue();
  }

  @Test
  void can_change_from_validation() {
    // When
    val canChange = valueChanger.canChange(Option.class);

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
