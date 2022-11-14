package frontdoorprivacy.model.product;

public class MypageProduct {

    private int ENID;
    private String ProductName;
    private int Price;
    private String Category;
    private String DetailCategory;
    private String Detail;
    private String ImageFileName;
    private String ImageFilePath;
    private String DetailFileName;
    private String SaleYN;

    public MypageProduct() {
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

    public String getDetailFileName() {
        return DetailFileName;
    }

    public void setDetailFileName(String detailFileName) {
        DetailFileName = detailFileName;
    }

    public String getSaleYN() {
        return SaleYN;
    }

    public void setSaleYN(String saleYN) {
        SaleYN = saleYN;
    }
}
