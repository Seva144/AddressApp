module ch.makery {
    requires java.xml.bind; // Require JAXB
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;

    opens ch.makery to javafx.fxml;
    opens ch.makery.model to java.xml.bind;
    exports ch.makery;
    exports ch.makery.view;
    opens ch.makery.view to javafx.fxml;
    exports ch.makery.model;
    exports ch.makery.util;

}