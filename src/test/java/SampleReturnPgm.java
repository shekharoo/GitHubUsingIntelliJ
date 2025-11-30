import java.util.Arrays;

public class SampleReturnPgm {

    public static int returnPgm(int[] a)
    {
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==4){
                System.out.println("Array pgm");
                //return a[i];
                //return new int[]{i};
                return 15;
            }

        }
        //return new int[]{};
        //return new int[]{};
        return  2;
    }

    public static void main(String[] args) {
        int a = SampleReturnPgm.returnPgm(new int[]{1,4,5});
       // System.out.println(Arrays.toString(a));
        System.out.println(a);
    }
}
