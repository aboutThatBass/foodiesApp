module edu.utsa.cs3443.calorieapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.graphics;

    // FXML needs reflection access to controllers
    opens edu.utsa.cs3443.calorieapp to javafx.fxml;
    opens edu.utsa.cs3443.calorieapp.controller to javafx.fxml;

    // Export packages your app uses
    exports edu.utsa.cs3443.calorieapp;
    exports edu.utsa.cs3443.calorieapp.controller;
    exports edu.utsa.cs3443.calorieapp.model;
}
