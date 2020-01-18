package com.ggl.pojo.tester.vavr.field.collections.map;

import io.vavr.collection.LinkedHashMap;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedHashMapValueChangerTest {

  private final LinkedHashMapValueChanger valueChanger = new LinkedHashMapValueChanger();

  @Test
  void should_return_empty_when_value_is_not_empty() {
    assertThat(valueChanger.increaseValue(LinkedHashMap.of("A", "A"), String.class))
        .isNotNull()
        .isEmpty();
  }

  @Test
  void should_return_new_instance_when_value_is_null() {
    assertThat(valueChanger.increaseValue(null, String.class)).isNotNull();
  }

  @Test
  void can_change_from_linkedhashmap() {
    assertThat(valueChanger.canChange(LinkedHashMap.class)).isTrue();
  }

  @Test
  void cannot_change() {
    assertThat(valueChanger.canChange(String.class)).isFalse();
  }
}
