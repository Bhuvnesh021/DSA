package models;

public class Edge {
    private int destination;
    private int source;

    public Edge(int source, int destination) {
        this.destination = destination;
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
