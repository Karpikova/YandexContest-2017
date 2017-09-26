import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Coins {
    static boolean result;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String countStr = in.nextLine();
        String[] numbersString = in.nextLine().split(" ");
        String sumStr = in.nextLine();
        int sum = Integer.parseInt(sumStr);
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : numbersString) {
            list.add(Integer.parseInt(s));
        }
        Collections.sort(list);

        int max = list.size() - 1;
        sum -= list.get(max);
        list.remove(max);
        if (sum == 0) {
            System.out.println("Yes");
            return;
        }
        if (sum < 0) {
            System.out.println("No");
            return;
        }

        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
        }

        if (sum > temp) {
            System.out.println("No");
            return;
        }
        if (sum == temp) {
            System.out.println("Yes");
            return;
        }

        int count = list.size();
        boolean res = false;
        for (int i = 0; i < count; i++) {
            recur(sum, list, count-i-1);
        }
        if (result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static void recur(int sum, ArrayList<Integer> list, int count) {
        int max_val = list.get(count);
        if (max_val == sum) {
            result = true;
            return;
        }
        if (count == 0) {
            return;
        }
        if (max_val < sum) {
            for (int i = 0; i < count; i++) {
                recur(sum-max_val, list, count-i-1);
            }
        }
        if (max_val > sum) {
            recur(sum, list, count-1);
        }
    }

}