package com.ggl.pojo.tester.vavr.field.monads;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import io.vavr.control.Either;

import static io.vavr.API.Left;
import static io.vavr.API.Right;
import static java.util.Objects.nonNull;

public final class EitherValueChanger extends VavrFieldValueChanger<Either<?, ?>> {

  @Override
  protected Either<?, ?> increaseValue(final Either<?, ?> value, final Class<?> type) {
    return nonNull(value) && value.isRight() ? Left(new Object()) : Right(new Object());
  }
}
