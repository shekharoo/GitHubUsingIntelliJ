import java.util.Arrays;

public class ArraysClass {
    static int a = 10;
    int b = 10;
    ArraysClass()
    {
        System.out.println("This is constructor body");
    }

    public static void main(String[] args) {
        ArraysClass ac = new ArraysClass();
        //super.b;
//        int[] ar  = new int[]{1,2,3,4,5,8,7,9,4};
//        int[] ar1 = {1,2,3,4,5,8,7,9,4};
//
//        for(int i=0;i<ar.length;i++)
//        {
//            for(int j=0;j<i;j++)
//            {
//                System.out.print(ar[j]+",");
//            }
//
//        }

        //Generate random strings
//        Random r = new Random();
//        int randata=r.nextInt(1000000000);
//        System.out.println("Ran data: "+randata);
//        StringBuilder sb = new StringBuilder();
//        String str = "AaBcCcDd"+"0123456789";
//        String str1 = "";
//        int strLen = str.length();
////        for(int i=0;i<strLen;i++)
////        {
////            int index = (int)((int)strLen*Math.random());
////            sb.append(str.charAt(index));
////        }
//        //System.out.println((int)(strLen*Math.random()));
//        for(int i=0;i<str.length();i++)
//        {
//            int index = (int) (strLen * Math.random());
//            str1 = str.charAt(index)+str1;
//        }
//        //System.out.println(sb);
//        System.out.println(str1);
//        Map<String,Integer> map = new HashMap<>();
//        char[] ar = {'A','B','c','d'};
//        List<char[]> li = java.util.Arrays.asList(ar);
//        for(int i=0;i<li.size();i++)
//        {
//            System.out.println(li.get(i));
//        }
        //System.out.println("List is: "+li.get(1));

//        int[][] ar={{1,2,3,4,5},{6,7,8,9,1}};
//        System.out.println(Arrays.deepToString(ar));
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] row : matrix) { // Enhanced for loop to iterate through rows
            System.out.println(Arrays.toString(row));
        }
    }
}
