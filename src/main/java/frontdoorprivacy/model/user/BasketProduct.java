package frontdoorprivacy.model.user;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class BasketProduct {
    int BSID;
    int PDID;
    int ENID;
    String ProductName;
    String ImageFileName;
    String ImageFilePath;
    int Price;

    String Category;
    String DetailCategory;


    String Detail;
    String DetailFileName;

    public BasketProduct() {
    }

    public int getBSID() {
        return BSID;
    }

    public void setBSID(int BSID) {
        this.BSID = BSID;
    }

    public int getPDID() {
        return PDID;
    }

    public void setPDID(int PDID) {
        this.PDID = PDID;
    }

    public int getENID() {
        return ENID;
    }

    public void setENID(int ENID) {
        this.ENID = ENID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getImageFileName() {
        return ImageFileName;
    }

    public void setImageFileName(String imageFileName) {
        ImageFileName = imageFileName;
    }

    public String getImageFilePath() {
        return ImageFilePath;
    }

    public void setImageFilePath(String imageFilePath) {
        ImageFilePath = imageFilePath;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getDetailCategory() {
        return DetailCategory;
    }

    public void setDetailCategory(String detailCategory) {
        DetailCategory = detailCategory;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getDetailFileName() {
        return DetailFileName;
    }

    public void setDetailFileName(String detailFileName) {
        DetailFileName = detailFileName;
    }
}
