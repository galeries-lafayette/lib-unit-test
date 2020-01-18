package com.ggl.pojo.tester.arrow.field.monads;

import arrow.core.Either;
import com.ggl.pojo.tester.arrow.field.ArrowFieldValueChanger;

import static arrow.core.EitherKt.Left;
import static arrow.core.EitherKt.Right;
import static java.util.Objects.nonNull;

public final class EitherValueChanger extends ArrowFieldValueChanger<Either<?, ?>> {

  @Override
  protected Either<?, ?> increaseValue(final Either<?, ?> value, final Class<?> type) {
    return nonNull(value) && value.isRight() ? Left(new Object()) : Right(new Object());
  }
}
