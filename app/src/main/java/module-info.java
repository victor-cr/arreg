module arreg.app.main {
    requires javafx.controls;
    requires javafx.graphics;

    exports com.codegans.arreg to javafx.graphics;

    opens com.codegans.arreg.ui.model to javafx.base;
}