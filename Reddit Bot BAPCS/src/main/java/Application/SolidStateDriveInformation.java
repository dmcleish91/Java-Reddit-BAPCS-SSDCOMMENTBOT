package Application;

import Application.Information.AdvancedDriveData;
import Application.Information.BasicDriveData;
import Application.Information.WebData;

public class SolidStateDriveInformation {

    private BasicDriveData basicDriveData;
    private AdvancedDriveData advancedDriveData;
    private WebData webData;

    public SolidStateDriveInformation(String brand, String model, String ssdInterface, String formFactor, String capacities, String controller, String configuration, String dram, String hmb, String nandBrand, String nandType, String nand2d3d, String layers, String readWrite, String categories, String note, String productPage, String productPage2, String amazonAffiliateLink, String amazonPrice, String comingSoon, String pCPartPicker) {
        basicDriveData = new BasicDriveData(brand, model, ssdInterface, formFactor, capacities);
        advancedDriveData = new AdvancedDriveData(controller, configuration, dram, hmb, nandBrand, nandType, nand2d3d, layers, readWrite, categories);
        webData = new WebData(note, productPage, productPage2, amazonAffiliateLink, amazonPrice, comingSoon, pCPartPicker);
    }

    public String getModelName() {
        return basicDriveData.getModel();
    }

    @Override
    public String toString() {
        return "The " + basicDriveData.getBrand() + " " + basicDriveData.getModel() +" is a *" + advancedDriveData.getNandType() + "* **" + advancedDriveData.getCategories() + "** SSD.\n" +
                "\n" +
                "Data provided by [NewMaxx's SSD Spreadsheet](https://docs.google.com/spreadsheets/d/1B27_j9NDPU3cNlj2HKcrfpJKHkOf-Oi1DbuuQva2gT4/):\n" +
                "\n" +
                "* Interface: **" + basicDriveData.getSsdInterface() + "**\n" +
                "\n" +
                "* Form Factor: **" + basicDriveData.getFormFactor() + "\"**\n" +
                "\n" +
                "* Controller: **" + advancedDriveData.getController() + "**\n" +
                "\n" +
                "* Configuration: **" + advancedDriveData.getConfiguration() + "**\n" +
                "\n" +
                "* DRAM: **" + advancedDriveData.getDram() + "**\n" +
                "\n" +
                "* HMB: **" + advancedDriveData.getHmb() + "**\n" +
                "\n" +
                "* NAND Brand: **" + advancedDriveData.getNandBrand() + "**\n" +
                "\n" +
                "* NAND Type: **" + advancedDriveData.getNandType() + "**\n" +
                "\n" +
                "* 2D/3D NAND: **" + advancedDriveData.getNand2d3d() + "**\n" +
                "\n" +
                "* Layers: **" + advancedDriveData.getLayers() + "**\n" +
                "\n" +
                "* R/W: **" + advancedDriveData.getReadWrite() + "**\n" +
                "\n" +
                "[Click here to view camelcamelcamel product search page](https://camelcamelcamel.com/search?sq=" + basicDriveData.getBrand() + "+" +  basicDriveData.getModel()+ "+" + basicDriveData.getCapacities() + ").\n" +
                "\n" +
                "--- Project build in Java with openCSV and JRAW. Send me a message with suggestions or tips!\n";
    }

    public String otherString() {
        return basicDriveData.getBrand() + " " + basicDriveData.getModel() + "\n" + advancedDriveData.getCategories() +" tier based on the SSD tier list, additional info:\n" + "Interface: " + basicDriveData.getSsdInterface() +
                "\nForm Factor: " + basicDriveData.getFormFactor() + "\nController: " + advancedDriveData.getController() + "\nConfiguration: " + advancedDriveData.getConfiguration() + "\nDRAM: " + advancedDriveData.getDram() + "\nHMB: " + advancedDriveData.getHmb() +
                "\nNAND Brand: " + advancedDriveData.getNandBrand() + "\nNAND Type: " + advancedDriveData.getNandType() + "\n2D/3D NAND: " + advancedDriveData.getNand2d3d() + "\nLayers: " + advancedDriveData.getLayers() + "\nR/W (Up to, in MB/s): " + advancedDriveData.getReadWrite() + "\n";

    }
}
