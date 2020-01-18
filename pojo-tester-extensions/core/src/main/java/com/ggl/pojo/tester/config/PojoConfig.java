package com.ggl.pojo.tester.config;

import com.ggl.pojo.tester.instantiator.OrderByVisibiltyBestConstructorInstantiator;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import pl.pojo.tester.internal.instantiator.Instantiator;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.function.Predicate.not;

@UtilityClass
public class PojoConfig {

  public static final Set<Class<? extends ExtensionConfig>> extensionConfigs = new HashSet<>();
  public static String basePackage;

  @SafeVarargs
  public static void initContext(
      final String basePackage, final Class<? extends ExtensionConfig>... configs) {
    PojoConfig.basePackage = basePackage;

    stream(configs)
        .filter(not(extensionConfigs::contains))
        .peek(extensionConfigs::add)
        .map(PojoConfig::unsafeNewInstance)
        .forEach(ExtensionConfig::initContext);

    Instantiator.INSTANCE.attach(OrderByVisibiltyBestConstructorInstantiator.class);
  }

  @SneakyThrows
  private static <T> T unsafeNewInstance(final Class<T> clazz) {
    return clazz.getDeclaredConstructor().newInstance();
  }
}
