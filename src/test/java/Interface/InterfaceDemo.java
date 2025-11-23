package Interface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public interface InterfaceDemo extends InterfaceParent, WebDriver {
    interface run {
        public void run(String path, int km);
        //WebDriver driver = new ChromeDriver();
    }


}
