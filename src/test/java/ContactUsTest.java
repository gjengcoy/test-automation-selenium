import com.series.base.BaseTestConfig;
import com.series.page.ContactUs;
import org.junit.jupiter.api.*;

@Tag("ContactUsPage")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContactUsTest extends BaseTestConfig {

    ContactUs contactUsPage;

    @BeforeEach
    public void setUp() {
        initializeConfigurations();
        contactUsPage = new ContactUs();
    }

    @Test()
    @Order(1)
    public void validateContactUsPageLabels() {
        Assertions.assertTrue(contactUsPage.validateButtonLabels());
    }

    @Test
    @Order(2)
    public void validateContactUsNavigationHeaders() {
        Assertions.assertTrue(contactUsPage.validateHeaders());
    }

    @Test
    @Order(3)
    public void validatePageScroll() {
        Assertions.assertTrue(contactUsPage.pageScrollAndNavigation());
    }

    @AfterEach
    public void tearDown() {
        testDriver.quit();
    }
}
