package mk.ukim.finki.wp.lab.selenium;


import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.model.User;
import mk.ukim.finki.wp.lab.service.BalloonService;
import mk.ukim.finki.wp.lab.service.ManufacturerService;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumScenarioTest {



    @Autowired
    ManufacturerService manufacturerService;

    @Autowired
    BalloonService balloonService;



    private HtmlUnitDriver driver;

    private static Balloon b1;
    private static Balloon b2;
    private static Manufacturer m1;
    private static Manufacturer m2;
    private static String user = "user";
    private static String admin = "admin";

    private static boolean dataInitialized = false;


    @BeforeEach
    private void setup() {
        this.driver = new HtmlUnitDriver(true);
        initData();
    }

    @AfterEach
    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
        }
    }


    private void initData() {
        if (!dataInitialized) {
            m1 = new Manufacturer("m1");
            m2 = new Manufacturer("m2");

            //b1 = balloonService.createBalloon("b1","b1",m1);
            //b2 = balloonService.createBalloon("b2", "b2",m2);

            dataInitialized = true;
        }
    }

    @Test
    public void testScenario() throws Exception {
        BalloonsPage balloonsPage = BalloonsPage.to(this.driver);
        balloonsPage.assertElemts(0, 0,  0, 0);
        LoginPage loginPage = LoginPage.openLogin(this.driver);

        balloonsPage = LoginPage.doLogin(this.driver, loginPage, admin, admin);
        balloonsPage.assertElemts(0, 0,  0, 1);

        balloonsPage = AddOrEditBalloon.addBalloon(this.driver, "test", "red", "5");
        balloonsPage.assertElemts(1, 1, 1, 1);

        balloonsPage = AddOrEditBalloon.addBalloon(this.driver, "test1", "blue", "4");
        balloonsPage.assertElemts(2, 2, 2, 1);

        balloonsPage.getDeleteButtons().get(1).click();
        balloonsPage.assertElemts(1, 1, 1, 1);

        balloonsPage = AddOrEditBalloon.editBalloon(this.driver, balloonsPage.getEditButtons().get(0), "test1", "200", "4");
        balloonsPage.assertElemts(1, 1, 1, 1);

        loginPage = LoginPage.logout(this.driver);
        balloonsPage = LoginPage.doLogin(this.driver, loginPage, user, user);
        balloonsPage.assertElemts(1, 0, 0, 1);


    }


}
