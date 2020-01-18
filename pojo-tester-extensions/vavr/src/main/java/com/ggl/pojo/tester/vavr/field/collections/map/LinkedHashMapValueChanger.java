package com.ggl.pojo.tester.vavr.field.collections.map;

import io.vavr.collection.LinkedHashMap;

import static io.vavr.collection.LinkedHashMap.empty;
import static java.util.Objects.isNull;

public final class LinkedHashMapValueChanger extends AbstractMapValueChanger<LinkedHashMap<?, ?>> {

  @Override
  protected LinkedHashMap<?, ?> increaseValue(
      final LinkedHashMap<?, ?> value, final Class<?> type) {
    return isNull(value) || value.isEmpty() ? LinkedHashMap.of("key", new Object()) : empty();
  }
}
