import java.util.Arrays;
import java.util.HashMap;

public class TwoNumberSum {
    public int[] twoNumberSumSolution1(int[] array, int targetSum) {
        Arrays.sort(array);
        int left=0;
        int right=array.length-1;
        while(left<right){
            int currentSum=array[left]+array[right];
            if(currentSum==targetSum){
                return new int[] {array[left], array[right]};
            }
            else if(currentSum<targetSum){
                left++;
            }else {
                right--;
            }

        }
        return new int[0];
    }

    public int[] twoNumberSumSolution2(int [] array, int targetSum){
        for(int index=0;index<array.length-1;index++){
            int firstNum = array[index];
            for (int nextIndex = index+1; nextIndex < array.length; nextIndex++) {
                int secondNum=array[nextIndex];
                int currentSum=firstNum+secondNum;
                if(currentSum==targetSum){
                    return new int[] {firstNum,secondNum};
                }
            }
        }
        return new int[0];
    }


    public int[] twoNumberSumSolution3(int [] array, int targetSum){
        HashMap<Integer,Boolean> dataStore = new HashMap<Integer, Boolean>();
        for(Integer number : array){
            int potentialMatch=targetSum-number;
            if(dataStore.containsKey(potentialMatch)){
                return new int[]{potentialMatch,number};
            }else{
                dataStore.put(number,Boolean.TRUE);
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
       TwoNumberSum test= new TwoNumberSum();
       int [] output=test.twoNumberSumSolution1(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output));
        int [] output1=test.twoNumberSumSolution2(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output1));
        int [] output2=test.twoNumberSumSolution3(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output2));
    }
}

