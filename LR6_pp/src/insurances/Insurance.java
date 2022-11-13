package insurances;

public interface Insurance {
    int GetPrice();
    double GetRisk();
    void calculate_risk();
    void calculate_price();
    void calculate_payment();
}
