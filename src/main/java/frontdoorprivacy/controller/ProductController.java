package frontdoorprivacy.controller;

import frontdoorprivacy.model.product.*;
import frontdoorprivacy.service.product.ProductService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping
public class ProductController {
    private Logger logger = LoggerFactory.getLogger(ProductController.class);
    private static ProductService productService;

    //각자 작업 컴퓨터 C드라이브 아래에 frontdoor 경로 추가해놓을것
    private static String Path = "/home/tester/frontdoorimages";


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/mypage/company/product")
    public ResponseEntity<?> enrollProduct(@RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile,
                                           @RequestPart(value = "options") List<OptionInput> options,
                                           @RequestPart(value = "productReq") ProductReq ProductReq,
                                           @RequestPart(value = "detailFile", required = false) MultipartFile detailFile

    ) throws IOException {

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


        int min =Integer.MAX_VALUE;

            for (OptionInput a : options) {
                min = Integer.min(a.getP_Price(), min);
        }
        //productDB 에 set으로 설정해주기
        ProductDB productDB = new ProductDB();
        productDB.setP_ENID(ProductReq.getP_ENID());
        productDB.setP_ProductName(ProductReq.getP_ProductName());
        productDB.setP_Category(ProductReq.getP_Category());
        productDB.setP_Detail(ProductReq.getP_Detail());
        productDB.setP_Price(min);
        productDB.setP_DetailCategory(ProductReq.getP_DetailCategory());
        productDB.setP_ImageFileName(storeFileName);
        productDB.setP_ImageFilePath(Path);
        productDB.setP_DetailFileName(detailStoreFileName);
        productDB.setP_SaleYN(ProductReq.getP_SaleYN());

        //프로시저 호출해서 데베에 insert 해주기
        productService.enrollProduct(productDB);

        PdidFindInput pdidFindInput = new PdidFindInput();
        pdidFindInput.setP_ENID(ProductReq.getP_ENID());
        pdidFindInput.setP_ProductName(ProductReq.getP_ProductName());
        pdidFindInput.setP_DetailCate(ProductReq.getP_DetailCategory());

        int pdid = productService.getPDID(pdidFindInput);

            for (OptionInput a : options) {
                a.setP_PDID(pdid);
                productService.insertOption(a);
        }
        //return 은 ProductDB 해주기 or ok 메세지만 보내주면됨
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }
    @PostMapping("/product/edit")
    public ResponseEntity<?> editProduct(@RequestPart(value = "multipartFile", required = false) MultipartFile multipartFile,
                                           @RequestPart(value = "options") List<UpdateMypageProductOption> options,
                                           @RequestPart(value = "productReq") UpdateMypageProduct updateMypageProduct,
                                           @RequestPart(value = "detailFile", required = false) MultipartFile detailFile

    ) throws IOException {

        String storeFileName;
        String detailStoreFileName;
//        int pdid = updateMypageProduct.getP_PDID();
        int pdid = options.get(0).getP_PDID();

        logger.info("----------------");
        logger.info(""+options.get(0).getP_PDID());
        logger.info(""+updateMypageProduct.getP_ENID());
        logger.info(updateMypageProduct.getP_ProductName());
        logger.info(updateMypageProduct.getP_Category());
        logger.info(updateMypageProduct.getP_Detail());
        logger.info(updateMypageProduct.getP_DetailCategory());
        logger.info(updateMypageProduct.getP_DetailFileName());

        //여기는 썸네일에 쓸 이미지 파일을 uuid 로 바꿔주고 저장
        //uuid 변경하고 저장한다음 파일명하고 파일경로 받아오기
        if(multipartFile==null){
            storeFileName = productService.getImageFileName(pdid);

            logger.info("----------------");
            logger.info(storeFileName);
        }else {
            String originalFilename = multipartFile.getOriginalFilename();

            //uuid를 이용 파일명 변경
            storeFileName = createStoreFileName(originalFilename);

            //로컬에 파일을 저장
            multipartFile.transferTo(new File(getFullPath(storeFileName)));
        }
        if(detailFile==null){
            detailStoreFileName = productService.getDetailFileName(pdid);
            logger.info("----------------");
            logger.info(detailStoreFileName);
        }else {
            //이곳 로직은 Detail에 쓸 이미지 파일을 uuid 로 바꿔주고 저장
            String detailOriginalFileName = detailFile.getOriginalFilename();
            detailStoreFileName = createStoreFileName(detailOriginalFileName);
            detailFile.transferTo(new File(getFullPath(detailStoreFileName)));
        }

        int min =Integer.MAX_VALUE;

        for (UpdateMypageProductOption a : options) {
            min = Integer.min(a.getP_Price(), min);
        }
        updateMypageProduct.setP_PDID(pdid);
        updateMypageProduct.setP_DetailFileName(detailStoreFileName);
        updateMypageProduct.setP_ImageFileName(storeFileName);
        updateMypageProduct.setP_ImageFilePath(Path);
        updateMypageProduct.setP_Price(min);

        //프로시저 호출해서 데베에 insert 해주기

        productService.updatemypageProduct(updateMypageProduct);
        logger.info("----------------");
        logger.info(""+updateMypageProduct.getP_PDID());
        logger.info(""+updateMypageProduct.getP_ENID());
        logger.info(updateMypageProduct.getP_ProductName());
        logger.info(updateMypageProduct.getP_Category());
        logger.info(updateMypageProduct.getP_Detail());
        logger.info(updateMypageProduct.getP_DetailCategory());
        logger.info(updateMypageProduct.getP_DetailFileName());
        logger.info(""+updateMypageProduct.getP_Price());

        for (UpdateMypageProductOption a : options) {
            productService.updatemypageProductOption(a);
        }
        //return 은 ProductDB 해주기 or ok 메세지만 보내주면됨
        HashMap<String,String> msg = new HashMap<>();
        msg.put("message","Success");
        return ResponseEntity.ok(msg);
    }

    @GetMapping("/category/main")
    public ResponseEntity<List<CategoryProduct>> getAllProduct(){
        List<CategoryProduct> categoryProducts = productService.getAllProduct();

        return new ResponseEntity<>(categoryProducts , HttpStatus.OK);
    }
    //top 10
    @GetMapping("/category/best")
    public ResponseEntity<List<CategoryProduct>> getTopProduct(){
        List<CategoryProduct> topProducts = productService.getTopProduct();

        return new ResponseEntity<>(topProducts,HttpStatus.OK);
    }
    @GetMapping("/category/new")
    public ResponseEntity<List<CategoryProduct>> getNewProduct(){
        List<CategoryProduct> getNewProduct = productService.getNewProduct();
        return new ResponseEntity<>(getNewProduct,HttpStatus.OK);
    }

    //검색
    @PostMapping("/category/search")
    public ResponseEntity<List<CategoryProduct>> searchProduct(@RequestBody HashMap<String,String> p_target){
        List<CategoryProduct> searchProduct = productService.searchProduct(p_target.get("target"));
//        logger.info(p_target.get("target"));
        return new ResponseEntity<>(searchProduct, HttpStatus.OK);
    }

    //큰 카테고리
    @PostMapping("/category/select")
    public ResponseEntity<List<CategoryProduct>> getCategoryProduct(@RequestBody HashMap<String,String> p_category){
        List<CategoryProduct> categoryProducts = productService.getCategoryProduct(p_category.get("category"));
//       logger.info(p_category.get("category"));
        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }
    //작은 카테고리
    @PostMapping("/category/detail")
    public ResponseEntity<List<CategoryProduct>> getDetailCategory(@RequestBody HashMap<String,String> p_detailcategory){
        List<CategoryProduct> categoryProducts = productService.getDetailCategory(p_detailcategory.get("detailcategory"));

        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }
    //세일 상품 select
    @GetMapping("/category/sale")
    public ResponseEntity<List<CategoryProduct>> getSaleProduct(){
        List<CategoryProduct> categoryProducts = productService.getSaleProduct();

        return new ResponseEntity<>(categoryProducts , HttpStatus.OK);
    }

    @PostMapping("product/detail")
    public ResponseEntity<DetailedProductRes> getDetailedProduct(@RequestBody DetailedProductReq detailedProductReq){

        DetailedProductRes detailedProductRes = productService.detailedProduct(detailedProductReq);
        List<OptionOutput> optionInputs = productService.getProductOption(detailedProductReq);

        detailedProductRes.setP_Options(optionInputs);
        int tmp = detailedProductRes.getP_Count();
        int id = detailedProductReq.getP_PDID();
        tmp++;
        CountInput countInput = new CountInput();
        countInput.setCount(tmp);
        countInput.setId(id);

        //파일 유무 판단
        String detailname = detailedProductRes.getP_DetailFileName();
        String imagename = detailedProductRes.getP_ImageFileName();
        Resource main = new FileSystemResource(Path+imagename);
        Resource detail = new FileSystemResource(Path+detailname);

        if(!main.exists()||!detail.exists()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        productService.updateCountProduct(countInput);
        return new ResponseEntity<>(detailedProductRes, HttpStatus.OK);
    }

    @PostMapping("/mypage/company/manage")
    public ResponseEntity<List<CategoryProduct>> getpersonalProuduct(@RequestBody HashMap<String,Integer> p_enid){
        List<CategoryProduct> categoryProducts = productService.getpersonalProduct(p_enid.get("enid"));

        return new ResponseEntity<>(categoryProducts, HttpStatus.OK);
    }

    @PostMapping("/product/update")
    public ResponseEntity<?> getmyprouductInfo(@RequestBody HashMap<String, Integer> p_pdid){
        MypageProduct mypageProduct = productService.getmypageProduct(p_pdid.get("pdid"));
        return new ResponseEntity<>(mypageProduct, HttpStatus.OK);
    }
    @PostMapping("/productoption/update")
    public ResponseEntity<?> getmyprouductoptionInfo(@RequestBody HashMap<String, Integer> p_pdid){
        List<Myproductoptionoutput> myproductoptionoutputs = productService.getmypageProductOption(p_pdid.get("pdid"));
        return new ResponseEntity<>(myproductoptionoutputs, HttpStatus.OK);
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

