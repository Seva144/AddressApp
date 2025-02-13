module ch.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires java.xml.bind;


    opens ch.makery to javafx.fxml;
    exports ch.makery;
    exports ch.makery.view;
    opens ch.makery.view to javafx.fxml;
}