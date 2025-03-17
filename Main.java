//importing arraylist and user input
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //asking user to enter some numbers
        DataSet data = new DataSet();
        System.out.println("Enter numbers(NON-NEGATIVES) for Dataset(Enter -1 to end): ");
        while (true){
            int input = scanner.nextInt();
            if(input ==-1){
                break;
            }
            data.addData(input);
        }

        // Print DataSet statistics
        System.out.println("Mean: " + data.getMean());
        System.out.println("Median: " + data.getMedian());
        System.out.println("Mode: " + data.getMode());
        System.out.println("Standard Deviation: " + data.getStandardDeviation());

        //run the lottery numbers
        LotteryNumbers lottery = new LotteryNumbers();
        int draws=0;

        while(true){
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<5;i++){
                list.add( (int) (Math.random() * 69) +1);
            }

            draws++;
            if(lottery.binarySearch(list)!=-1){
                System.out.println("The winner has won in " + draws + " draws.");
                break;

            }


        }
        scanner.close();
    }
}
