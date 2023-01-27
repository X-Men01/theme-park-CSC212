public class vistorType {
    private int type;
    private LinkedList<vistorInfo> vistorList;

    public vistorType(int type) {
        this.type = type;
        vistorList = new LinkedList<vistorInfo>();
    }

    public int getType() {
        return type;
    }

    public int getNumOfVistor() {
        return vistorList.getSize();
    }

    public void insert(vistorInfo v) {
        vistorList.insert(v);
    }

}
