package com.ggl.pojo.tester.vavr.field.collections.seq.indexedSeq;

import com.ggl.pojo.tester.vavr.field.collections.seq.AbstractSeqValueChanger;
import io.vavr.collection.IndexedSeq;
import pl.pojo.tester.internal.field.AbstractFieldValueChanger;

public abstract class AbstractIndexedSeqValueChanger<T extends IndexedSeq<?>>
    extends AbstractSeqValueChanger<T> {
  public static final AbstractFieldValueChanger<?> INSTANCE = new ArrayValueChanger();
}
