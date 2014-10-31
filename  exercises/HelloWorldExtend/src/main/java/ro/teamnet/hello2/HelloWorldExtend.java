package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by Andrei on 10/29/2014.
 */
public class HelloWorldExtend {
    public HelloWorldExtend() {
    }

    public void extendSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        System.out.println("The new Hello World");
    }

}
