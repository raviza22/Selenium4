package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".oxd-sidepanel")
    WebElement sidePanel;

    public boolean isSidePanelDisplayed() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(sidePanel));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return sidePanel.isDisplayed();
    }
}
