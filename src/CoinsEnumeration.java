import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CoinsEnumeration {
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

        boolean big = false;
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

        if (sum > temp / 15) {
            big = true;
        }

        ArrayList<Boolean> booleans = new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            if (big)
                booleans.add(true);
            if (!big)
                booleans.add(false);
        }

        boolean doit = true;

        while (doit) {
            temp = 0;
            for (int i = 0; i < list.size(); i++) {
                if (booleans.get(i)) {
                    temp += list.get(i);
                }
            }
            if (temp != sum) {
                boolean res = plusOne(booleans, big);
                if (res) {
                    doit = false;
                }

            } else {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }

    private static boolean plusOne(ArrayList<Boolean> booleans, boolean big) {
        boolean itzero = true;
        int pos = 0;
        while (itzero) {
            if (pos == booleans.size()) {
                return true;
            }
            if (booleans.get(pos) == big) {
                booleans.set(pos, !big);
                for (int i = 0; i < pos; i++) {
                    booleans.set(i, big);
                }
                itzero = false;
            } else {
                pos++;
            }
        }
        return false;
    }
}