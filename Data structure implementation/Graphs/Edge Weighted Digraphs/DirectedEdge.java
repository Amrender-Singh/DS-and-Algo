/**
 * DirectedEdge
 */
public class DirectedEdge{
    private final int v, w;
    private final double weight;
    public DirectedEdge(int v, int w, Double weight){
        if (v < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (w < 0) throw new IllegalArgumentException("vertex index must be a nonnegative integer");
        if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }
}