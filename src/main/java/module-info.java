module com.example.btlquanganh {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.btlquanganh to javafx.fxml;
    exports com.example.btlquanganh;
}