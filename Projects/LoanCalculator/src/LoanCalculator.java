import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Creating Labels and TextFields
        Label lblAnnualInterestRate = new Label("Annual Interest Rate:");
        TextField txtAnnualInterestRate = new TextField();
        
        Label lblNumberOfYears = new Label("Number of Years:");
        TextField txtNumberOfYears = new TextField();
        
        Label lblLoanAmount = new Label("Loan Amount:");
        TextField txtLoanAmount = new TextField();

        Label lblMonthlyPayment = new Label("Monthly Payment:");
        TextField txtMonthlyPayment = new TextField();
        txtMonthlyPayment.setEditable(false);

        Label lblTotalPayment = new Label("Total Payment:");
        TextField txtTotalPayment = new TextField();
        txtTotalPayment.setEditable(false);

        Button btnCalculate = new Button("  Calculate  ");

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        gridPane.add(lblAnnualInterestRate, 0, 0);
        gridPane.add(txtAnnualInterestRate, 1, 0);
        gridPane.add(lblNumberOfYears, 0, 1);
        gridPane.add(txtNumberOfYears, 1, 1);
        gridPane.add(lblLoanAmount, 0, 2);
        gridPane.add(txtLoanAmount, 1, 2);              
        gridPane.add(lblMonthlyPayment, 0, 3);
        gridPane.add(txtMonthlyPayment, 1, 3);
        gridPane.add(lblTotalPayment, 0, 4);
        gridPane.add(txtTotalPayment, 1, 4);
        gridPane.add(btnCalculate, 1, 5);

        // Event Handling
        btnCalculate.setOnAction(e -> {
            try {
                double annualInterestRate = Double.parseDouble(txtAnnualInterestRate.getText());
                int numberOfYears = Integer.parseInt(txtNumberOfYears.getText());
                double loanAmount = Double.parseDouble(txtLoanAmount.getText());
 
                Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
                
                txtMonthlyPayment.setText(String.format("GHS%.2f", loan.getMonthlyPayment()));
                txtTotalPayment.setText(String.format("GHS%.2f", loan.getTotalPayment()));

            } catch (NumberFormatException ex) {
                txtMonthlyPayment.setText("Invalid input");
                txtTotalPayment.setText("Invalid input");
            }
        });

        // Scene and Stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

