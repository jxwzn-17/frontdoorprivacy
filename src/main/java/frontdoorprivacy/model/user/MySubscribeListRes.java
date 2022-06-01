package frontdoorprivacy.model.user;

public class MySubscribeListRes {

    //넘겨줄값은 파일을 꺼내오는데 필요한 이미지파일명과 이미지파일경로, 구독주기/가격, 설명과 상품이름, 상품PDID
    //총 7개임
    private int P_PDID;
    private String P_ProductName;
    private String P_ImageFilePath;
    private String P_ImageFileName;
    private int P_Price;
    private String P_SubscribeCycle;
    private String P_Detail;

    public int getP_PDID() {
        return P_PDID;
    }

    public void setP_PDID(int p_PDID) {
        P_PDID = p_PDID;
    }

    public String getP_ProductName() {
        return P_ProductName;
    }

    public void setP_ProductName(String p_ProductName) {
        P_ProductName = p_ProductName;
    }

    public String getP_ImageFilePath() {
        return P_ImageFilePath;
    }

    public void setP_ImageFilePath(String p_ImageFilePath) {
        P_ImageFilePath = p_ImageFilePath;
    }

    public String getP_ImageFileName() {
        return P_ImageFileName;
    }

    public void setP_ImageFileName(String p_ImageFileName) {
        P_ImageFileName = p_ImageFileName;
    }

    public int getP_Price() {
        return P_Price;
    }

    public void setP_Price(int p_Price) {
        P_Price = p_Price;
    }

    public String getP_SubscribeCycle() {
        return P_SubscribeCycle;
    }

    public void setP_SubscribeCycle(String p_SubscribeCycle) {
        P_SubscribeCycle = p_SubscribeCycle;
    }

    public String getP_Detail() {
        return P_Detail;
    }

    public void setP_Detail(String p_Detail) {
        P_Detail = p_Detail;
    }

    public MySubscribeListRes(){

    }
}
