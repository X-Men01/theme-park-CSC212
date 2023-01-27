import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {

        ThemeParkADT park = new ThemeParkADT(10);
        park.readFileAndAnalyse("/Users/ahmedalkhulayfi/Desktop/into.txt");

        park.searchVisitor("AlAli");
        System.out.println("**************************************************************");
        System.out.println("**************************************************************");
        park.rgnCount();
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