package Application.Information;

public class WebData {
    private String note;
    private String productPage;
    private String productPage2;
    private String amazonAffiliateLink;
    private String amazonPrice;
    private String comingSoon;
    private String pCPartPicker;
    private String neweggCS;

    public WebData(String note, String productPage, String productPage2, String amazonAffiliateLink, String amazonPrice, String comingSoon, String pCPartPicker) {
        this.note = note;
        this.productPage = productPage;
        this.productPage2 = productPage2;
        this.amazonAffiliateLink = amazonAffiliateLink;
        this.amazonPrice = amazonPrice;
        this.comingSoon = comingSoon;
        this.pCPartPicker = pCPartPicker;
    }

    public String getNote() {
        return note;
    }

    public String getProductPage() {
        return productPage;
    }

    public String getProductPage2() {
        return productPage2;
    }

    public String getAmazonAffiliateLink() {
        return amazonAffiliateLink;
    }

    public String getAmazonPrice() {
        return amazonPrice;
    }

    public String getComingSoon() {
        return comingSoon;
    }

    public String getpCPartPicker() {
        return pCPartPicker;
    }

    public String getNeweggCS() {
        return neweggCS;
    }
}
