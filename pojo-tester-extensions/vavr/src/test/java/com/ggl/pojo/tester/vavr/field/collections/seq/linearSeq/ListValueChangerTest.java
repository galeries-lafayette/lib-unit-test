package com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq;

import io.vavr.collection.List;
import org.junit.jupiter.api.Test;

import static io.vavr.collection.List.Nil;
import static org.assertj.core.api.Assertions.assertThat;

class ListValueChangerTest {

  private final ListValueChanger valueChanger = new ListValueChanger();

  @Test
  void should_return_nil_when_value_is_not_empty() {
    assertThat(valueChanger.increaseValue(List.of("A"), ((List<?>) List.of("A")).getClass()))
        .isEqualTo(Nil.instance());
  }

  @Test
  void should_return_new_instance_when_value_is_nil() {
    assertThat(valueChanger.increaseValue(Nil.instance(), String.class)).isNotNull();
  }

  @Test
  void can_change_from_list() {
    assertThat(valueChanger.canChange(List.class)).isTrue();
  }

  @Test
  void can_change_from_nil_list() {
    assertThat(valueChanger.canChange(Nil.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
