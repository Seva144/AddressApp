package ch.makery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane boarderPane;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        initRootLayout();
    }

    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("RootLayout.fxml"));
        boarderPane = (BorderPane) loader.load();
        /*Scene принимает объект расположения элементов ArchorPane, BoarderPane*/
        Scene scene = new Scene(boarderPane, 320, 240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AddressApp");
        primaryStage.show();
    }


    /**
     * Возвращает главную сцену.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch();
    }
}