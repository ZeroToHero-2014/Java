package ro.teamnet.hello2;

import ro.teamnet.hello.HelloWorld;

/**
 * Created by user on 10/28/2014.
 */
public class HelloWorldExtend {

    public HelloWorldExtend() {
    }

    public void extendSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        System.out.println("The new Hello World");
    }


    public static void main(String[] args) {

        new HelloWorldExtend().extendSayHello();
    }
}