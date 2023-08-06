import com.visher.SingletonBean;
import com.visher.SpringBeanScopeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest(classes = SpringBeanScopeApplication.class)
public class SingletonBeanTest {

    @Autowired
    private SingletonBean SingletonBeanSingleton;
    @Autowired
    private SingletonBean SingletonBeanSingleton1;

    @Test
    public void testPersonSingleton() {
        assertSame(SingletonBeanSingleton, SingletonBeanSingleton1);
    }
}
