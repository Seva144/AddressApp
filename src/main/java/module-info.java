module ch.makery {
    requires java.prefs;
    requires javafx.fxml;
    requires java.xml.bind;
    requires javafx.controls;

    opens ch.makery to javafx.fxml;
    opens ch.makery.model to java.xml.bind;
    exports ch.makery;
    exports ch.makery.view;
    opens ch.makery.view to javafx.fxml;
    exports ch.makery.model;
    exports ch.makery.util;

}