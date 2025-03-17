import java.io.*;
import java.util.ArrayList;

class LotteryNumbers{
    ArrayList<ArrayList<Integer>> pb;
    LotteryNumbers(){
        pb = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1); temp.add(2); temp.add(3); temp.add(4);
        temp.add(5);
        InputStream is =
                this.getClass().getResourceAsStream("powerballNumbers.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        int counter = 0;
        while(true) {
            try {
                if ((line = br.readLine()) == null) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String[] strings = line.split("\t");
            for (int i=0;i<5;++i) {
                temp.set(i,Integer.parseInt(strings[i]));
    //do what you need with the Integer
            }
            pb.add((ArrayList<Integer>) temp.clone());
        }
    // Run your selection sort here (you will need to write the method laterdown below)
        selSort();
    // COMMENT THIS OUT AFTER YOU ARE SURE NUMBERS ARE BRING READ IN
        System.out.println("Read in "+pb.size()+ " different lottery draws");
        System.out.println("First 5 draws (sorted)");
        for (int i=0;i<5;++i) {
            System.out.print("[");
            for (int j = 0; j < 5; ++j) {
                System.out.print(String.format("%-2d", pb.get(i).get(j)) + " ");
            }
            System.out.println("\b]");
        }
        System.out.println("Last 5 draws (sorted)");
        for (int i=pb.size()-5;i<pb.size();++i) {
            System.out.print("[");
            for (int j = 0; j < 5; ++j) {
                System.out.print(String.format("%-2d", pb.get(i).get(j)) + " ");
            }
            System.out.println("\b]");
        }
    }
        //return 0 if the two arraylists are the same
    //return -1 if the first arraylist is less than the second
    //return 1 if the first arraylist is greater than the second
        public int compareArrayList(ArrayList<Integer> first, ArrayList<Integer> second){
        //put implementation here

            for(int i=0;i<first.size();i++){
                if(first.get(i)<second.get(i)){
                    return -1;
                }
                else if(first.get(i)>second.get(i)){
                    return 1;
                }
            }

            return 0;
        }

        public void selSort(){
        //implement a selection sort for arraylists here
            for(int i=0;i<pb.size()-1;i++){
                int min=i;
                for(int j = i + 1; j < pb.size(); j++){
                    if (compareArrayList(pb.get(j), pb.get(min)) < 0){
                        min=j;
                    }
                }
                ArrayList<Integer> temp = pb.get(min);
                pb.set(min,pb.get(i));
                pb.set(i,temp);
            }
        }

        public int binarySearch(ArrayList<Integer> findThis){
            //implement a binary search on array lists here
            int firstIndex=0;
            int lastIndex=pb.size()-1;
            while(firstIndex<=lastIndex){
                int middle=(firstIndex+lastIndex)/2;
                int compare=compareArrayList(pb.get(middle),findThis);

                if(compare==0){
                    return middle;
                }
                else if(compare<0){
                    firstIndex=middle+1;
                }
                else{
                    lastIndex=middle-1;
                }
            }
            return -1;
        }

}
