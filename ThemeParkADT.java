import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThemeParkADT {
    private regInfo[] regionArray, regSortedArray;
    private LinkedList<vistorInfo> visitors, vips;
    private int numOfregions;

    private Pattern regexVistor = Pattern
            .compile("(?<fName>[^,]*),(?<lName>[^,]*),(?<region>\\d),(?<type>\\d),(?<phone>\\d{10}),(?<order>[0-9,]*)");

    public ThemeParkADT(int k) {
        regionArray = new regInfo[k];
        vips = new LinkedList<vistorInfo>();
        visitors = new LinkedList<vistorInfo>();
    }

    // operation 0
    public void readFileAndAnalyse(String f) throws FileNotFoundException {
        File file = openAndCreateFile(f);
        if (file == null) {
            System.out.println("The file does not exist");
            return;
        }

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            vistorInfo newVistor = readAndCreatVistor(sc.nextLine());
            visitors.insert(newVistor);

            if (newVistor.isVip())
                vips.insert(newVistor);

            int indexOfRegion = serachForRegion(newVistor.getRegion());

            inserIntoRegionArray(newVistor, indexOfRegion);

        }

        createAndCopyIntoRegSortedArray();
        sortRegions(regSortedArray);
    }

    private void sortRegions(regInfo[] regSortedArray) {
        mergeSort m = new mergeSort(regSortedArray);
    }

    // operation 1
    public void searchVisitor(String lName) {
        for (vistorInfo v : visitors)
            if (v.getLastName().equals(lName))
                System.out.println(v);

    }

    // operation 2
    public void rgnCount() {
        System.out.println("The total number of regions are " + numOfregions);
    }

    // operation 3
    public void popularRgn() {
        for (int i = 0; i < numOfregions; i++)
            System.out.println("Region " + regSortedArray[i].getRegion() + ": " + regSortedArray[i].getTotalVistors());
    }

    // operation 4
    public void vipRgn(int i) {
        if (i > 0 && i < numOfregions)
            System.out.println("The total number of VIP pass holders coming from Region " + i + " is "
                    + regionArray[i - 1].getTotalVIPs());
        else
            System.out.println("There no region with this number ");
    }

    // operation 5
    public void vipLocation() {
        for (vistorInfo v : vips)
            System.out.println(v.getFullName() + " in kingdom " + v.getLocation());
    }

    // operation 6
    public boolean checkVipLoc(String n1, String n2) {
        vistorInfo vistor1 = null, vistor2 = null;
        for (vistorInfo v : vips) {
            if (v.getPhone().equals(n1) || v.getPhone().equals(n2))
                if (vistor1 == null)
                    vistor1 = v;
                else
                    vistor2 = v;
        }
        if (vistor1 == null || vistor2 == null || vistor1.getRegion() != vistor2.getRegion())
            return false;

        return vistor1.getOrder().sameOrder(vistor2.getOrder());
    }

    // operation 7
    public boolean checkRegLoc(int r, String n1, String n2) {
        vistorInfo vistor1 = null, vistor2 = null;
        for (vistorInfo v : visitors) {
            if (v.getPhone().equals(n1) || v.getPhone().equals(n2))
                if (vistor1 == null)
                    vistor1 = v;
                else
                    vistor2 = v;
        }
        if (vistor1 == null || vistor2 == null || vistor1.getRegion() != r || vistor2.getRegion() != r
                || vistor1.isVip() || vistor2.isVip())
            return false;

        return vistor1.getOrder().sameOrder(vistor2.getOrder());
    }

    private void inserIntoRegionArray(vistorInfo newVistor, int indexOfRegion) {
        if (indexOfRegion != -1)
            regionArray[indexOfRegion].insertIntoRegInfo(newVistor);
        else {
            regionArray[numOfregions++] = new regInfo(newVistor.getRegion());
            regionArray[numOfregions - 1].insertIntoRegInfo(newVistor);
        }
    }

    private int serachForRegion(int region) {
        for (int i = 0; i < numOfregions; i++)
            if (regionArray[i].getRegion() == region)
                return i;
        return -1;
    }

    private vistorInfo readAndCreatVistor(String nextLine) {
        Matcher mat = regexVistor.matcher(nextLine);

        if (!mat.find())
            return null;

        String fistName = mat.group("fName");
        String lastName = mat.group("lName");
        int region = Integer.parseInt(mat.group("region"));
        int type = Integer.parseInt(mat.group("type"));
        String phone = mat.group("phone");
        String order = mat.group("order");

        return new vistorInfo(fistName, lastName, phone, region, type, order);
    }

    private File openAndCreateFile(String fileName) {
        File file = new File(fileName);
        return file.exists() ? file : null;
    }

    private void createAndCopyIntoRegSortedArray() {
        regSortedArray = new regInfo[numOfregions];
        for (int i = 0; i < numOfregions; i++)
            regSortedArray[i] = regionArray[i];
    }

    public void printVisitor() {
        visitors.print();
    }

    public void printVIP() {
        vips.print();
    }

}
