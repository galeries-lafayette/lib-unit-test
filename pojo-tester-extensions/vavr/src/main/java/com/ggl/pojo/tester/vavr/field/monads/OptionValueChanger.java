package com.ggl.pojo.tester.vavr.field.monads;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import io.vavr.control.Option;

import static io.vavr.API.None;
import static io.vavr.API.Some;
import static java.util.Objects.nonNull;

public final class OptionValueChanger extends VavrFieldValueChanger<Option<?>> {

  @Override
  protected Option<?> increaseValue(final Option<?> value, final Class<?> type) {
    return nonNull(value) && value.isDefined() ? None() : Some(new Object());
  }
}
