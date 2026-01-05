package SeleniumFiles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BrokenLinksSelenium {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.magadhonline.com/");
        HttpURLConnection con=(HttpURLConnection)url.openConnection();
//        if(con.getResponseCode()==200)
//        {
//
//        }
        int code=con.getResponseCode();
        System.out.println("Response code is: "+code);

        String msg = con.getResponseMessage();
        System.out.println("Response message is: "+msg);

    }
}
