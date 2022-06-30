package com.reine.filebed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Objects;

@SpringBootApplication
public class LocalFilebedApplication extends Application {
    public static ConfigurableApplicationContext APPLICATION_CONTEXT;

    private static String[] args;

    public static void main(String[] args) {
        LocalFilebedApplication.args = args;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml/main.fxml")));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("上传图片");
        Image image = new Image("images/logo.png");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        super.init();
        APPLICATION_CONTEXT = SpringApplication.run(LocalFilebedApplication.class, args);
    }
}
