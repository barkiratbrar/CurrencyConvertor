module com.example.currencyconvertor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.currencyconvertor to javafx.fxml;
    exports com.example.currencyconvertor;
}