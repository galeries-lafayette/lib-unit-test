package com.ggl.pojo.tester.vavr.field.monads;

import io.vavr.control.Option;
import org.junit.jupiter.api.Test;

import static io.vavr.API.None;
import static io.vavr.API.Some;
import static org.assertj.core.api.Assertions.assertThat;

class OptionValueChangerTest {

  private final OptionValueChanger valueChanger = new OptionValueChanger();

  @Test
  void should_return_some_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull().isNotEmpty();
  }

  @Test
  void should_return_none_when_value_is_defined() {
    assertThat(valueChanger.increaseValue(Some("value"), String.class)).isEqualTo(None());
  }

  @Test
  void should_return_some_when_value_is_empty() {
    assertThat(valueChanger.increaseValue(None(), String.class)).isNotNull().isNotEmpty();
  }

  @Test
  void can_change_from_validation() {
    assertThat(valueChanger.canChange(Option.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
