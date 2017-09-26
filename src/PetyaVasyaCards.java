import java.util.Scanner;

public class PetyaVasyaCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String countStr = in.nextLine();

        String[] numbersString = in.nextLine().split(" ");

        long Petya = 0;
        long Vasya = 0;

        int PetyasCard = 0;
        int VasyasCard = 0;

        for (int i = 0; i < numbersString.length; i++) {
            int cur = Integer.parseInt(numbersString[i]);
            if (i % 3 == 2) {
                if (PetyasCard < VasyasCard) {
                    Petya += cur;
                } else {
                    Vasya += cur;
                }
            } else if (i % 3 == 0) {
                Petya += cur;
                PetyasCard = cur;
            } else {
                Vasya += cur;
                VasyasCard = cur;
            }
        }

        if (Petya > Vasya) {
            System.out.println("Petya");
        } else {
            System.out.println("Vasya");
        }

    }
}
