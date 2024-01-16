package com.example.currencyconvertor;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;

public class currencyConvertorController {
    @FXML private TextField sourceAmount;
    @FXML private TextField targetAmount;
    @FXML private ComboBox<String> sourceCurrency;
    @FXML private ComboBox<String> targetCurrency;
    @FXML private Button convertButton;

    @FXML
    private void initialize() {
        // Add currencies to both ComboBoxes
        addCurrencies(sourceCurrency);
        addCurrencies(targetCurrency);

        // Set up the convert button action
        convertButton.setOnAction(event -> convertCurrency());
    }

    private void addCurrencies(ComboBox<String> comboBox) {
        comboBox.getItems().addAll("USD", "EUR", "GBP", "INR", "CAD");
    }

    @FXML
    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(sourceAmount.getText());
            double rateToUSD = getRateToUSD(sourceCurrency.getValue());
            double rateFromUSD = getRateFromUSD(targetCurrency.getValue());
            double convertedAmount = amount * rateToUSD * rateFromUSD;
            targetAmount.setText(String.format("%.2f", convertedAmount));
        } catch (NumberFormatException e) {
            targetAmount.setText("Invalid input");
        }
    }

    private double getRateToUSD(String currency) {
        switch (currency) {
            case "EUR": return 1.10;
            case "GBP": return 1.27;
            case "INR": return 0.012;
            case "CAD": return 0.75;
            default: return 1.0; // USD or unknown currency
        }
    }

    private double getRateFromUSD(String currency) {
        switch (currency) {
            case "EUR": return 0.91;
            case "GBP": return 0.78;
            case "INR": return 82.87;
            case "CAD": return 1.34;
            default: return 1.0; // USD or unknown currency
        }
    }
}
