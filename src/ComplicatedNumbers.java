import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class ComplicatedNumbers {
    public static void main(String[] args) {
        System.out.println();
        HashSet<Long> set = new HashSet();
        long max = 199999;
        double res;
        long res_L = 0;
        for (int i = 1; i < max; i++) {
            int s = sumFigures(i);
            res = (3* (double)i)/((double)(s*s));
            res_L = (3*i)/(s*s);
            if (res == res_L) {
                set.add(res_L);
            }
        }
       ArrayList<Long> arrayList = new ArrayList<>(set);
        Collections.sort(arrayList);
        long prev = 0;
        for (long o : arrayList) {
            if (o != prev+1) {
                System.out.println(prev+1);
                break;
            }
            prev = o;
        }
    }

    private static int sumFigures(int i) {
        String iString = String.valueOf(i);
        String [] figures = iString.split("");
        int sum = 0;
        for (String figure : figures) {
            sum += Integer.parseInt(figure);
        }
        return sum;
    }
}
