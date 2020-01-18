package com.ggl.pojo.tester.vavr.field.collections.seq.indexedSeq;

import io.vavr.collection.Array;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArrayValueChangerTest {

  private final ArrayValueChanger valueChanger = new ArrayValueChanger();

  @Test
  void should_return_empty_when_value_is_not_null() {
    assertThat(valueChanger.increaseValue(Array.of("A"), String.class)).isNotNull().isEmpty();
  }

  @Test
  void should_return_instance_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull();
  }

  @Test
  void can_change_from_array() {
    assertThat(valueChanger.canChange(Array.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
