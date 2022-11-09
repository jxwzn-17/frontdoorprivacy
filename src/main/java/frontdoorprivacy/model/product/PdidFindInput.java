package frontdoorprivacy.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PdidFindInput {
    int p_ENID;
    String p_ProductName;
    String p_DetailCate;

    public PdidFindInput() {
    }

    public int getP_ENID() {
        return p_ENID;
    }

    public void setP_ENID(int p_ENID) {
        this.p_ENID = p_ENID;
    }

    public String getP_ProductName() {
        return p_ProductName;
    }

    public void setP_ProductName(String p_ProductName) {
        this.p_ProductName = p_ProductName;
    }

    public String getP_DetailCate() {
        return p_DetailCate;
    }

    public void setP_DetailCate(String p_DetailCate) {
        this.p_DetailCate = p_DetailCate;
    }
}
