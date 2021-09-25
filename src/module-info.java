module Parkordnung {

    requires javafx.controls;
    requires javafx.fxml; //includes javafx.base

    opens jfx to javafx.graphics, javafx.fxml;
}