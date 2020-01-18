package com.ggl.pojo.tester.arrow.field.monads;

import arrow.data.Validated;
import com.ggl.pojo.tester.arrow.field.ArrowFieldValueChanger;

import static arrow.data.Validated.Invalid;
import static arrow.data.Validated.Valid;
import static java.util.Objects.nonNull;

public final class ValidatedValueChanger extends ArrowFieldValueChanger<Validated<?, ?>> {

  @Override
  protected Validated<?, ?> increaseValue(final Validated<?, ?> value, final Class<?> type) {
    return nonNull(value) && value.isValid()
        ? new Invalid<>(new Object())
        : new Valid<>(new Object());
  }
}
