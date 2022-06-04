package frontdoorprivacy.model.user;

public class SubscribeEnrollReq {

    private int p_USID;
    private int p_PDID;
    private String p_SubscribeCycle;

    public int getP_USID() {
        return p_USID;
    }

    public void setP_USID(int p_USID) {
        this.p_USID = p_USID;
    }

    public int getP_PDID() {
        return p_PDID;
    }

    public void setP_PDID(int p_PDID) {
        this.p_PDID = p_PDID;
    }

    public String getP_SubscribeCycle() {
        return p_SubscribeCycle;
    }

    public void setP_SubscribeCycle(String p_SubscribeCycle) {
        this.p_SubscribeCycle = p_SubscribeCycle;
    }
}
