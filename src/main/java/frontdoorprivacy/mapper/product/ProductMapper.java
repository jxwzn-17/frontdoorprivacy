package frontdoorprivacy.mapper.product;

import frontdoorprivacy.model.product.CategoryProduct;
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

}
