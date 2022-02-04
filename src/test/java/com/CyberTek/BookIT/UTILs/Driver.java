package com.CyberTek.BookIT.UTILs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating the private constructor so this class' object
    is not reachable from outside
     */
    private Driver() {
    }

    /*
    Making our 'driver' instance private so that it is not reachable from outside of the class.
    We make it static, because we want it to run before everything else, and also we will use it in a static method
     */





    /*
    The TheadLocal construct allows us to store data that will be accessible only by a specific thread.

Let's say that we want to have an Integer value that will be bundled with the specific thread:

ThreadLocal<Integer> threadLocalValue = new ThreadLocal<>();
Next, when we want to use this value from a thread we only need to call a get() or set() method.
Simply put, we can think that ThreadLocal stores data inside of a map – with the thread as the key.

Due to that fact, when we call a get() method on the threadLocalValue, we will get an Integer value for the requesting thread:

threadLocalValue.set(1);
Integer result = threadLocalValue.get();
We can construct an instance of the ThreadLocal by using the withInitial() static method and passing a supplier to it:

ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 1);
To remove the value from the ThreadLocal, we can call the remove() method:

threadLocal.remove();
To see how to use the ThreadLocal properly, firstly, we will look at an example that does not use a ThreadLocal,
 then we will rewrite our example to leverage that construct.
     */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*
    Creating re-usable utility method that will return same 'driver' instance everytime we call it.
     */
    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            synchronized (Driver.class) {
            /*
            We read our browser type from configuration.properties file using
            .getProperty method we creating in ConfigurationReader class.
             */
                String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browser type our switch statement will determine
            to open specific type of browser/driver
             */
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                }
            }
        }

        /*
        Same driver instance will be returned every time we call Driver.getDriver(); method
         */
        return driverPool.get();


    }

    /*
    This method makes sure we have some form of driver sesion or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }


}
