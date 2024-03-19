import com.example.App;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
class AppTest {

    @Test
     void testGetStatus() {
        App app = new App();
        String status = app.getStatus();
        assertEquals("OK", status);
    }
}


