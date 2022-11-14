package frontdoorprivacy.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Myproductoptionoutput {
    int POID;
    String Optionname;
    int Price;
    int Sale;
    String SaleYN;

    public Myproductoptionoutput() {
    }

    public int getPOID() {
        return POID;
    }

    public void setPOID(int POID) {
        this.POID = POID;
    }

    public String getOptionname() {
        return Optionname;
    }

    public void setOptionname(String optionname) {
        Optionname = optionname;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public int getSale() {
        return Sale;
    }

    public void setSale(int sale) {
        Sale = sale;
    }

    public String getSaleYN() {
        return SaleYN;
    }

    public void setSaleYN(String saleYN) {
        SaleYN = saleYN;
    }
}
