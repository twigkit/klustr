package twigkit.klustr.strategy;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * 
 */
public class SingleTest {

    @Test
    public void testSingleResource() throws Exception {
        Strategy<String> strategy = new Single<String>();
        strategy.setResources("resource01");

        assertEquals("resource01", strategy.next());
        assertEquals("resource01", strategy.next());
    }
}
