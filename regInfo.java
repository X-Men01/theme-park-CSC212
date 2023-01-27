public class regInfo{
    private int region;
    private vistorType[] vtype;

    public regInfo(int region) {
        this.region = region;
        vtype = new vistorType[2];
        vtype[0] = new vistorType(0);// regular
        vtype[1] = new vistorType(1); // vips
    }

    public int getRegion() {
        return region;
    }

    public int getTotalVistors() {
        return vtype[0].getNumOfVistor() + vtype[1].getNumOfVistor();
    }
}