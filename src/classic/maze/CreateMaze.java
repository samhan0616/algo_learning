package classic.maze;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class CreateMaze {

    int row;
    int col;
    int [][] maze;
    int[] x = {1, 0, -1 ,0};
    int[] y = {0, 1, 0 ,-1};

    Stack<int[]> stack = new Stack<>();
    Random random;

    public CreateMaze(int row, int col) {
        random = new Random();
        this.row = row;
        this.col = col;
        maze = new int[row][col];
        for (int [] arr : maze) Arrays.fill(arr, 1);
        generate();

    }

    private void generate() {
        boolean[][] visited = new boolean[row][col];

        generate(visited, 0, 0);
    }

    private void generate(boolean[][] visited, int row, int col) {
        if (!visited[row][col]) stack.push(new int[]{row, col});
        visited[row][col] = true;
        maze[row][col] = 0;
        if (this.row - 1 == row && this.col - 1 == col) return ;
        int [] nodes = null;
        int count = 0;
        do {
            nodes = getNode(visited, row, col);
            if (count++ > 10 && !stack.isEmpty()) {
                if (stack.peek()[0] == row && stack.peek()[1] == col)stack.pop();
                int[] temp = stack.pop();
                generate(visited,  temp[0], temp[1]) ;
            }
        } while (valid(visited, nodes[0], nodes[1]));
        System.out.println("row:" + nodes[0] + " col:" + nodes[1] + " " + stack);
        print();
        generate(visited,  nodes[0], nodes[1]);
    }

    private boolean valid(boolean[][] visited, int row, int col) {
        int count = 0;
        for (int i = 0 ; i < 4; i ++) {
            int nr = row + x[i];
            int nc = col + y[i];
            if (nr >= 0 &&  nr < this.row && nc >= 0 && nc < this.col) {
                if (!visited[nr][nc]) count++;
            } else count ++;
        }
        return count != 3;
    }

    private int[] getNode(boolean[][] visited, int row, int col) {
        int nr,nc;
        do{
            int factor = random.nextInt(4);
            nr = x[factor] + row;
            nc = y[factor] + col;
        } while (!(nr >= 0 &&  nr < this.row && nc >= 0 && nc < this.col && !visited[nr][nc]));
        return new int[]{nr,nc};
    }


    public void print() {
        for (int[] arr : maze) System.out.println(Arrays.toString(arr));
        System.out.println();
    }

    public static void main(String[] args) {
        CreateMaze maze = new CreateMaze(10, 10);
        maze.print();
    }
}
