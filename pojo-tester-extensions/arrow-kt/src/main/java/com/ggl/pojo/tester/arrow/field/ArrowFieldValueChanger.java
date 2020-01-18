package com.ggl.pojo.tester.arrow.field;

import com.ggl.pojo.tester.arrow.field.monads.EitherValueChanger;
import com.ggl.pojo.tester.arrow.field.monads.OptionValueChanger;
import com.ggl.pojo.tester.arrow.field.monads.ValidatedValueChanger;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class ArrowFieldValueChanger<T> extends AbstractFieldValueChanger<T> {

  public static final AbstractFieldValueChanger<?> INSTANCE =
      new OptionValueChanger()
          .attachNext(new ValidatedValueChanger())
          .attachNext(new EitherValueChanger());

  @Override
  public boolean canChange(final Class<?> type) {
    return getGenericTypeClass().isAssignableFrom(type);
  }
}
