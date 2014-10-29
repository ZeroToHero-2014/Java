package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by Buli on 29.10.2014.
 */
public class HelloWorldExtended {

    public HelloWorldExtended() {
    }

    public void extendSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        System.out.println("The new Hello World");
    }

    public static void main(String[] Args){

        HelloWorldExtended helloWorld = new HelloWorldExtended();
        helloWorld.extendSayHello();
    }


}
