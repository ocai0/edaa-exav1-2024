import java.util.ArrayList;

class FifaData {
    private String country;

    public String getCountry() {
        return country;
    }

    private String confederation;

    public String getConfederation() {
        return confederation;
    }

    private double populationShare;

    public double getPopulationShare() {
        return populationShare;
    }

    private double tvAudienceShare;

    public double getTvAudienceShare() {
        return tvAudienceShare;
    }

    private double gdpWeightedShare;

    public double getGdpWeightedShare() {
        return gdpWeightedShare;
    }

    public final static int COUNTRY_NAME = 0;
    public final static int AUDIENCE = 1;

    public FifaData(String country, String confederation, double populationShare, double tvAudienceShare,
            double gdpWeightedShare) {
        this.country = country;
        this.confederation = confederation;
        this.populationShare = populationShare;
        this.tvAudienceShare = tvAudienceShare;
        this.gdpWeightedShare = gdpWeightedShare;
    }

    public static void mergeSort(ArrayList<FifaData> vector, int start, int end, int type) {
        if (start >= end)
            return;
        int middle = (start + end) / 2;
        FifaData.mergeSort(vector, start, middle, type);
        FifaData.mergeSort(vector, middle + 1, end, type);
        switch (type) {
            case FifaData.COUNTRY_NAME:
                FifaData.combineByCountry(vector, start, middle, end);

                break;

            case FifaData.AUDIENCE:
                FifaData.combineByAudience(vector, start, middle, end);
                break;
        }
    }

    private static void combineByCountry(ArrayList<FifaData> vector, int start, int middle, int end) {
        ArrayList<FifaData> temp = new ArrayList<FifaData>();
        for (int index = 0; index <= end; index++)
            temp.add(vector.get(index));
        int leftSubArrayIndex = start;
        int rightSubArrayIndex = middle + 1;
        for (int index = start; index <= end; index++) {
            if (leftSubArrayIndex > middle) {
                vector.set(index, temp.get(rightSubArrayIndex++));
                continue;
            }
            if (rightSubArrayIndex > end) {
                vector.set(index, temp.get(leftSubArrayIndex++));
                continue;
            }
            if (temp.get(leftSubArrayIndex).getCountry()
                    .compareToIgnoreCase(temp.get(rightSubArrayIndex).getCountry()) < 0)
                vector.set(index, temp.get(leftSubArrayIndex++));
            else
                vector.set(index, temp.get(rightSubArrayIndex++));
        }
    }

    private static void combineByAudience(ArrayList<FifaData> vector, int start, int middle, int end) {
        ArrayList<FifaData> temp = new ArrayList<FifaData>();
        for (int index = 0; index <= end; index++)
            temp.add(vector.get(index));
        int leftSubArrayIndex = start;
        int rightSubArrayIndex = middle + 1;
        for (int index = start; index <= end; index++) {
            if (leftSubArrayIndex > middle) {
                vector.set(index, temp.get(rightSubArrayIndex++));
                continue;
            }
            if (rightSubArrayIndex > end) {
                vector.set(index, temp.get(leftSubArrayIndex++));
                continue;
            }
            if (temp.get(leftSubArrayIndex).getTvAudienceShare() < temp.get(rightSubArrayIndex).getTvAudienceShare())
                vector.set(index, temp.get(leftSubArrayIndex++));
            else
                vector.set(index, temp.get(rightSubArrayIndex++));
        }
    }
}