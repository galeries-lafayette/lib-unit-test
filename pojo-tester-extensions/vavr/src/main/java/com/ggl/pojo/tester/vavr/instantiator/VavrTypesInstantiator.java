package com.ggl.pojo.tester.vavr.instantiator;

import io.vavr.API;
import io.vavr.Tuple2;
import io.vavr.collection.Array;
import io.vavr.collection.IndexedSeq;
import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.collection.Queue;
import io.vavr.collection.Seq;
import io.vavr.collection.Set;
import io.vavr.collection.Stream;
import io.vavr.collection.Vector;
import io.vavr.collection.*;
import io.vavr.concurrent.Future;
import io.vavr.control.Either;
import io.vavr.control.Option;
import io.vavr.control.Try;
import io.vavr.control.Validation;
import org.apache.commons.collections4.MultiValuedMap;
import pl.pojo.tester.api.ConstructorParameters;
import pl.pojo.tester.internal.instantiator.UserObjectInstantiator;

import java.util.Optional;

import static io.vavr.API.*;
import static io.vavr.control.Either.left;
import static io.vavr.control.Option.none;
import static java.util.function.Function.identity;

public final class VavrTypesInstantiator extends UserObjectInstantiator {

  private static final Map<Class<?>, Object> PREPARED_OBJECTS =
      API.<Class<?>, Object>Map()
          .put(Stream.class, Stream())
          .put(Vector.class, Vector())
          .put(List.class, List())
          .put(Set.class, Set())
          .put(Seq.class, Seq())
          .put(HashMap.class, Map())
          .put(LinkedHashMap.class, LinkedMap())
          .put(Map.class, Map())
          .put(Array.class, Array())
          .put(Validation.class, Valid(new Object()))
          .put(Option.class, none())
          .put(Queue.class, Queue())
          .put(IndexedSeq.class, IndexedSeq())
          .put(Try.class, Try(Object::new))
          .put(Either.class, left(new Object()))
          .put(Future.class, Future(identity()));

  public VavrTypesInstantiator(
      final Class<?> clazz,
      final MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters) {
    super(clazz, constructorParameters);
  }

  @Override
  public Optional<Object> tryToInstantiate() {
    return PREPARED_OBJECTS.find(this::clazzCanBeAssigned).map(Tuple2::_2).toJavaOptional();
  }

  @Override
  public boolean canInstantiate() {
    return PREPARED_OBJECTS.keySet().exists(k -> k.isAssignableFrom(clazz));
  }

  private boolean clazzCanBeAssigned(final Tuple2<Class<?>, Object> entry) {
    return entry._1.isAssignableFrom(clazz);
  }
}
