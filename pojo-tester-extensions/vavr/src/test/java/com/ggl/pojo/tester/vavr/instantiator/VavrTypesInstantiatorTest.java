package com.ggl.pojo.tester.vavr.instantiator;

import io.vavr.collection.*;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static io.vavr.API.List;

class VavrTypesInstantiatorTest {

  List<VavrTypesInstantiator> classes =
      List(
              Stream.class,
              Vector.class,
              List.class,
              Set.class,
              Seq.class,
              HashMap.class,
              LinkedHashMap.class,
              Map.class,
              Array.class,
              Validation.class,
              Option.class,
              Queue.class,
              IndexedSeq.class,
              Try.class,
              Either.class,
              Future.class)
          .map(this::instance);

  @Test
  void should_try_to_instantiate() {
    classes
        .map(VavrTypesInstantiator::tryToInstantiate)
        .map(Optional::isPresent)
        .map(Assertions::assertThat)
        .forEach(AbstractBooleanAssert::isTrue);
  }

  @Test
  void can_instantiate() {
    classes
        .map(VavrTypesInstantiator::canInstantiate)
        .map(Assertions::assertThat)
        .forEach(AbstractBooleanAssert::isTrue);
  }

  private VavrTypesInstantiator instance(Class<?> clazz) {
    return new VavrTypesInstantiator(clazz, null);
  }
}
