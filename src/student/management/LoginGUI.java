package student.management;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🔑 Login System");

        // 📌 UI Elements
        Label titleLabel = new Label("🔑 Login to Student Management");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("🚀 Login");

        // 📌 Login Action
        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (LoginDatabase.validateLogin(username, password)) {
                showAlert("Success", "Login Successful!");
                primaryStage.close();
                StudentManagementGUI studentGUI = new StudentManagementGUI();
                Stage studentStage = new Stage();
                studentGUI.start(studentStage);
            } else {
                showAlert("Error", "Invalid Username or Password.");
            }
        });

        // 📌 Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, usernameField, passwordField, loginButton);

        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 📌 Show Alert Box
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
