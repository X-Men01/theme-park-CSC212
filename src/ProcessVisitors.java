package src;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProcessVisitors {
    private final int maxNumberOfKingdoms = 4;
    private Pattern regexVistor = Pattern
            .compile("(?<fName>[^,]*),(?<lName>[^,]*),(?<region>\\d),(?<type>\\d),(?<phone>\\d{10}),(?<order>[0-9,]*)");
    private Matcher mat;
    private Scanner sc;
    private File file;

    private vistorInfo readAndCreatVistor(String nextLine) {
        mat = regexVistor.matcher(nextLine);

        if (!mat.find())
            return null;

        String fistName = mat.group("fName");
        String lastName = mat.group("lName");
        int region = Integer.parseInt(mat.group("region"));
        int type = Integer.parseInt(mat.group("type"));
        String phone = mat.group("phone");
        String order = mat.group("order");

        ArrayStack<Integer> orderOfRegion = new ArrayStack<>(maxNumberOfKingdoms);
        inserIntoOrder(order, orderOfRegion);
        return new vistorInfo(fistName, lastName, phone, region, type, orderOfRegion);
    }

    public boolean openAndCreateFile(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        if (!file.exists()) {
            return false;
        }

        sc = new Scanner(file);

        return true;
    }

    public boolean hasNextVistor() {
        return sc.hasNextLine() ? true : false;
    }

    public String nextVistor() {
        return sc.nextLine();
    }

    public vistorInfo CreatVistor() {
        if (sc.hasNextLine())
            return readAndCreatVistor(sc.nextLine());

        return null;
    }

    private void inserIntoOrder(String orderOfRegion, ArrayStack<Integer> order) {
        for (char c : orderOfRegion.toCharArray())
            if (c != ',') {
                Integer kingdom = Integer.parseInt(String.valueOf(c));
                order.push(kingdom);
            }

    }

}
