import java.util.Random;

public class LotterySimple {
    public static void main(String[] args) {
        int pick1, pick2, win1, win2;
        int count = 0;
        int totalCount = 0;
        int totalWins = 10;
        int copyOfTotalWins = totalWins;

        Random g = new Random();

        while (totalWins > 0) {
            count = 0;
            do {
                count++;
                pick1 = g.nextInt(20);
                pick2 = g.nextInt(20);


                System.out.println("you have chosen " + pick1 + " " + pick2);

                win1 = g.nextInt(21);
                win2 = g.nextInt(21);
                System.out.println("winning numbers are " + win1 + " " + win2);


                if ((pick1 == win1) && (pick2 == win2)) {
                    System.out.println("you win");
                    break;
                } else
                    System.out.println("you lose");
            } while (true);

            totalCount += count;
            System.out.println("the game has played " + count + " times for a win");
            totalWins--;
        }

        double avg = totalCount / copyOfTotalWins;
        System.out.println("after " + copyOfTotalWins + " wins, the average number of games for a win = " +
                avg);

        System.exit(0);
    }
}