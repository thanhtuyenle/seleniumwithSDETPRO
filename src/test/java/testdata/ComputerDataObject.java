package testdata;

public class ComputerDataObject {
    private String processorType;
    private String ram;
    private String hdd;
    private String os;
    private String software;

//    public ComputerDataObject(String processorType, String ramType, String hddType, String os, String softwareType) {
//        this.processorType = processorType;
//        this.ramType = ramType;
//        this.hddType = hddType;
//        this.os = os;
//        this.softwareType = softwareType;
//    }

    public String getProcessorType() {
        return processorType;
    }

    public String getRam() {
        return ram;
    }

    public String getHdd() {
        return hdd;
    }

    public String getSoftware() {
        return software;
    }

    public void setProcessorType(String processorType) {
        this.processorType = processorType;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

    @Override
    public String toString() {
        return "ComputerDataObject{" +
                "processorType='" + processorType + '\'' +
                ", ramType='" + ram + '\'' +
                ", hddType='" + hdd + '\'' +
                ", os='" + os + '\'' +
                ", softwareType='" + software + '\'' +
                '}';
    }
}
