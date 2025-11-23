import java.util.Arrays;

public class SecondLargestNoArray {

    public static int secondLargest(int[] ar)
    {
        int largest = 1;
        int temp = 0;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i]>largest)
            {
                temp = ar[i];
                largest = temp;
            }
        }
        //Now sort the array
        Arrays.sort(ar);
//        for(int i=ar.length;i>0;i--)
//        {
//            temp = ar[i-1];
//        }
        return ar[(ar.length)
                -2];
    }
    public static void main(String[] args) {
        int[] ar  = new int[]{1,2,3,4,5,8,7,9,4};
        int a = SecondLargestNoArray.secondLargest(ar);
        System.out.println("Largest is: "+a);

    }
}
