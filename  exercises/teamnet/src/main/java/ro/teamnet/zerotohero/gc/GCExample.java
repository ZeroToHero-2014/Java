package ro.teamnet.zerotohero.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Buli on 27.10.2014.
 */
public class GCExample {

    public static void main(String[] args) {
        List<DemoObject> demoObjects = new ArrayList<DemoObject>();
        while(true) {
            new DemoObject();
            demoObjects.add(new DemoObject());
        }
    }


}
