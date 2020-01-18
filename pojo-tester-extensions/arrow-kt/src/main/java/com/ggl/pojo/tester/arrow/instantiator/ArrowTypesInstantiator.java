package com.ggl.pojo.tester.arrow.instantiator;

import arrow.core.Either;
import arrow.core.None;
import arrow.core.Option;
import arrow.data.Validated;
import arrow.data.Validated.Valid;
import org.apache.commons.collections4.MultiValuedMap;
import pl.pojo.tester.api.ConstructorParameters;
import pl.pojo.tester.internal.instantiator.UserObjectInstantiator;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import static arrow.core.Either.Left;

public final class ArrowTypesInstantiator extends UserObjectInstantiator {

  private static final Map<Class<?>, Object> PREPARED_OBJECTS = new HashMap<>();

  static {
    PREPARED_OBJECTS.put(Validated.class, new Valid<>(new Object()));
    PREPARED_OBJECTS.put(Option.class, None.INSTANCE);
    PREPARED_OBJECTS.put(Either.class, new Left<>(new Object()));
  }

  public ArrowTypesInstantiator(
      final Class<?> clazz,
      final MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
    super(clazz, constructorParameters);
  }

  @Override
  public Optional<Object> tryToInstantiate() {
    return PREPARED_OBJECTS.entrySet().stream()
        .filter(entry -> entry.getKey().isAssignableFrom(clazz))
        .findFirst()
        .map(Entry::getValue);
  }

  @Override
  public boolean canInstantiate() {
    return PREPARED_OBJECTS.keySet().stream().anyMatch(k -> k.isAssignableFrom(clazz));
  }
}
