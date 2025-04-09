module com.example.tarea2_6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.tarea2_6 to javafx.fxml;
    exports com.example.tarea2_6;
    exports com.example.tarea2_6.Controladores;
    opens com.example.tarea2_6.Controladores to javafx.fxml;
}