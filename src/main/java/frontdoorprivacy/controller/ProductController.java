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

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Controller
public class ProductController {

    private static ProductService productService;

    //각자 작업 컴퓨터 C드라이브 아래에 frontdoor 경로 추가해놓을것
    private static String Path = "C:/frontdoor/";

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/mypage/company/product")
    public ResponseEntity<?> enrollProduct(@RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile,
                              @RequestPart(value = "productReq") ProductReq productReq,
                              @RequestPart(value = "detailFile", required = false) MultipartFile detailFile) throws IOException {

        //여기는 썸네일에 쓸 이미지 파일을 uuid 로 바꿔주고 저장
        //uuid 변경하고 저장한다음 파일명하고 파일경로 받아오기
        String originalFilename = multipartFile.getOriginalFilename();

        //uuid를 이용 파일명 변경
        String storeFileName = createStoreFileName(originalFilename);

        //로컬에 파일을 저장
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        //이곳 로직은 Detail에 쓸 이미지 파일을 uuid 로 바꿔주고 저장
        String detailOriginalFileName = detailFile.getOriginalFilename();
        String detailStoreFileName = createStoreFileName(detailOriginalFileName);
        detailFile.transferTo(new File(getFullPath(detailStoreFileName)));

        //productDB 에 set으로 설정해주기
        ProductDB productDB = new ProductDB();
        productDB.setP_ENID(productReq.getP_ENID());
        productDB.setP_ProductName(productReq.getP_ProductName());
        productDB.setP_Price(productReq.getP_Price());
        productDB.setP_Category(productReq.getP_Category());
        productDB.setP_Detail(productReq.getP_Detail());
        productDB.setP_ImageFileName(storeFileName);
        productDB.setP_ImageFilePath(Path);
        productDB.setP_DetailFileName(detailStoreFileName);

        //프로시저 호출해서 데베에 insert 해주기
        productService.enrollProduct(productDB);

        //return 은 ProductDB 해주기 or ok 메세지만 보내주면됨
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    //" "여기안에 로컬저장소를 입력하면됨
    public String getFullPath(String filename) {
        return Path + filename;
    }

    private String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}

