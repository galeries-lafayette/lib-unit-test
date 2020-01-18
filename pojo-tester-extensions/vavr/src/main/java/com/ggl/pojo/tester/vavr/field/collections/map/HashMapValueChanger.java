package com.ggl.pojo.tester.vavr.field.collections.map;

import io.vavr.collection.HashMap;

import static java.util.Objects.isNull;

public final class HashMapValueChanger extends AbstractMapValueChanger<HashMap<?, ?>> {

  @Override
  protected HashMap<?, ?> increaseValue(final HashMap<?, ?> value, Class<?> type) {
    return isNull(value) || value.isEmpty() ? HashMap.of("key", new Object()) : HashMap.empty();
  }
}
