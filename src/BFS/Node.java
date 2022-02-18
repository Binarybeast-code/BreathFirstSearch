package BFS;

public class Node extends Point
{
    public Node parent;

    public Node(int row, int col)
    {
        super(row, col);
        parent = null;
    }

    public boolean equals(Object other)
    {
        if (this == other)
            return true;

        if (!(other instanceof Node))
            return false;

        Node node = (Node) other;
        return this.row == node.row && this.col == node.col;
    }
}
