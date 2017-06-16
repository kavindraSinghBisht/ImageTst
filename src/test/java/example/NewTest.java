package example;

import java.io.File;
import java.sql.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class NewTest {

	@Test
	public static void main() throws InterruptedException {
		System.out.println("Start");

//		 System.setProperty("webdriver.chrome.driver", File.separator +
//		 "Users"
//		 + File.separator + "Shared" + File.separator
//		 + "Jenkins" + File.separator + "Home" + File.separator
//		 + "workspace" + File.separator + "ankit"+ File.separator + "driver"+
//		 File.separator + "chromedriver");

		System.setProperty("webdriver.chrome.driver","/var/lib/jenkins/workspace/ImageTestServer1/Driver/chromedriver_64");
	    DesiredCapabilities capabilities=DesiredCapabilities.chrome();
	    capabilities.setCapability("marionette", true);

//		ChromeDriverManager.getInstance().setup();
		 
		ChromeDriver driver = new ChromeDriver();
		// check for server image
		Thread.sleep(4000L);
		driver.get("https://image.tripotoo.com/image/generate/ss/img/403189/TripDocument/1497424269_img_8.jpg");
		Thread.sleep(4000L);
		LogEntries logs = driver.manage().logs().get("browser");
		if (logs.getAll().size() > 0) {
			for (LogEntry entry : logs) {
				System.out.println(new Date(entry.getTimestamp()) + " "
						+ entry.getLevel() + " " + entry.getMessage());
			}
			// ======error found===
			// check for original image

			driver.get("https://stagingimage.tripotoo.com/media/transfer/img/30914/TripDocument/1497341053_dsc_0075.jpg");
			Thread.sleep(4000L);
			LogEntries logs1 = driver.manage().logs().get("browser");
			for (LogEntry entry : logs1) {
				System.out.println(new Date(entry.getTimestamp()) + " "
						+ entry.getLevel() + " " + entry.getMessage());

			}
			driver.close();
			System.exit(1);

		} else {
			// =======no error found===
			System.out.println("Test pass kavin");
		}

		driver.close();

	}
}
