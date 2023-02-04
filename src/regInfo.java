package src;
public class regInfo {
    private int region;
    private vistorType[] vtype;

    public regInfo(int region) {
        this.region = region;
        vtype = new vistorType[2];
        vtype[0] = new vistorType(0);// vips
        vtype[1] = new vistorType(1);  // regular
    }

    public void insertIntoRegInfo(vistorInfo v) {
        if (v.isVip())
            vtype[0].insert(v);
        else
            vtype[1].insert(v);
    }

    public int getRegion() {
        return region;
    }

    public int getTotalVistors() {
        return vtype[0].getNumOfVistor() + vtype[1].getNumOfVistor();
    }

    public int getTotalVIPs() {
        return vtype[0].getNumOfVistor();
    }
    @Override
    public String toString() {
        return "Region #" + region +" # Of Vipes "+ vtype[0].getNumOfVistor() + " # Reger " +vtype[1].getNumOfVistor()  ;
    }
}