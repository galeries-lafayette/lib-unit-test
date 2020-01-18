package com.ggl.pojo.tester.arrow.field.monads;

import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.ggl.pojo.tester.arrow.field.ArrowFieldValueChanger;

import static java.util.Objects.nonNull;

public final class OptionValueChanger extends ArrowFieldValueChanger<Option<?>> {

  @Override
  protected Option<?> increaseValue(final Option<?> value, final Class<?> type) {
    return nonNull(value) && value.isDefined() ? None.INSTANCE : new Some<>(new Object());
  }
}
