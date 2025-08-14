package nizi.zadaci;

import nizi.Array;

public class NajdolgaPodniza {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(10);
        int[] nums = {2, 5, 3 ,7, 11, 8, 10, 13, 6};

        for(int i = 0; i < nums.length; i++){
            arr.insertLast(nums[i]);
        }
        findLongestIncrSubarray(arr);
    }

    public static void findLongestIncrSubarray(Array<Integer> arr){
        int maxLen = 1;
        int currentLen = 1;
        int startIndex = 0;
        int bestStartIndex = 0;

        for(int i = 1; i < arr.getSize(); i++){
            if(arr.get(i) > arr.get(i-1)){
                currentLen++;
                if(currentLen > maxLen){
                    maxLen = currentLen;
                    bestStartIndex = startIndex;
                }
            }
            else{
                currentLen = 1;
                startIndex = i;
            }
        }

        // pecatenje rezultat
        System.out.print("Najdolga rastecka podniza: {");
        for(int i = bestStartIndex; i < bestStartIndex + maxLen; i++){
            System.out.print(arr.get(i));
            if(i < bestStartIndex + maxLen - 1){
                System.out.print(", ");
            }
        }
        System.out.print("}");
        System.out.println();
        System.out.println("Dolzina " + maxLen);
    }

}
