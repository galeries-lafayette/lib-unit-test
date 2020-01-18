package com.ggl.pojo.tester.arrow.instantiator;

import arrow.core.Either;
import arrow.core.Option;
import arrow.data.Validated;
import org.assertj.core.api.AbstractBooleanAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class ArrowTypesInstantiatorTest {

  List<ArrowTypesInstantiator> classes =
      Stream.of(Validated.class, Option.class, Either.class).map(this::instance).collect(toList());

  @Test
  void should_try_to_instantiate() {
    classes.stream()
        .map(ArrowTypesInstantiator::tryToInstantiate)
        .map(Optional::isPresent)
        .map(Assertions::assertThat)
        .forEach(AbstractBooleanAssert::isTrue);
  }

  @Test
  void can_instantiate() {
    classes.stream()
        .map(ArrowTypesInstantiator::canInstantiate)
        .map(Assertions::assertThat)
        .forEach(AbstractBooleanAssert::isTrue);
  }

  private ArrowTypesInstantiator instance(final Class<?> clazz) {
    return new ArrowTypesInstantiator(clazz, null);
  }
}
