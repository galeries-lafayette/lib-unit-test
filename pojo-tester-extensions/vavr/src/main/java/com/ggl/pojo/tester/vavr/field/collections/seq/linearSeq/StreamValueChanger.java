package com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq;

import io.vavr.collection.Stream;

import static io.vavr.API.Stream;
import static java.util.Objects.nonNull;

public final class StreamValueChanger extends AbstractLinearSeqValueChanger<Stream<?>> {

  @Override
  protected Stream<?> increaseValue(final Stream<?> value, final Class<?> type) {
    return nonNull(value) && !value.isEmpty() ? Stream() : Stream(new Object());
  }
}
