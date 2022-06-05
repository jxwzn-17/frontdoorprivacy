package frontdoorprivacy.mapper.product;

import frontdoorprivacy.model.product.CategoryProduct;
import frontdoorprivacy.model.product.DetailedProductReq;
import frontdoorprivacy.model.product.DetailedProductRes;
import frontdoorprivacy.model.product.ProductDB;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    void enrollProduct(ProductDB productDB);

    List<CategoryProduct> getAllProduct();
    List<CategoryProduct> getCategoryProduct(String p_category);
    List<CategoryProduct> getDetailCategory(String p_detailcategory);
    List<CategoryProduct> getSaleProduct();

    //제품 상세페이지
    DetailedProductRes detailedProduct(DetailedProductReq detailedProductReq);
    List<CategoryProduct> getpersonalProduct(int p_enid);

}
