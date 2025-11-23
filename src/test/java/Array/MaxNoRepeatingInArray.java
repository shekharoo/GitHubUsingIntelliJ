package Array;

public class MaxNoRepeatingInArray {

    public static void main(String[] args) {
        int[] ar={1,1,0,1,1,1,};

        for(int i=0;i<ar.length;i++)
        {
            int count = 0;
            for(int j=i+1;j<ar.length;j++)
            {
                if(ar[i]==ar[j])
                {
                    count++;
                }
            }

            if(count==3)
            {
                System.out.println("Element is: "+ar[i]+" and count is: "+count );
            }
        }

    }
}
