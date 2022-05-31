package frontdoorprivacy.model.user;


import lombok.Data;

@Data
public class Basket {

    private int B_BSID;
    private int B_PDID; // 상품 id, 수정 필요한지 확인
    private int B_USID; // 사용자 id, 수정 필요한지 확인
    private String UserYN;

    public int getB_BSID() {
        return B_BSID;
    }

    public void setB_BSID(int b_BSID) {
        B_BSID = b_BSID;
    }

    public int getB_PDID() {
        return B_PDID;
    }

    public void setB_PDID(int b_PDID) {
        B_PDID = b_PDID;
    }

    public int getB_USID() {
        return B_USID;
    }

    public void setB_USID(int b_USID) {
        B_USID = b_USID;
    }

    public String getUserYN() {
        return UserYN;
    }

    public void setUserYN(String userYN) {
        UserYN = userYN;
    }
}
