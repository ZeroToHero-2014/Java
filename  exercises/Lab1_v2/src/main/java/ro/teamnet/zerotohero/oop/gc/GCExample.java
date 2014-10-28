package ro.teamnet.zerotohero.oop.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Computer on 10/27/2014.
 */
public class GCExample {
    public static void main (String[] args)
    {
        List<DemoObject> demoObjects = new ArrayList<DemoObject>();
        while(true)
        {
            demoObjects.add(new DemoObject());
        }
    }

}




