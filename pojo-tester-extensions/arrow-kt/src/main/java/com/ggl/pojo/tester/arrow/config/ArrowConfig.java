package com.ggl.pojo.tester.arrow.config;

import com.ggl.pojo.tester.arrow.field.ArrowFieldValueChanger;
import com.ggl.pojo.tester.arrow.instantiator.ArrowTypesInstantiator;
import com.ggl.pojo.tester.config.ExtensionConfig;
import pl.pojo.tester.internal.field.DefaultFieldValueChanger;
import pl.pojo.tester.internal.instantiator.Instantiator;

public final class ArrowConfig implements ExtensionConfig {

  @Override
  public void initContext() {
    Instantiator.INSTANCE.attach(ArrowTypesInstantiator.class);
    DefaultFieldValueChanger.INSTANCE.attachNext(ArrowFieldValueChanger.INSTANCE);
  }
}
