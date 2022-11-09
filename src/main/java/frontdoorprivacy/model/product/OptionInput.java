package frontdoorprivacy.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OptionInput {
    int p_PDID;
    String p_Optionname;
    int p_Price;
    int p_Sale;
    String p_SaleYN;

    public OptionInput() {
    }

    public int getP_PDID() {
        return p_PDID;
    }

    public void setP_PDID(int p_PDID) {
        this.p_PDID = p_PDID;
    }

    public String getP_Optionname() {
        return p_Optionname;
    }

    public void setP_Optionname(String p_Optionname) {
        this.p_Optionname = p_Optionname;
    }

    public int getP_Price() {
        return p_Price;
    }

    public void setP_Price(int p_Price) {
        this.p_Price = p_Price;
    }

    public int getP_Sale() {
        return p_Sale;
    }

    public void setP_Sale(int p_Sale) {
        this.p_Sale = p_Sale;
    }

    public String getP_SaleYN() {
        return p_SaleYN;
    }

    public void setP_SaleYN(String p_SaleYN) {
        this.p_SaleYN = p_SaleYN;
    }
}
