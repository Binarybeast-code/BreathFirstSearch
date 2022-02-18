package BFS;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int r, c;

    public static void printPath(char[][] grid, Node start, Node end) {
        Node endNode = end.parent;

        while (!endNode.equals(start)) {
            grid[endNode.row][endNode.col] = 'X';
            endNode = endNode.parent;
        }

        printGrid(grid);
    }

    public static boolean isInvalidPoint(char[][] grid, Node point) {
        return point.row < 0 || point.row == r || point.col < 0 || point.col == c || grid[point.row][point.col] == 'x';
    }

    public static void BFS(char[][] grid) {
        Point start = new Point(), end = new Point();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'S')
                    start.set(i, j);

                else if (grid[i][j] == 'G')
                    end.set(i, j);
            }
        }

        System.out.println();

        Node StartPoint = new Node(start.row, start.col);
        Node endPoint = new Node(end.row, end.col);


        int[][] adj = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean[][] visited = new boolean[r][c];
        Queue<Node> toVisit = new LinkedList<>();

        toVisit.add(StartPoint);
        visited[StartPoint.row][StartPoint.col] = true;

        while (!toVisit.isEmpty()) {
            Node topNode = toVisit.poll();

            if (topNode.equals(endPoint)) {
                printPath(grid, StartPoint, topNode);
                return;
            }

            for (int[] off : adj) {
                Node nb = new Node(topNode.row + off[0], topNode.col + off[1]);

                if (isInvalidPoint(grid, nb) || visited[nb.row][nb.col])
                    continue;

                visited[nb.row][nb.col] = true;
                toVisit.add(nb);
                nb.parent = topNode;
            }
        }

        System.out.println("No path to goal found");
    }

    public static void printGrid(char[][] grid) {

     for (int i = 0; i < grid.length; i++){
         for (int j = 0; j < grid.length; j++)
             System.out.print(grid[i][j] + " ");
         System.out.println();
     }

     System.exit(0);
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));

        if (in.hasNextLine()) {
            String line = in.nextLine();
            r = line.length();
            c = line.length();
            char[][] grid = new char[line.length()][line.length()];

            int row = 0;
            boolean moreLines = true;
            while (moreLines) {
                for (int i = 0; i < line.length(); i++) {
                    grid[row][i] = line.charAt(i);
                }

                if (in.hasNextLine()) {
                    line = in.nextLine();
                    row++;
                } else {
                    moreLines = false;
                }
            }

            System.out.println();
            in.close();
            BFS(grid);
        }
    }
}

