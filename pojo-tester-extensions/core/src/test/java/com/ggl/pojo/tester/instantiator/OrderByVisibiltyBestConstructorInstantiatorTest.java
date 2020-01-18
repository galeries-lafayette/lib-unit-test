package com.ggl.pojo.tester.instantiator;

import lombok.Value;
import lombok.val;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.pojo.tester.api.ConstructorParameters;

import static com.ggl.pojo.tester.config.PojoConfig.initContext;
import static org.assertj.core.api.Assertions.assertThat;

class OrderByVisibiltyBestConstructorInstantiatorTest {

  @BeforeAll
  private static void init() {
    initContext("com.ggl");
  }

  @Test
  void can_instantiate() {
    // Given
    val instantiator = instance(Pojo.class);

    // Action
    val canInstantiate = instantiator.canInstantiate();

    // Asserts
    assertThat(canInstantiate).isTrue();
  }

  @Test
  void cannot_instantiate_primitive_class() {
    // Given
    val instantiator = instance(int.class);

    // Action
    val canInstantiate = instantiator.canInstantiate();

    // Asserts
    assertThat(canInstantiate).isFalse();
  }

  @Test
  void cannot_instantiate_enum_class() {
    // Given
    val instantiator = instance(MyEnum.class);

    // Action
    val canInstantiate = instantiator.canInstantiate();

    // Asserts
    assertThat(canInstantiate).isFalse();
  }

  @Test
  void should_create_object_using_best_constructor() {
    // Given
    val instantiator = instance(Pojo.class);

    // Action
    val object = instantiator.createFindingBestConstructor();

    // Asserts
    assertThat(object).isEqualTo(new Pojo("www.pojo.pl", "www.pojo.pl"));
  }

  private OrderByVisibiltyBestConstructorInstantiator instance(Class<?> clazz) {
    final MultiValuedMap<Class<?>, ConstructorParameters> constructorParameters =
        new ArrayListValuedHashMap<>();
    return new OrderByVisibiltyBestConstructorInstantiator(clazz, constructorParameters);
  }

  private enum MyEnum {}

  @Value
  private static class Pojo {
    String s1;
    String s2;
    String s3;

    public Pojo(String s1, String s2) {
      this.s1 = s1;
      this.s2 = s2;
      this.s3 = null;
    }

    public Pojo(String s1) {
      this.s1 = s1;
      this.s2 = null;
      this.s3 = null;
    }

    private Pojo() {
      this.s1 = null;
      this.s2 = null;
      this.s3 = null;
    }

    private Pojo(String s1, String s2, String s3) {
      this.s1 = s1;
      this.s2 = s2;
      this.s3 = s3;
    }
  }
}
