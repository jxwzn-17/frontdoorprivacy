package frontdoorprivacy.model.product;

public class FileInfo {

    private String ImageFileName ;
    private String ImageFilePath;
    private String DetailFileName;

    public FileInfo() {
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
}
