package frontdoorprivacy.controller;

import frontdoorprivacy.model.product.ProductDB;
import frontdoorprivacy.model.product.ProductReq;
import frontdoorprivacy.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {

    private static ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/mypage/company/product")
    public ResponseEntity<ProductDB> enrollProduct(@RequestPart MultipartFile multipartFile,
                                                   @RequestPart ProductReq productReq) {

        //uuid 변경하고 저장한다음 파일명하고 파일경로 받아오기

        //productDB 에 set으로 설정해주기

        //프로시저 호출해서 데베에 insert 해주기

        //return 은 ProductDB 해주기 or ok 메세지만 보내주면됨

    }
}
