package com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq;

import com.ggl.pojo.tester.vavr.field.collections.seq.AbstractSeqValueChanger;
import io.vavr.collection.LinearSeq;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class AbstractLinearSeqValueChanger<T extends LinearSeq<?>>
    extends AbstractSeqValueChanger<T> {
  public static final AbstractFieldValueChanger<?> INSTANCE =
      new ListValueChanger().attachNext(new StreamValueChanger());
}
