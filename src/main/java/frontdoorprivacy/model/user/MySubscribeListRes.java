package frontdoorprivacy.model.user;

public class MySubscribeListRes {

    //넘겨줄값은 파일을 꺼내오는데 필요한 이미지파일명과 이미지파일경로, 구독주기/가격, 설명과 상품이름, 상품PDID
    //총 8개임
    private int P_POID;
    private String P_ProductName;
    private String P_ImageFilePath;
    private String P_ImageFileName;
    private int P_Price;

    private String P_Optionname;
    private String P_SSID;

    private String P_LastDateTime;

    public String getP_LastDateTime() {
        return P_LastDateTime;
    }

    public void setP_LastDateTime(String p_LastDateTime) {
        P_LastDateTime = p_LastDateTime;
    }

    public int getP_POID() {
        return P_POID;
    }

    public void setP_POID(int p_POID) {
        P_POID = p_POID;
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


    public String getP_Optionname() {
        return P_Optionname;
    }

    public void setP_Optionname(String p_Optionname) {
        P_Optionname = p_Optionname;
    }

    public String getP_SSID() {
        return P_SSID;
    }

    public void setP_SSID(String p_SSID) {
        P_SSID = p_SSID;
    }

    public MySubscribeListRes(){

    }
}
