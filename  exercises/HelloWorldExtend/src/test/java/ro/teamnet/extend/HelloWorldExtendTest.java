package ro.teamnet.extend;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.hello.HelloWorld;

/**
 * Created by George on 10/29/2014.
 */
public class HelloWorldExtendTest {
    @Test
    public void test(){
        HelloWorld h = new HelloWorld();
        Assert.assertTrue(h.returnHelloKey().equals("HelloKey"));
    }

    @Test
    public void test2(){
        HelloWorld h = new HelloWorld();
        Assert.assertTrue(h.verify());
    }
}
