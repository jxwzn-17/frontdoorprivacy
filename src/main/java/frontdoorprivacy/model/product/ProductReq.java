package frontdoorprivacy.model.product;


public class ProductReq {

    //이미지 파일을 제외한 나머지 값들을 받아오는 객체
    private int P_ENID;
    private String P_ProductName;
    private int P_Price;
    private String P_Category;
    private String P_Detail;

    public int getP_ENID() {
        return P_ENID;
    }

    public void setP_ENID(int p_ENID) {
        P_ENID = p_ENID;
    }

    public String getP_ProductName() {
        return P_ProductName;
    }

    public void setP_ProductName(String p_ProductName) {
        P_ProductName = p_ProductName;
    }

    public int getP_Price() {
        return P_Price;
    }

    public void setP_Price(int p_Price) {
        P_Price = p_Price;
    }

    public String getP_Category() {
        return P_Category;
    }

    public void setP_Category(String p_Category) {
        P_Category = p_Category;
    }

    public String getP_Detail() {
        return P_Detail;
    }

    public void setP_Detail(String p_Detail) {
        P_Detail = p_Detail;
    }
}
