package com.ggl.pojo.tester.vavr.config;

import com.ggl.pojo.tester.config.ExtensionConfig;
import com.ggl.pojo.tester.vavr.field.VavrFieldValueChanger;
import com.ggl.pojo.tester.vavr.instantiator.VavrTypesInstantiator;
import pl.pojo.tester.internal.field.DefaultFieldValueChanger;
import pl.pojo.tester.internal.instantiator.Instantiator;

public final class VavrConfig implements ExtensionConfig {

  @Override
  public void initContext() {
    Instantiator.INSTANCE.attach(VavrTypesInstantiator.class);
    DefaultFieldValueChanger.INSTANCE.attachNext(VavrFieldValueChanger.INSTANCE);
  }
}
