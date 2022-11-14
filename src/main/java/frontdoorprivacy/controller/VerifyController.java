package frontdoorprivacy.controller;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.request.CancelData;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import frontdoorprivacy.model.user.PaymentDTO;
//import frontdoorprivacy.model.user.PaymentReqDTO;
import frontdoorprivacy.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

@Controller
@Slf4j
public class VerifyController {

    private final IamportClient iamportClient;
    private final ProductService productService;

    @Autowired
    public VerifyController(ProductService productService) {
//        this.iamportClient = new IamportClient("...", "...");
        this.iamportClient = new IamportClient("2652795188665450", "f3b763cccef4f2a152895d396dda79ffd3aaea8702885b58911ba227c305f03155dabfe7abea83b1");

        this.productService = productService;
    }


    @PostMapping("/verifyIamport/{imp_uid}")
    public ResponseEntity<?> paymentByImpUid(@PathVariable("imp_uid") String imp_uid, HttpServletRequest request) throws IamportResponseException, IOException {
        log.info("paymentByImpUid 진입");
        IamportResponse<Payment> paymentIamportResponse = iamportClient.paymentByImpUid(imp_uid);
        Payment payment = paymentIamportResponse.getResponse();

        HttpSession session = request.getSession();
        session.setAttribute("payment",payment);
        session.setMaxInactiveInterval(60);

        BigDecimal amount = payment.getAmount();
        String str = String.valueOf(amount);
        HashMap<String,String> map = new HashMap<>();
        map.put("amount",str);

        return ResponseEntity.ok(map);
    }

    //상품 id, 사용자 id, 구독cycle, 가격, imp_uid 받아서 넘겨주면 됨됨
    @PostMapping("/subscribe/payment")
    public ResponseEntity<?> savePayment(@PathVariable int id, HttpServletRequest request, @RequestBody PaymentDTO paymentDTO) throws IamportResponseException, IOException {

        HashMap<String, String> response = new HashMap<>();

        HttpSession session = request.getSession(false);

        CancelData cancelData = new CancelData(paymentDTO.getP_imp_uid(), true);


        //verifyIamport에서 세션을 만들어서 여기서 검증한 후 없애줘야함
        //여긴 결제승인을 한곳이 아니므로 잘못된 결제먼저해달라고하면됨
        Payment payment = (Payment) session.getAttribute("payment");
        if(payment == null) {
            response.put("response","잘못된 접근입니다.");
            return ResponseEntity.ok(response);
        }

        try {
            //여기에다가 Payment 를 저장하는 로직을 작성할것 - 가격, 저기 위에서 찾아온, imp_uid 넘겨주고 저장하는 로직 작성

            productService.insertPayment(paymentDTO);

            response.put("response","1");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            iamportClient.cancelPaymentByImpUid(cancelData);
            response.put("response","잘못된 접근입니다");
            return ResponseEntity.ok(response);
        }

    }

}
