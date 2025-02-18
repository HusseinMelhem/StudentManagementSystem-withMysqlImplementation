module StudentManagementSystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql; // Needed for MySQL Connection

    opens student.management to javafx.fxml;
    exports student.management;
}
