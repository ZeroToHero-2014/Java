package ro.teamnet.hello;

import org.junit.Test;

/**
 * Created by Dumitru on 29.10.2014.
 */
public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        //verifica daca rezultatul fct returnHelloKey() este ceea ce ne dorim
        assert helloWorld.returnHelloKey().equals("HelloKey");
    }

}
