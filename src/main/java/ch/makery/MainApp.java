package ch.makery;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    /*Окно с крестиком свернуть и т д*/
    private BorderPane boarderPane;



    /*На вход start подается stage*/
    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        initRootLayout();
        showPersonOverview();
    }

    public void initRootLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("root-layout.fxml"));
        boarderPane = (BorderPane) loader.load();
        /*Scene принимает объект расположения элементов ArchorPane, BoarderPane*/
        Scene scene = new Scene(boarderPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AddressApp");
        primaryStage.show();
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     */
    public void showPersonOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("person-overview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            // Помещаем сведения об адресатах в центр корневого макета.
            boarderPane.setCenter(personOverview);
        } catch (IOException e) {
            e.printStackTrace();
        }
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