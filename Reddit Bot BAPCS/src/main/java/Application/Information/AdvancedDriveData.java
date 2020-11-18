package Application.Information;

public class AdvancedDriveData {
    private String controller;
    private String configuration;
    private String dram;
    private String hmb;
    private String nandBrand;
    private String nandType;
    private String nand2d3d;
    private String layers;
    private String readWrite;
    private String categories;

    public AdvancedDriveData(String controller, String configuration, String dram, String hmb, String nandBrand, String nandType, String nand2d3d, String layers, String readWrite, String categories) {
        this.controller = controller;
        this.configuration = configuration;
        this.dram = dram;
        this.hmb = hmb;
        this.nandBrand = nandBrand;
        this.nandType = nandType;
        this.nand2d3d = nand2d3d;
        this.layers = layers;
        this.readWrite = readWrite;
        this.categories = categories;
    }

    public String getController() {
        return controller;
    }

    public String getConfiguration() {
        return configuration;
    }

    public String getDram() {
        return dram;
    }

    public String getHmb() {
        return hmb;
    }

    public String getNandBrand() {
        return nandBrand;
    }

    public String getNandType() {
        return nandType;
    }

    public String getNand2d3d() {
        return nand2d3d;
    }

    public String getLayers() {
        return layers;
    }

    public String getReadWrite() {
        return readWrite;
    }

    public String getCategories() {
        return categories;
    }
}
