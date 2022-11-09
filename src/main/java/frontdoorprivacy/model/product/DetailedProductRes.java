package frontdoorprivacy.model.product;

import java.util.List;

public class DetailedProductRes {

    //총 12개의 값을 넘겨줌
    private int p_PDID;
    private int p_ENID;
    private String p_ProductName;
    private int p_Price;
    private int p_Sale;
    private String p_Category;
    private String p_Detail;
//    private String p_ImageFilePath;
//    private String p_ImageFileName;
//    private String p_DetailFileName;
    private String p_EnterpriseName;
    private long p_PhoneNumber;

    private int p_Count;

    private List<OptionInput> p_Options;

    public List<OptionInput> getP_Options() {
        return p_Options;
    }

    public void setP_Options(List<OptionInput> p_Options) {
        this.p_Options = p_Options;
    }

    public int getP_Count() {
        return p_Count;
    }

    public void setP_Count(int p_Count) {
        this.p_Count = p_Count;
    }

    public int getP_PDID() {
        return p_PDID;
    }

    public void setP_PDID(int p_PDID) {
        this.p_PDID = p_PDID;
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

    public int getP_Sale() {
        return p_Sale;
    }

    public void setP_Sale(int p_Sale) {
        this.p_Sale = p_Sale;
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

//    public String getP_ImageFilePath() {
//        return p_ImageFilePath;
//    }
//
//    public void setP_ImageFilePath(String p_ImageFilePath) {
//        this.p_ImageFilePath = p_ImageFilePath;
//    }
//
//    public String getP_ImageFileName() {
//        return p_ImageFileName;
//    }
//
//    public void setP_ImageFileName(String p_ImageFileName) {
//        this.p_ImageFileName = p_ImageFileName;
//    }
//
//    public String getP_DetailFileName() {
//        return p_DetailFileName;
//    }
//
//    public void setP_DetailFileName(String p_DetailFileName) {
//        this.p_DetailFileName = p_DetailFileName;
//    }

    public String getP_EnterpriseName() {
        return p_EnterpriseName;
    }

    public void setP_EnterpriseName(String p_EnterpriseName) {
        this.p_EnterpriseName = p_EnterpriseName;
    }

    public long getP_PhoneNumber() {
        return p_PhoneNumber;
    }

    public void setP_PhoneNumber(long p_PhoneNumber) {
        this.p_PhoneNumber = p_PhoneNumber;
    }
}
