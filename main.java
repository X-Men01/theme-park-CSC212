import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException {
        ThemeParkADT park = new ThemeParkADT(2, 2);
        park.readFileAndAnalyse("/Users/ahmedalkhulayfi/Desktop/into.txt");
        park.printVIP();
        park.printVisitor();
}
}