package app.supernaut.fx.sample.gradle;

import app.supernaut.fx.FxForegroundApp;
import app.supernaut.fx.FxLauncher;
import app.supernaut.services.BrowserService;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.inject.Singleton;
import java.net.URI;

@Singleton
public class HelloFX implements FxForegroundApp.FxApplicationCompat  {
    private static final URI githubRepoUri = URI.create("https://github.com/SupernautApp/SupernautFX");
    private final BrowserService browserService;

    public HelloFX(BrowserService browserService) {
        this.browserService = browserService;
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(buildScene());
        stage.show();
    }

    private Scene buildScene() {
        var javaVersion = System.getProperty("java.version");
        var javafxVersion = System.getProperty("javafx.version");
        var label       = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var hyperlink   = new Hyperlink("Powered by Supernaut.FX");
        var vbox        = new VBox(label, hyperlink);
        vbox.setAlignment(Pos.CENTER);
        hyperlink.setOnAction(e -> browserService.showDocument(githubRepoUri));
        return new Scene(vbox, 350, 100);
    }

    public static void main(String[] args) {
        FxLauncher.byName("micronaut").launch(args, HelloFX.class);
    }
}
