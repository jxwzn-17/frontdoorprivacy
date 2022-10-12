package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentDTO {
    private String p_imp_uid;
    private int p_price;
    private int p_USID;
    private int p_PDID;
    private String p_SubscribeCycle;
}
