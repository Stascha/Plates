/** Created by Stasa on 30.9.16..**/

import java.util.Comparator;
import java.util.Arrays;

public class Plates {
   
    static class plate
    {
        int profit;
        int lose;

        plate(){
            profit = 0;
            lose = 0;
        }

        plate(int profit, int lose){
            this.profit = profit;
            this.lose = lose;
        }

    }

    static class compareBySumProfitAndLose implements Comparator<plate>
    {
        public int compare(plate a, plate b )
        {
            return (a.profit + a.lose) < (b.profit + b.lose) ? 1 : -1 ;
            // return - a.profit - a.lose + b.profit + b.lose;
        }
    }

   static int calculate(plate[] plates, int k){

        int profit = 0;

        Arrays.sort( plates, new compareBySumProfitAndLose() );

        for (int i=0; i < plates.length; i++){
            profit += i < k ? plates[i].profit : - plates[i].lose;
        }

        return profit;
    }

    public static void main(String[] args)
    {
        // number of plates
        int n = 4;

        // number of plates that can be cleaned
        int k = 2;

        plate[] plates = new plate[n];

        plates[0] = new plate(32, 5);
        plates[1] = new plate(15, 40);
        plates[2] = new plate(4, 3);
        plates[3] = new plate(32, 7);

        System.out.println( "Maximum profit is " + calculate(plates, k) );

    }


}

