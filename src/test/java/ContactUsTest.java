import com.series.base.BaseTestConfig;
import com.series.page.ContactUs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactUsTest extends BaseTestConfig {

    ContactUs contactUsPage;

    @BeforeEach
    public void setUp() {
        initializeConfigurations();
    }

    @Test
    public void validateContactUsPageLabels() {
        Assertions.assertTrue(contactUsPage.validateButtonLabels());
    }

    @AfterEach
    public void tearDown() {
        testDriver.quit();
    }
}
