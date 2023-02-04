package src;

import java.io.FileNotFoundException;

public class ThemeParkADT {
    private regInfo[] regionArray, regSortedArray;
    private LinkedList<vistorInfo> visitors, vips;
    private int numOfregions;

    public ThemeParkADT() {
        vips = new LinkedList<vistorInfo>();
        visitors = new LinkedList<vistorInfo>();
    }

    // operation 0
    public void readFileAndAnalyse(String fileName) throws FileNotFoundException {
        ProcessVisitors processor = new ProcessVisitors();

        if (!processor.openAndCreateFile(fileName)) {
            System.out.println("The file does not exist");
            return;
        }
        int maxIndex = 0;
        while (processor.hasNextVistor()) {
            vistorInfo newVistor = processor.CreatVistor();
            visitors.insert(newVistor);

            if (newVistor.isVip())
                vips.insert(newVistor);

            if (newVistor.getRegion() > maxIndex)
                maxIndex = newVistor.getRegion();

        }
        inserIntoRegionArray(maxIndex);
        createAndCopyIntoRegSortedArray();
        sortRegions(regSortedArray);
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
        if (i > 0 && i < regionArray.length)
            System.out.println("The total number of VIP pass holders coming from Region " + i + " is "
                    + regionArray[i].getTotalVIPs());
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
        return printReasonVIP(vistor1, vistor2, n1, n2);
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

        return printReasonReg(vistor1, vistor2, n1, n2);
    }

    private void inserIntoRegionArray(int k) {
        regionArray = new regInfo[k + 1];
        for (vistorInfo v : visitors) {
            int indexOfRegion = v.getRegion();
            if (regionArray[indexOfRegion] != null)
                regionArray[indexOfRegion].insertIntoRegInfo(v);
            else {
                regionArray[indexOfRegion] = new regInfo(v.getRegion());
                regionArray[indexOfRegion].insertIntoRegInfo(v);
                numOfregions++;
            }
        }

    }

    private void createAndCopyIntoRegSortedArray() {
        regSortedArray = new regInfo[numOfregions];
        int j = 0;
        for (int i = 0; i < regionArray.length; i++) {
            if (regionArray[i] != null)
                regSortedArray[j++] = regionArray[i];
        }

    }

    private void sortRegions(regInfo[] regSortedArray) {
        mergeSort m = new mergeSort();
        m.sort(regSortedArray);
    }

    private boolean printReasonVIP(vistorInfo vistor1, vistorInfo vistor2, String n1, String n2) {
        boolean flag = false;
        if (vistor1 == null)
            System.out.println("The given number is not VIP vistor: " + n1);
        else if (vistor2 == null)
            System.out.println("The given number is not VIP vistor: " + n2);
        else if (vistor1.getRegion() != vistor2.getRegion())
            System.out.println("The two vistor are not from the same region");
        else if (vistor1.getLocation() != vistor2.getLocation())
            System.out.println("The two vistor are not in the same Kingdom");
        else
            flag = true;
        return flag;
    }

    private boolean printReasonReg(vistorInfo vistor1, vistorInfo vistor2, String n1, String n2) {
        boolean flag = false;
        if (vistor1 == null)
            System.out.println("The given number is not regular vistor: " + n1);
        else if (vistor2 == null)
            System.out.println("The given number is not regular vistor: " + n2);
        else if (vistor1.getRegion() != vistor2.getRegion())
            System.out.println("The two vistor are not from the same region");
        else if (vistor1.getOrder().sameOrder(vistor2.getOrder()))
            System.out.println("The two vistor did not visit the kingdoms in the same order");
        else
            flag = true;
        return flag;
    }

}
