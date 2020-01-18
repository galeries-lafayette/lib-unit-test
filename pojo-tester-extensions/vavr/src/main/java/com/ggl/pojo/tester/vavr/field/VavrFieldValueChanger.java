package com.ggl.pojo.tester.vavr.field;

import com.ggl.pojo.tester.vavr.field.collections.AbstractTraversableFieldValueChanger;
import com.ggl.pojo.tester.vavr.field.monads.EitherValueChanger;
import com.ggl.pojo.tester.vavr.field.monads.OptionValueChanger;
import com.ggl.pojo.tester.vavr.field.monads.ValidationValueChanger;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class VavrFieldValueChanger<T> extends AbstractFieldValueChanger<T> {

  public static final AbstractFieldValueChanger<?> INSTANCE =
      AbstractTraversableFieldValueChanger.INSTANCE
          .attachNext(new ValidationValueChanger())
          .attachNext(new OptionValueChanger())
          .attachNext(new EitherValueChanger());

  @Override
  public boolean canChange(final Class<?> type) {
    return getGenericTypeClass().isAssignableFrom(type);
  }
}
