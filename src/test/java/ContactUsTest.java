import com.series.base.BaseTestConfig;
import com.series.page.ContactUs;
import org.junit.jupiter.api.*;

@Tag("ContactUsPage")
public class ContactUsTest extends BaseTestConfig {

    ContactUs contactUsPage;

    @BeforeEach
    public void setUp() {
        initializeConfigurations();
        contactUsPage = new ContactUs();
    }

    @Test
    public void validateContactUsPageLabels() {
        Assertions.assertTrue(contactUsPage.validateButtonLabels());
    }
    @Test
    public void validateContactUsNavigationHeaders() {
        Assertions.assertTrue(contactUsPage.validateHeaderNavigationLabels());
    }

    @AfterEach
    public void tearDown() {
        testDriver.quit();
    }
}
