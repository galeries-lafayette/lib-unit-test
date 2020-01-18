package com.ggl.pojo.tester.vavr.config;

import io.vavr.collection.List;
import io.vavr.control.Option;
import io.vavr.control.Validation;
import lombok.Builder;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.ggl.pojo.tester.config.PojoConfig.initContext;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

class VavrConfigTest {

  @BeforeAll
  private static void init() {
    initContext("com.ggl", VavrConfig.class);
  }

  @Test
  void pojo_test() {
    // Asserts
    assertPojoMethodsForAll(Pojo.class, Pojo.Internal.class, Pojo.Internal2.class)
        .areWellImplemented();
  }

  @Value
  @Builder
  private static class Pojo {
    private static final int count = 0;
    List<String> vavrList;
    Option<Long> vavrOption;
    Validation<String, Integer> vavrValidation;
    String s;
    List<Internal> internals;
    Option<Internal2> internal2;

    @Value
    private static class Internal {
      List<Long> internalList;
      Option<String> internalOption;
    }

    @Value
    private static class Internal2 {
      String s;
    }
  }
}
