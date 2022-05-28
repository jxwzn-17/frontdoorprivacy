package frontdoorprivacy.service.product;

import frontdoorprivacy.mapper.product.ProductMapper;
import frontdoorprivacy.model.product.ProductDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
