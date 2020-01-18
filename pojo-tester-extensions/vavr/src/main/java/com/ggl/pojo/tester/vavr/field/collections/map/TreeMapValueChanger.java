package com.ggl.pojo.tester.vavr.field.collections.map;

import io.vavr.collection.TreeMap;

import java.util.Objects;

import static io.vavr.collection.TreeMap.empty;

public final class TreeMapValueChanger extends AbstractMapValueChanger<TreeMap<?, ?>> {

  @Override
  protected TreeMap<?, ?> increaseValue(final TreeMap<?, ?> value, final Class<?> type) {
    return Objects.isNull(value) || value.isEmpty() ? TreeMap.of("key", new Object()) : empty();
  }
}
