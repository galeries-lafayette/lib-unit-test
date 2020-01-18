package com.ggl.pojo.tester.vavr.field;

import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VavrFieldValueChangerTest {

  @Test
  void can_change() {
    // Given
    val valueChanger =
        new VavrFieldValueChanger<String>() {
          @Override
          protected String increaseValue(final String s, final Class<?> aClass) {
            return null;
          }
        };

    // When
    val canChange = valueChanger.canChange(String.class);

    // Then
    assertThat(canChange).isTrue();
  }
}
