import java.util.Date;

public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // Default constructor
    public Loan() {
        this(2.5, 1, 1000);
    }

    // Parameterized constructor
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }

    // Getters
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    // Setters
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Method to calculate monthly payment
    public double getMonthlyPayment() {
        double monthlyInterestRate = (annualInterestRate / 100) / 12;
        int totalMonths = numberOfYears * 12;
        return (loanAmount * monthlyInterestRate) / 
               (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));
    }

    // Method to calculate total payment
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }

    public static void main(String[] args) {
        // Create a Loan object with sample values
        Loan loan = new Loan(2.5 , 2, 2000); // 5.5% interest, 10 years, 2,000,000 loan amount

        // Print Loan Details
        System.out.println("Loan Details:");
        System.out.println("Annual Interest Rate: " + loan.getAnnualInterestRate() + "%");
        System.out.println("Number of Years: " + loan.getNumberOfYears());
        System.out.println("Loan Amount: GHS" + loan.getLoanAmount());
        System.out.println("Loan Date: " + loan.getLoanDate());

        // Calculate and print payments
        System.out.printf("Monthly Payment: GHS%.2f%n", loan.getMonthlyPayment());
        System.out.printf("Total Payment: GHS%.2f%n", loan.getTotalPayment());
    }
}

