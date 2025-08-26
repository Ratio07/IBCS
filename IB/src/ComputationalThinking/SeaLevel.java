package ComputationalThinking;

public class SeaLevel {

    public static void main(String[] args) {
        System.out.println(yearCalculation(1000000, 1000000));
    }

    public static int yearCalculation(int initialSeaIce, int initialOpenOcean){
        int count = 2019;
        double AreaOO = initialOpenOcean;
        double AreaSI = initialSeaIce;
        double abSeaIce = 0.6;
        double abOpenOcean = 0.1;
        double averageAl = 0;
        while(AreaSI>=10000) {
            averageAl = ((AreaSI * abSeaIce) + (AreaOO * abOpenOcean)) / (AreaOO + AreaSI);
            double changeSI = 0.3 / Math.pow(averageAl,2);
            AreaSI *= (100-changeSI)/100;
            AreaOO += (100-changeSI)/100;
            count += 2;
        }
        return count;
    }
}
