package com.ggl.pojo.tester.arrow.config;

import arrow.core.Either;
import arrow.core.Option;
import arrow.core.Validated;
import lombok.Builder;
import lombok.Value;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.ggl.pojo.tester.config.PojoConfig.initContext;
import static pl.pojo.tester.api.assertion.Assertions.assertPojoMethodsForAll;

class ArrowConfigTest {

  @BeforeAll
  private static void init() {
    initContext("com.ggl", ArrowConfig.class);
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
    Option<Long> vavrOption;
    Validated<String, Integer> vavrValidation;
    String s;
    Either<String, Internal> internalEither;
    Option<Internal2> internal2;

    @Value
    private static class Internal {
      Either<String, Long> internalEither;
      Option<String> internalOption;
    }

    @Value
    private static class Internal2 {
      String s;
    }
  }
}
