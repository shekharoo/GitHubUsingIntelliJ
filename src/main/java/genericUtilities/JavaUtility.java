package genericUtilities;

import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
    public static String generateCampaignName()
    {
        //Generate random strings
//        Random r = new Random();
//        StringBuilder sb = new StringBuilder();
//        String s = "Campaign_";
//        String s1 = "5284";
//        int strLen = s.length();
//        for(int i=0;i<strLen;i++)
//        {
//            int index = (int)((int)strLen*Math.random());
//            //s+sb.append(s.charAt(index));
//            s+s1.charAt(index);
//        }

        Random r = new Random();
        String s = "Campaign_";
        //String s1 = "5284";
        //int strLen = s1.length();
        //Random r = new Random();
        //int = r.nextInt();
        //Math.random();
        //int index = (int) strLen*Math.random();
        String a = String.valueOf(r.nextInt(999));
        String campaignName = s + a;
        //String final = s+a;

        return campaignName;
        }

    public static String generateOrganizationName()
    {
        //Generate random strings
        Random r = new Random();
        String s = "Qspiders_";
        String s1 = String.valueOf(r.nextInt(999));
        return s+s1;
    }
    public static StringBuilder generateRandomMobileNo()
    {
        //Generate random strings
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        String str = "0123456789";
        int strLen = str.length();
        for(int i=0;i<strLen;i++)
        {
            int index = (int)((int)strLen*Math.random());
            sb.append(str.charAt(index));
        }
        return sb;
    }
    public static String extractTextFromPopUp(WebElement ele, String flowName)
    {
        String[] splitString = ele.getText().split(" ");
        String[] String;
        System.out.println(flowName+":"+splitString[1]+" is sucessfully created");
        return splitString[1];
    }
    public static String getCurrentDate() throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String systemDate = sdf.format(date);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(systemDate));
        c.add(Calendar.DATE,1);
        String currDate = sdf.format(c.getTime());
        //String currDate = c.getTime().toString();

        return currDate;
    }

    public static void main(String[] args) throws ParseException {
       //String orgName= JavaUtility.generateOrganizationName();
        String campName=JavaUtility.generateCampaignName();
        //System.out.println(orgName);
        System.out.println(campName);
    }

}
