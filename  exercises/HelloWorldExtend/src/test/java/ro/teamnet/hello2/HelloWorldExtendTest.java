package ro.teamnet.hello2;

import org.junit.Test;
import ro.teamnet.hello.HelloWorld;

/**
 * Created by hangan on 10/29/2014.
 */
public class HelloWorldExtendTest {
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }
}
