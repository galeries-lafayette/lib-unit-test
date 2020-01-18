package com.ggl.pojo.tester.vavr.field.collections.seq.indexedSeq;

import io.vavr.collection.Array;

import static io.vavr.API.Array;
import static java.util.Objects.isNull;

public final class ArrayValueChanger extends AbstractIndexedSeqValueChanger<Array<?>> {

  @Override
  protected Array<?> increaseValue(final Array<?> value, final Class<?> type) {
    return isNull(value) || value.isEmpty() ? Array(new Object()) : Array();
  }
}
