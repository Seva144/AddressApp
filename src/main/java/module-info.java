module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.makery to javafx.fxml;
    exports ch.makery;
}