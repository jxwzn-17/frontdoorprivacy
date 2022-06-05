package frontdoorprivacy.service.product;

import frontdoorprivacy.mapper.product.ProductMapper;
import frontdoorprivacy.model.product.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Marker MESSAGE_MARKER = MarkerFactory.getMarker("PRODUCT");
    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);
    private static ProductMapper productMapper;

    @Autowired
    public ProductService(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public void enrollProduct(ProductDB productDB){
        productMapper.enrollProduct(productDB);
    }

    public List<CategoryProduct> getAllProduct(){
        return productMapper.getAllProduct();}
    public List<CategoryProduct> getCategoryProduct(String p_category){
        return productMapper.getCategoryProduct(p_category);
    }

    public List<CategoryProduct> getDetailCategory(String p_detailcategory){
        return productMapper.getDetailCategory(p_detailcategory);
    }
    public List<CategoryProduct>  getSaleProduct(){
        return productMapper.getSaleProduct();
    }

    public DetailedProductRes detailedProduct(DetailedProductReq enrollSubscribeReq){
        return productMapper.detailedProduct(enrollSubscribeReq);
    }

    public List<CategoryProduct> getpersonalProduct(int p_enid){
        return productMapper.getpersonalProduct(p_enid);
    }

    public MypageProduct getmypageProduct(int p_pdid){
        return productMapper.getmypageProduct(p_pdid);
    }

    public FileInfo getfileInfo(int p_pdid){
        return productMapper.getfileInfo(p_pdid);
    }
    public void updatemypageProduct(UpdateMypageProduct updateMypageProduct){
        productMapper.updatemypageProduct(updateMypageProduct);
    ;}
}
