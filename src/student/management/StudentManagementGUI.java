package student.management;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.List;

public class StudentManagementGUI extends Application {

    private ListView<String> studentListView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("📚 Student Management System");
        
        // UI Elements
        Label titleLabel = new Label("📚 Student Management System");

        TextField searchField = new TextField();
        searchField.setPromptText("🔍 Search by ID or Name");

        Button searchButton = new Button("🔍 Search");
        Button viewButton = new Button("📋 View All Students");

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Student Name");

        TextField ageField = new TextField();
        ageField.setPromptText("Age");

        TextField gradeField = new TextField();
        gradeField.setPromptText("Grade");

        Button addButton = new Button("➕ Add Student");
        Button deleteButton = new Button("🗑 Delete Student");

        // 📌 Add Student
        addButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                String grade = gradeField.getText();

                if (StudentDatabase.addStudent(id, name, age, grade)) {
                    showAlert("Success", "Student added successfully!");
                    loadStudents(null);
                } else {
                    showAlert("Error", "Failed to add student.");
                }

                idField.clear(); nameField.clear(); ageField.clear(); gradeField.clear();
            } catch (Exception ex) {
                showAlert("Invalid Input", "Enter valid student details.");
            }
        });

        // 📌 Search Student
        searchButton.setOnAction(e -> loadStudents(searchField.getText().trim()));

        // 📌 View All Students
        viewButton.setOnAction(e -> loadStudents(null));

        // 📌 Delete Student
        deleteButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(idField.getText());
                if (StudentDatabase.deleteStudent(id)) {
                    showAlert("Success", "Student deleted.");
                    loadStudents(null);
                } else {
                    showAlert("Error", "Student not found.");
                }
                idField.clear();
            } catch (Exception ex) {
                showAlert("Invalid Input", "Enter a valid student ID.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(titleLabel, searchField, searchButton, idField, nameField, ageField, gradeField, addButton, viewButton, deleteButton, studentListView);

        Scene scene = new Scene(layout, 400, 500);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
        
        loadStudents(null);
    }

    private void loadStudents(String searchQuery) {
        studentListView.getItems().clear();
        List<Student> students = searchQuery == null || searchQuery.isEmpty() ?
                StudentDatabase.getStudents() :
                searchQuery.matches("\\d+") ? 
                List.of(StudentDatabase.searchStudentByID(Integer.parseInt(searchQuery))) :
                StudentDatabase.searchStudentByName(searchQuery);

        for (Student student : students) {
            studentListView.getItems().add(student.toString());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
