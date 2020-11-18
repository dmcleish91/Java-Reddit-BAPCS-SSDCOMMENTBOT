package Application.Information;

public class BasicDriveData {
    private String brand;
    private String model;
    private String ssdInterface;
    private String formFactor;
    private String capacities;

    public BasicDriveData(String brand, String model, String ssdInterface, String formFactor, String capacities) {
        this.brand = brand;
        this.model = model;
        this.ssdInterface = ssdInterface;
        this.formFactor = formFactor;
        this.capacities = capacities;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSsdInterface() {
        return ssdInterface;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public String getCapacities() {
        return capacities;
    }
}
