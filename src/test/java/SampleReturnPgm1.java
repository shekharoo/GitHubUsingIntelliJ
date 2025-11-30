import java.util.Arrays;

public class SampleReturnPgm1 {

    public static int[] returnPgm(int[] a)
    {
        int[] ar={};
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length;j++)
            {
                if(a[i]==4){
                    System.out.println("Array pgm");
                    //return new int[]{i};
                    //return new int[]{i};
                    return new int[]{i, j};
            }
            }
        }
        return ar;
        //return new int[]{};
    }

    public static void main(String[] args) {
        int[] a = SampleReturnPgm1.returnPgm(new int[]{1,4,5});
        System.out.println(Arrays.toString(a));
        //System.out.println(a);
    }
}
