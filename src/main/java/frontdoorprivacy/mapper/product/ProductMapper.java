package frontdoorprivacy.mapper.product;

import frontdoorprivacy.model.product.ProductDB;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {

    void enrollProduct(ProductDB productDB);

}
