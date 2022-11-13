package insurances;

public class HouseInsurance implements Insurance{
    double risk;
    int price, payment;
    int area, house_price;
    public HouseInsurance(int area, int house_price){
        this.area = area;
        this.house_price = house_price;
        calculate_risk();
        calculate_price();
        calculate_payment();
    }

    @Override
    public int GetPrice(){
        return price;
    }

    @Override
    public double GetRisk() {
        return risk;
    }

    public int getArea() {
        return area;
    }

    public int getHouse_price(){
        return house_price;
    }
    @Override
    public void calculate_risk() {
        risk = (double) area*100/house_price;
    }
    @Override
    public void calculate_price() {
        price = (int)(double)house_price/100000*area;
    }

    @Override
    public void calculate_payment() {
        payment = (int)(house_price*(1-risk));
    }

    @Override
    public String toString() {
        return "HouseInsurance{" +
                "risk=" + risk +
                ", price=" + price +
                ", payment=" + payment +
                ", area=" + area +
                ", house_price=" + house_price +
                '}';
    }
}
