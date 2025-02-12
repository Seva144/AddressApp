package ch.makery;

import ch.makery.model.Person;
import ch.makery.view.PersonOverviewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    /**
     * Данные, в виде наблюдаемого списка адресатов.
     */
    private ObservableList<Person> personData = FXCollections.observableArrayList();

    public MainApp() {
        personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
    }

    /**
     * Возвращает данные в виде наблюдаемого списка адресатов.
     * @return
     */
    public ObservableList<Person> getPersonData() {
        return personData;
    }

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

            // Инициализируем контроллер и даем данные
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);
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