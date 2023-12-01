public class Mortgage {
    public double RATE = 0.3005;

    public double creditRiskFee(int age, int capital) {
        double FEE = 0.0;

        if (age > 55) {
            FEE = (age - 55) * 0.01 * capital * (RATE / 12);
        };

        return FEE;
    };

    public double calculateInterest(int capital, Person person) {
        return (capital + creditRiskFee(person.getAge(), capital)) * (0.9 + RATE);
    };

    public void restructuringLoan(int newMonthNumber, Person person, double... remainingInstallments) {
        double sum = 0;
        for (double i : remainingInstallments)
            sum += i;

        double interest = calculateInterest((int)sum, person);

        System.out.println("New Holiday Loan Repayment will be: " + interest);
        System.out.println("Your new payments will be: " + interest / newMonthNumber + " x " + newMonthNumber);
    };
}
