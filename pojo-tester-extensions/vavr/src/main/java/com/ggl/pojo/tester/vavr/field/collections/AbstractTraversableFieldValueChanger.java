package com.ggl.pojo.tester.vavr.field.collections;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import com.ggl.pojo.tester.vavr.field.collections.map.AbstractMapValueChanger;
import com.ggl.pojo.tester.vavr.field.collections.seq.AbstractSeqValueChanger;
import io.vavr.collection.Traversable;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class AbstractTraversableFieldValueChanger<T extends Traversable<?>>
    extends VavrFieldValueChanger<T> {
  public static final AbstractFieldValueChanger<?> INSTANCE =
      AbstractSeqValueChanger.INSTANCE.attachNext(AbstractMapValueChanger.INSTANCE);
}
