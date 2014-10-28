package ro.teamnet.zerotohero.oop.graphicshape;

/**
 * Created by Buli on 27.10.2014.
 */
public final class ImmutableClass {

    private final int field;
    private final float field2;

    private ImmutableClass(int field, float field2) {
        this.field = field;
        this.field2 = field2;
    }

    public static ImmutableClass createNewInstance(int fld, float fld2){
        return new ImmutableClass(fld,fld2);
    }

    public int getField() {
        return field;
    }

    public float getField2() {
        return field2;
    }
}
