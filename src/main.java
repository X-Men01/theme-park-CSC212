package src;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ThemeParkADT park = new ThemeParkADT();
        park.readFileAndAnalyse("info.txt");


        park.searchVisitor("AlAli");
        System.out.println("**************************************************************");
        park.rgnCount();
        System.out.println("**************************************************************");
        park.popularRgn();
        System.out.println("**************************************************************");
        park.vipRgn(1);
        System.out.println("**************************************************************");
        park.vipLocation();
        System.out.println("**************************************************************");
        System.out.println(park.checkVipLoc("0555555555", "0544444444"));
        System.out.println("**************************************************************");
        System.out.println(park.checkVipLoc("0555555555", "0504000000"));
        System.out.println("**************************************************************");
        System.out.println(park.checkVipLoc("0511111111", "0512211122"));
    }
}