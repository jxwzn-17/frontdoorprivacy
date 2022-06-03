package frontdoorprivacy.model.product;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class CategoryProduct {
    int PDID;
    int ENID;
    String ProductName;
    String ImageFileName;
    String ImageFilePath;
    int Price;
    float Sale;
    String Category;
    String Detail;
    String DetailFileName;

    public CategoryProduct() {
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

    public float getSale() {
        return Sale;
    }

    public void setSale(float sale) {
        Sale = sale;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
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
