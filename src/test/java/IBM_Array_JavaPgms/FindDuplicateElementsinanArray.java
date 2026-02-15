package IBM_Array_JavaPgms;

public class FindDuplicateElementsinanArray {
    /***
     * Input: [1, 2, 3, 4, 2, 5, 1]
     * Output: 1, 2
     */
    public static void main(String[] args) {
        int[] ar={1, 2, 3, 4, 2, 5, 1};
        for(int i=0;i<ar.length;i++)
        {
            for(int j=i+1;j<ar.length;j++)
            {
                if(ar[i]==ar[j])
                {
                    System.out.println(ar[i]);
                }

            }
        }
    }
}
