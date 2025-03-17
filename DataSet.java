import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {

    private ArrayList<Integer> nums;// list to store the user input numbers

    //constructor
    public DataSet(){
        nums = new ArrayList<>();
    }

    //to add non-negative integers to the list
    public void addData(int value){
        if( value>=0){
            nums.add(value);
        }
    }

    //this is to sort the nums in order from leats to greatest, makes finding the median easier
    public void selectionSort(){
        for(int i =0; i<nums.size()-1;i++){
            int min =i;
            for(int j=i+1;j<nums.size();j++){
                if(nums.get(j) < nums.get(min)){
                    min=j;
                }
            }
            //swaps the smallest elemtn with the first unsorted element
            int temp = nums.get(min);
            nums.set(min,nums.get(i));
            nums.set(i,temp);
        }
    }

    //to find the mean of the set
    public double getMean(){
        double sum=0;
        for( int n: nums){
            sum+=n;
        }
        return sum/nums.size();
    }

    //to find the median of the set
    public double getMedian(){
        selectionSort();
        int middle = nums.size()/2;
        if(nums.size()%2==0){
            return(nums.get(middle-1)+ nums.get(middle))/2.0;
        }
        else{
            return nums.get(middle);
        }
    }

    //to find the mode of the set
    public int getMode(){
        int maxNum=0;
        int maxCount=0;

        for(int i=0;i<nums.size();i++){
           int count=0;
           for(int j=0;j<nums.size();j++){
               if(nums.get(j).equals(nums.get(i))) {
                   count++;
               }
           }
           if(count>maxCount){
               maxCount=count;
               maxNum = nums.get(i);
           }
        }
        return maxNum;
    }

    public double getStandardDeviation(){
        double mean=getMean();
        double sum=0;

        for(int n: nums){
            sum+=Math.pow(n-mean,2);
        }
        return Math.sqrt(sum/nums.size());
    }

}
