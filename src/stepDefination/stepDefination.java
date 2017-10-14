package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefination {

	static String browser;
	static WebDriver driver;

	@Given("^selecciono el navegador$")
	public void setBrowser(){
		browser="firefox";
		//	browser="Chrome";
		//	browser="explorer";
	}

	@Given("^accedo a la pantalla del login$")
	public void accedo_a_la_pantalla_del_login() throws Throwable {
		String projectLocation = System.getProperty("user.dir");

		if (browser.contains("firefox")){
			System.setProperty("webdriver.gecko.driver", projectLocation+"/lib/geckodriver/geckodriver.exe");
			System.setProperty("webdriver.firefox.bin", "C:/Program Files/Mozilla Firefox/firefox.exe");
			driver = new FirefoxDriver();
			driver.get("https://www.linkedin.com/");
		}
		if (browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", projectLocation+"/lib/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.linkedin.com/");
		}
		if (browser.contains("explorer")){
			System.setProperty("webdriver.ie.driver", projectLocation+"/lib/iedriver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("https://www.linkedin.com/");
		}
	}

	@When("^ingreso correo electronico as \"([^\"]*)\"$")
	public void ingreso_correo_electronico_as(String arg1) throws Throwable {
		driver.findElement(By.id("login-email")).clear();
		driver.findElement(By.id("login-email")).sendKeys(arg1);
		Thread.sleep(1000);
	}

	@When("^ingreso contrasena as \"([^\"]*)\"$")
	public void ingreso_contrasena_as(String arg1) throws Throwable {
		driver.findElement(By.id("login-password")).clear();
		driver.findElement(By.id("login-password")).sendKeys(arg1);
		Thread.sleep(1000);
	}

	@Then("^login exitoso$")
	public void login_exitoso() throws Throwable {
		driver.findElement(By.id("login-submit")).click();
		System.out.println("Su login ha sido exitoso");
	}

	@Then("^login fallido$")
	public void login_fallido() throws Throwable {
		driver.findElement(By.id("login-submit")).click();
		System.out.println("Su login ha sido fallido");
	}

	@Given("^ingreso un contacto as \"([^\"]*)\"$")
	public void ingreso_un_contacto_as(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input")).clear();
		driver.findElement(By.xpath("//input")).sendKeys(arg1);
		driver.findElement(By.id("nav-search-controls-wormhole")).click();
		Thread.sleep(1000);
	}

	@When("^selecciono el contacto$")
	public void selecciono_el_contacto() throws Throwable {
		driver.findElement(By.xpath("//h3/span/span")).click();
	}

	@Then("^puedo ver el perfil del contacto$")
	public void puedo_ver_el_perfil_del_contacto() throws Throwable {
		System.out.println("Detalles del contacto visualizado");
	}
}
