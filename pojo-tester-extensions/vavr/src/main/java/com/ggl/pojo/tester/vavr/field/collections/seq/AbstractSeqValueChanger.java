package com.ggl.pojo.tester.vavr.field.collections.seq;

import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import com.ggl.pojo.tester.vavr.field.collections.seq.indexedSeq.AbstractIndexedSeqValueChanger;
import com.ggl.pojo.tester.vavr.field.collections.seq.linearSeq.AbstractLinearSeqValueChanger;
import io.vavr.collection.Seq;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class AbstractSeqValueChanger<T extends Seq<?>> extends VavrFieldValueChanger<T> {
  public static final AbstractFieldValueChanger<?> INSTANCE =
      AbstractLinearSeqValueChanger.INSTANCE.attachNext(AbstractIndexedSeqValueChanger.INSTANCE);
}
