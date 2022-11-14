package frontdoorprivacy.mapper.product;

import frontdoorprivacy.model.product.*;
import frontdoorprivacy.model.user.PaymentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    void enrollProduct(ProductDB productDB);

    List<CategoryProduct> getAllProduct();
    List<CategoryProduct> getNewProduct();

    List<CategoryProduct> getTopProduct();
    List<CategoryProduct> getCategoryProduct(String p_category);
    List<CategoryProduct> getDetailCategory(String p_detailcategory);
    List<CategoryProduct> getSaleProduct();

    //제품 상세페이지
    DetailedProductRes detailedProduct(DetailedProductReq detailedProductReq);

    List<OptionOutput> getProductOption(DetailedProductReq detailedProductReq);
    List<CategoryProduct> getpersonalProduct(int p_enid);
    MypageProduct getmypageProduct(int p_pdid);
    List<Myproductoptionoutput> getmypageProductOption(int p_pdid);

    List<CategoryProduct> searchProduct(String target);

    String getImageFileName(int p_PDID);
    String getDetailFileName(int p_PDID);

    void updatemypageProduct(UpdateMypageProduct updateMypageProduct);
    void updatemypageProductOption(UpdateMypageProductOption updateMypageProductOption);

    void updateCountProduct(CountInput countInput);
    FileInfo getfileInfo(int p_pdid);

    void insertPayment(PaymentDTO paymentDTO);


    void insertOption(OptionInput optionInput);
    int getPDID(PdidFindInput input);
}
