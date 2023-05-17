module com.example.six_qui_prend {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.media;

    opens com.example.six_qui_prend to javafx.fxml;
    exports com.example.six_qui_prend;
}