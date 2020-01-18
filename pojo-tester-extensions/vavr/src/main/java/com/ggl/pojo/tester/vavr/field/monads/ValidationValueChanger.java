package com.ggl.pojo.tester.vavr.field.monads;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import io.vavr.control.Validation;

import static io.vavr.API.Invalid;
import static io.vavr.API.Valid;
import static java.util.Objects.nonNull;

public final class ValidationValueChanger extends VavrFieldValueChanger<Validation<?, ?>> {

  @Override
  protected Validation<?, ?> increaseValue(final Validation<?, ?> value, final Class<?> type) {
    return nonNull(value) && value.isValid() ? Invalid(new Object()) : Valid(new Object());
  }
}
