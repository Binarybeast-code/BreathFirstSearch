package BFS;

public class Point
{
    public int row, col;

    public Point(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public Point()
    {
        this.row = 0;
        this.col = 0;
    }

    public void set(int row, int col)
    {
        this.row = row;
        this.col = col;
    }
}