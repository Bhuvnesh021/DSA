package models;

public class Node{
    public int time, row, column;

    public Node(int time, int row, int column) {
        this.time = time;
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "Node{" +
                "time=" + time +
                ", x=" + row +
                ", y=" + column +
                '}';
    }

}