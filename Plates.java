/**
 * Created by stasa on 30.9.16..
 */


import java.util.Comparator;
import java.util.Arrays;

public class Plates {
    /*
       Ideja:
       Sortiramo tanjire opadajuce po zbiru profit + lose, zatim
       operemo prvih k a ostale ne. Korektnost ovog pristupa moze
       da se dokaze tako sto posmatramo neka dva tanjira i pitamo se
       koji od njih da operemo i kolika je razlika u profitu ako operemo
       jedan umesto drugog.
    */
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
        // Kada compare vrati negtivnu vrednost ili 0 ne radi se zamena
        // a kada vrati pozitivnu radi se zamena
        public int compare(plate a, plate b )
        {
            return (a.profit + a.lose) < (b.profit + b.lose) ? 1 : -1 ;
            // return - a.profit - a.lose + b.profit + b.lose;
        }

    }

    // pretpostavlja se da je 0 <= k <= n
    static int calculate(plate[] plates, int k){

        int profit = 0;

        // Sortira se niz u opadajućem poretku po zbiru dobiak + lose;
        Arrays.sort( plates, new compareBySumProfitAndLose() );

        for (int i=0; i < plates.length; i++){
            profit += i < k ? plates[i].profit : - plates[i].lose;
        }

        return profit;
    }

    public static void main(String[] args)
    {
        // n tanjira
        int n = 4;

        // k broj tanjira kojih treba oprati da bi se najvise zaradilo
        int k = 2;

        plate[] plates = new plate[n];

        plates[0] = new plate(32, 5);
        plates[1] = new plate(15, 40);
        plates[2] = new plate(4, 3);
        plates[3] = new plate(32, 7);

        System.out.println( "Maximum profit is " + calculate(plates, k) );

        System.out.println();
        System.out.println();


        for (int i=0; i < plates.length; i++){
            System.out.println( plates[i].profit + " " + plates[i].lose);
        }


    }


}

