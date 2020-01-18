package com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq;

import io.vavr.collection.List;

import static io.vavr.API.List;
import static java.util.Objects.isNull;

public final class ListValueChanger extends AbstractLinearSeqValueChanger<List<?>> {

  @Override
  protected List<?> increaseValue(final List<?> value, final Class<?> type) {
    return isNull(value) || value.isEmpty() ? List(new Object()) : List();
  }
}
