import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class DataHandler {
    private ArrayList<FifaData> data;
    public final static int ASC = 0;
    public final static int DESC = 0;

    public DataHandler(String filePath) throws FileNotFoundException {
        File arquivo = new File(filePath);
        Scanner scanner = new Scanner(arquivo);
        scanner.useDelimiter("\n");
        this.data = new ArrayList<FifaData>();
        scanner.next();
        while (scanner.hasNext()) {
            String[] data = scanner.next().split(",");
            this.data.add(new FifaData(data[0], data[1], Double.parseDouble(data[2]), Double.parseDouble(data[3]),
                    Double.parseDouble(data[4])));
        }
        scanner.close();
    }

    public void sortByCountryName() {
        FifaData.mergeSort(this.data, 0, this.data.size() - 1, FifaData.COUNTRY_NAME);
    }

    public void sortByAudience() {
        FifaData.mergeSort(this.data, 0, this.data.size() - 1, FifaData.AUDIENCE);
    }

    private void printHeader() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("     \t%-30s\t%-20s\t%20s\t%20s\t%25s\n", "COUNTRY", "BODY", "GLOBAL POPULATION",
                "WORLD CUP TV AUDIENCE", "GDP-WEIGHTED AUDIENCE");
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void print() {
        int index = 0;
        this.printHeader();
        for (FifaData s : this.data)
            System.out.printf("%-5d\t%-30s\t%-20s\t%20.2f %%\t%20.2f %%\t%25.2f %%\n", ++index,
                    s.getCountry(),
                    s.getConfederation(),
                    s.getPopulationShare(), s.getTvAudienceShare(), s.getGdpWeightedShare());
    }

}