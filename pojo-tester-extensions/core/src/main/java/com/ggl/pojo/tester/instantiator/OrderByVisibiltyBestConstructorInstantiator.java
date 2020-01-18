package com.ggl.pojo.tester.instantiator;

import lombok.val;
import org.apache.commons.collections4.MultiValuedMap;
import pl.pojo.tester.api.ConstructorParameters;
import pl.pojo.tester.internal.instantiator.BestConstructorInstantiator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static com.ggl.pojo.tester.config.PojoConfig.basePackage;
import static java.lang.reflect.Modifier.*;
import static java.util.Arrays.stream;
import static java.util.Comparator.comparingInt;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

public final class OrderByVisibiltyBestConstructorInstantiator extends BestConstructorInstantiator {

  public OrderByVisibiltyBestConstructorInstantiator(
      final Class<?> clazz,
      final MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
    super(clazz, constructorParameters);
  }

  @Override
  public boolean canInstantiate() {
    return !clazz.isPrimitive()
        && !clazz.isEnum()
        && nonNull(basePackage)
        && clazz.getPackage().getName().startsWith(basePackage);
  }

  @Override
  protected Object createFindingBestConstructor() {
    val constructors = clazz.getDeclaredConstructors();

    val publicConstructors = filterByVisibility(constructors, Modifier::isPublic);
    val protectedConstructors = filterByVisibility(constructors, Modifier::isProtected);
    val privateConstructors = filterByVisibility(constructors, Modifier::isPrivate);
    val packageConstructors =
        filterByVisibility(
            constructors, mod -> !isPublic(mod) && !isProtected(mod) && !isPrivate(mod));

    return Stream.of(
            publicConstructors, protectedConstructors, packageConstructors, privateConstructors)
        .map(this::createFindingBestConstructor)
        .flatMap(Optional::stream)
        .findFirst()
        .orElseThrow(this::createObjectInstantiationException);
  }

  private Optional<Object> createFindingBestConstructor(final List<Constructor<?>> constructors) {
    return constructors.stream()
        .map(this::createObjectFromConstructor)
        .filter(Objects::nonNull)
        .findAny();
  }

  private List<Constructor<?>> filterByVisibility(
      final Constructor<?>[] constructors, Predicate<Integer> hasVisibility) {
    Comparator<Constructor<?>> comparator = comparingInt(Constructor::getParameterCount);
    return stream(constructors)
        .filter(c -> hasVisibility.test(c.getModifiers()))
        .sorted(comparator.reversed())
        .collect(toList());
  }
}
