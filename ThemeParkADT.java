import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ThemeParkADT {
    private regInfo[] regionArray , regSortedArray;
    private LinkedList<vistorInfo> visitors, vips;
    private int numOfregions;

    private Pattern regexVistor = Pattern.compile("(?<fName>[^,]*),(?<lName>[^,]*),(?<region>\\d),(?<type>\\d),(?<phone>\\d{10}),(?<order>[0-9,]*)");

    public ThemeParkADT(int k , int r) {
        regionArray = new regInfo[k];
        regSortedArray = new regInfo[r];
        vips = new LinkedList<>();
        visitors = new LinkedList<>();
    }
    public  void readFileAndAnalyse(String f) throws FileNotFoundException{
		File file = openAndCreateFile(f);
		if(file == null){
            System.out.println("The file does not exist");
            return;
        }
        
		Scanner sc = new Scanner(file);

        while(sc.hasNextLine()){
            vistorInfo newVistor = readAndCreatVistor(sc.nextLine());
            visitors.insert(newVistor);

            if(newVistor.isVip())
                 vips.insert(newVistor);

        }	

    }

    private vistorInfo readAndCreatVistor(String nextLine) {
        Matcher mat = regexVistor.matcher(nextLine);

        if(!mat.find())
            return null;

        String fistName = mat.group("fName");   
        String lastName = mat.group("lName");
        int region = Integer.parseInt(mat.group("region"));
        int type = Integer.parseInt(mat.group("type"));
        String phone = mat.group("phone"); 
        String order = mat.group("order");


       return  new vistorInfo(fistName, lastName, phone, region, type, order);
    }
    private File openAndCreateFile(String fileName) {
        File file = new File(fileName);        
        return file.exists() ? file: null;
    }

    public void printVisitor(){
        visitors.print();
    }
    public void printVIP(){
        vips.print();
    }
    
}
