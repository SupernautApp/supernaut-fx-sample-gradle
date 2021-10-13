/**
 * Java Module definitions for HelloFX, the minimal SupernautFX Gradle Sample
 */
module hellofx {
    requires javafx.graphics;
    requires javafx.controls;

    requires app.supernaut.fx;

    requires static jakarta.inject;

    requires static io.micronaut.inject;  // Needed for Micronaut-generated classes
    requires jakarta.annotation;

    requires org.slf4j;

    opens app.supernaut.fx.sample.gradle to javafx.graphics, java.base;
    exports app.supernaut.fx.sample.gradle;

    uses app.supernaut.fx.FxLauncher;
}
