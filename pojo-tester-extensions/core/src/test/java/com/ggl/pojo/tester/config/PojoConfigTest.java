package com.ggl.pojo.tester.config;

import lombok.NoArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.Test;

import static com.ggl.pojo.tester.config.PojoConfig.basePackage;
import static com.ggl.pojo.tester.config.PojoConfig.extensionConfigs;
import static com.ggl.pojo.tester.config.PojoConfig.initContext;
import static com.ggl.pojo.tester.config.PojoConfigTest.FakeExtensionConfig.initContext;
import static lombok.AccessLevel.PRIVATE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class PojoConfigTest {

  static class FakeExtensionConfig implements ExtensionConfig {

    static boolean initContext = false;

    @Override
    public void initContext() {
      initContext = true;
    }
  }

  @NoArgsConstructor(access = PRIVATE)
  static class FakeExtensionConfigWithPrivateConstructor implements ExtensionConfig {
    @Override
    public void initContext() {}
  }

  @Test
  void should_init_context() {
    // Given
    val extensionConfigClass = FakeExtensionConfig.class;
    val packageName = "com.ggl";

    // When
    initContext(packageName, extensionConfigClass);

    // Then
    assertThat(basePackage).isEqualTo(packageName);
    assertThat(extensionConfigs).contains(extensionConfigClass);
    assertThat(initContext).isTrue();
  }

  @Test
  void should_fail_to_init_context() {
    // Given
    val extensionConfigClass = FakeExtensionConfigWithPrivateConstructor.class;
    val packageName = "com.ggl";

    // When
    val throwable = catchThrowable(() -> initContext(packageName, extensionConfigClass));

    // Then
    assertThat(throwable).isInstanceOf(IllegalAccessException.class);
  }
}
