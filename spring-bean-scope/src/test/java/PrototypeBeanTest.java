import com.visher.SpringBeanScopeApplication;
import com.visher.PrototypeBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotSame;
@SpringBootTest(classes = SpringBeanScopeApplication.class)
public class PrototypeBeanTest {
    @Autowired
    private PrototypeBean prototypeBean;
    @Autowired
    private PrototypeBean prototypeBean2;

    @Test
    public void testPersonSingleton() {
        assertNotSame(prototypeBean, prototypeBean2);
    }
}
