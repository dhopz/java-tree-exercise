package tree.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.geom.Point2D;


public class Forest {
    private static ArrayList<Tree> forest = new ArrayList<Tree>();


    // Creates a random number to place a tree in the map
    private static Integer treePlacement(){
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        return randomNum;
    }

    // Checks to see if the place on the Forest Map is empty, if not run tree placement method again
    private static Boolean isPlotEmpy(int x, int y){
        for(Tree tree: forest) {
        if (tree.positionInForest[0] == x && tree.positionInForest[1] == y){
            return false;
        }
        }
        return true;
    }

    //Creates a 2D array to look like a grid, full of a Character provided in method
    static String[][] fillGrid(int rows, int cols, String cell){
        String[][] grid = new String[rows][cols];

        String[] row = new String[cols];
        Arrays.fill(row, cell);
        grid[0] = row;
        for (int i = 1; i < rows; i++) {
            grid[i] = Arrays.copyOf(row, cols);
        }
        return grid;
    }

    //Returns grid that has the placement of the trees added
    static String[][] findLocationOfTreeInForest(String[][] grid){
        for(Tree tree: forest) {
        grid[tree.positionInForest[0]-1][tree.positionInForest[1]-1] = "P";
        }
        return grid;
    }

    // Creates a forest map to print in the Terminal
    static void createForestMap(String[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) {
                System.out.print("   ");
                for (int j = 0; j < grid[0].length; j++) {
                    System.out.printf("%2d ", j + 1);
                }
                System.out.println();
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) {
                    System.out.printf("%2d:", i + 1);
                }
                System.out.printf("%2s ", grid[i][j]);
            }
            System.out.println();
        }
    }

    //Calculate the distance of the nearest tree
    private static Double calculateDistanceBetweenTwoPoints(int x, int y, int x_nearest, int y_nearest){
        return Point2D.distance(x,y,x_nearest,y_nearest);
    }

    //Finds the nearest tree and calculates the distance
    private static Double findNearestTreeDistance(Tree tree){
        Double nearestTree = Double.MAX_VALUE;

        for(Tree otherTree: forest) {
        if (tree != otherTree){
            Integer x = tree.positionInForest[0];
            Integer y = tree.positionInForest[1];
            Integer xNearest = otherTree.positionInForest[0];
            Integer yNearest = otherTree.positionInForest[0];
            if (nearestTree > calculateDistanceBetweenTwoPoints(x, y, xNearest, yNearest)){
            nearestTree = calculateDistanceBetweenTwoPoints(x, y, xNearest, yNearest);
            }
        }
        }
        return nearestTree;
    }

    // Checks if tree can photosynthesise if the nearest tree is something something
    private static Boolean canPhotosynthesise(Tree tree){
        Double nearestTree = findNearestTreeDistance(tree);
        return (nearestTree * 4) > tree.height;
    }

}
