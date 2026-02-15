package IBM_String_JavaPgms;

public class MaskSensitiveDatainString {
    /**
     * 9876543210 → ******3210
     */

    public static void maskData(String s)
    {
        int visibleDigit=4;
        StringBuilder sbMasked=new StringBuilder();
        int maskedLength=s.length()-visibleDigit;
        System.out.println("Masked length: "+maskedLength);
        for(int i=0;i<maskedLength;i++)
        {
            sbMasked.append("*");
        }
        System.out.println(sbMasked);
        //System.out.println("Masked String is: "+sbMasked);
        //Now append visible digit with masked String
        System.out.println(s.substring(maskedLength));
        sbMasked.append(s.substring(maskedLength));
        System.out.println("Masked String is: "+sbMasked);
    }

    public static void main(String[] args) {
        MaskSensitiveDatainString.maskData("6203856861");
    }
}
