package com.ggl.pojo.tester.vavr.field.collections.map;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import io.vavr.collection.Map;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class AbstractMapValueChanger<T extends Map<?, ?>>
    extends VavrFieldValueChanger<T> {

  public static final AbstractFieldValueChanger<?> INSTANCE =
      new HashMapValueChanger()
          .attachNext(new LinkedHashMapValueChanger())
          .attachNext(new HashMapValueChanger())
          .attachNext(new TreeMapValueChanger());
}
