module ch.makery {
    requires java.xml.bind; // Require JAXB
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires junit;

    opens ch.makery to javafx.fxml;
    exports ch.makery;
    exports ch.makery.view;
    opens ch.makery.view to javafx.fxml;
    exports ch.makery.model;
    exports ch.makery.util;
    exports test;
    opens ch.makery.model to java.xml.bind;
}