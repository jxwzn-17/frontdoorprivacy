package frontdoorprivacy.model.product;


public class ProductReq {

    //이미지 파일을 제외한 나머지 값들을 받아오는 객체
    private int p_ENID;
    private String p_ProductName;
    private String p_DetailCategory;
    private String p_SaleYN;
    private int p_Price;
    private String p_Category;
    private String p_Detail;

    private int p_Sale;




    public int getP_Sale() {
        return p_Sale;
    }

    public void setP_Sale(int p_Sale) {
        this.p_Sale = p_Sale;
    }

    public String getP_DetailCategory() {
        return p_DetailCategory;
    }

    public void setP_DetailCategory(String p_DetailCategory) {
        this.p_DetailCategory = p_DetailCategory;
    }

    public String getP_SaleYN() {
        return p_SaleYN;
    }

    public void setP_SaleYN(String p_SaleYN) {
        this.p_SaleYN = p_SaleYN;
    }



    public ProductReq() {
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

    public int getP_Price() {
        return p_Price;
    }

    public void setP_Price(int p_Price) {
        this.p_Price = p_Price;
    }

    public String getP_Category() {
        return p_Category;
    }

    public void setP_Category(String p_Category) {
        this.p_Category = p_Category;
    }

    public String getP_Detail() {
        return p_Detail;
    }

    public void setP_Detail(String p_Detail) {
        this.p_Detail = p_Detail;
    }
}
