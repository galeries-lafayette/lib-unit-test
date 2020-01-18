package com.ggl.pojo.tester.arrow.field.monads;

import arrow.core.Either;
import lombok.val;
import org.junit.jupiter.api.Test;

import static arrow.core.EitherKt.Left;
import static arrow.core.EitherKt.Right;
import static org.assertj.core.api.Assertions.assertThat;

class EitherValueChangerTest {

  private final EitherValueChanger valueChanger = new EitherValueChanger();

  @Test
  void should_return_right_when_value_is_null() {
    // When
    val either = valueChanger.increaseValue(null, String.class);

    // Then
    assertThat(either).isNotNull();
    assertThat(either.isRight()).isTrue();
  }

  @Test
  void should_return_left_when_value_is_right() {
    // When
    val either = valueChanger.increaseValue(Right("value"), String.class);

    // Then
    assertThat(either).isNotNull();
    assertThat(either.isLeft()).isTrue();
  }

  @Test
  void should_return_right_when_value_is_left() {
    // When
    val either = valueChanger.increaseValue(Left("value"), String.class);

    // Then
    assertThat(either).isNotNull();
    assertThat(either.isRight()).isTrue();
  }

  @Test
  void can_change_from_validation() {
    // When
    val canChange = valueChanger.canChange(Either.class);

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
