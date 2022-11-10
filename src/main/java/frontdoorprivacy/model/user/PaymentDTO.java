package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PaymentDTO {
    private String p_imp_uid;

    private int p_price;

    private int p_USID;

    private int p_POID;

    private int p_SubscribeCycle;

    private int p_Count;

    private String p_SubscribeName;
}
