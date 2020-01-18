package com.ggl.pojo.tester.vavr.field.collections.map;

import io.vavr.collection.TreeMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeMapValueChangerTest {

  private final TreeMapValueChanger valueChanger = new TreeMapValueChanger();

  @Test
  void should_return_empty_when_value_is_not_empty() {
    assertThat(valueChanger.increaseValue(TreeMap.of("A", "A"), String.class))
        .isNotNull()
        .isEmpty();
  }

  @Test
  void should_return_new_instance_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull();
  }

  @Test
  void can_change_from_treemap() {
    assertThat(valueChanger.canChange(TreeMap.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
