package com.ggl.pojo.tester.vavr.field.monads;

import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static io.vavr.API.Left;
import static io.vavr.API.Right;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.vavr.api.VavrAssertions.assertThat;

class EitherValueChangerTest {

  private final EitherValueChanger valueChanger = new EitherValueChanger();

  @Test
  void should_return_right_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull().isRight();
  }

  @Test
  void should_return_left_when_value_is_right() {
    assertThat(valueChanger.increaseValue(Right("value"), String.class)).isNotNull().isLeft();
  }

  @Test
  void should_return_right_when_value_is_left() {
    assertThat(valueChanger.increaseValue(Left("value"), String.class)).isNotNull().isRight();
  }

  @Test
  void can_change_from_validation() {
    assertThat(valueChanger.canChange(Either.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
