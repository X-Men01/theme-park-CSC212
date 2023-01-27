public class vistorInfo {

    private final int maxNumberOfRegion = 4;
    private String fName, lName, phone;

    private int region, type;

    private ArrayStack<Integer> order;

    public vistorInfo(String fName, String lName, String phone, int region, int type, String orderOfRegion) {
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.region = region;
        this.type = type;
        order = new ArrayStack<Integer>(maxNumberOfRegion);
        inserIntoOrder(orderOfRegion);
    }

    private void inserIntoOrder(String orderOfRegion) {
        for (char c : orderOfRegion.toCharArray())
            if (c != ',') {
                Integer kingdom = Integer.parseInt(String.valueOf(c));
                order.push(kingdom);
            }

    }

    public int getLocation() {
        return order.peek();
    }

    public boolean isVip() {
        return type == 1;
    }

    @Override
    public String toString() {
        return "Name: " + (fName + " " + lName) + "\nRegion: " + region + "\nVIP Pass holder: " + isVip()
                + "\nPhone number: " + phone + "\nOrder of visiting the kingdoms: " + order + "\n";
    }

    public int getRegion() {
        return region;
    }

    public String getLastName() {
        return lName;
    }

    public String getFullName() {
        return fName + " " + lName;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayStack<Integer> getOrder() {
        return order;
    }

}