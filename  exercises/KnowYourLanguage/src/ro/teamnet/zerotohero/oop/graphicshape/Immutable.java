package ro.teamnet.zerotohero.oop.graphicshape;

final public class Immutable {

    final int edge;

    private Immutable(final int edge) {
        this.edge = edge;
    }

    private double calculateVolume(final int edge){
        return edge * edge * edge;
    }
}
