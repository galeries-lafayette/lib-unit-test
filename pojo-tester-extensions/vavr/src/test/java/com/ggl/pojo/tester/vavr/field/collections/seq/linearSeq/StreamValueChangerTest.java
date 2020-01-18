package com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq;

import io.vavr.collection.Stream;
import io.vavr.collection.Stream.Empty;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StreamValueChangerTest {

  private final StreamValueChanger valueChanger = new StreamValueChanger();

  @Test
  void should_return_empty_when_value_is_not_null() {
    assertThat(valueChanger.increaseValue(Stream.of("A"), String.class)).isNotNull().isEmpty();
  }

  @Test
  void should_return_instance_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull();
  }

  @Test
  void can_change_from_stream() {
    assertThat(valueChanger.canChange(Stream.class)).isTrue();
  }

  @Test
  void can_change_from_empty_stream() {
    assertThat(valueChanger.canChange(Empty.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
