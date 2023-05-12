/**
 * Class OneLineSolver
 * A class to solve the one-line game board.
 */

package Solver;

import java.util.*;
import Container.*;

public class OneLineSolver {

    public void printSteps(List<String> steps) {
        String result = "Langkah : ";
        
        for (Integer i = 0; i < steps.size()-1; i++) {
            result += steps.get(i) + " - ";
            if (((i + 1) % 16) == 0) {
                result += "\n          ";
            } 
        }
        result += steps.get(steps.size()-1);
    
        System.out.println(result);
        System.out.println("Jumlah  : " + steps.size() + " langkah");
    }

    public Boolean processDFS(Board board, Coordinate toVisit, List<String> currentSteps) {
        board.visitNode(toVisit);

        if (board.isAllVisited()) {
            printSteps(currentSteps);
            return true;
        }
        else if (board.isNodeFinish(toVisit)) {
            return false; 
        }
        else {
            Integer i = 0;
            Boolean done = false;
            while (i < 4 && !done) {
                switch (i) {
                    case 0:
                    if (board.isCoordinateValid(toVisit.moveUp()) && board.isNodePassable(toVisit.moveUp()) && !board.isNodeVisited(toVisit.moveUp())) {
                        List<String> steps = new ArrayList<>(currentSteps);
                        steps.add("U");
                        done = processDFS(new Board(board), toVisit.moveUp(), steps);
                    }
                    break;
                    case 1:
                    if (board.isCoordinateValid(toVisit.moveRight()) && board.isNodePassable(toVisit.moveRight()) && !board.isNodeVisited(toVisit.moveRight())) {
                        List<String> steps = new ArrayList<>(currentSteps);
                        steps.add("R");
                        done = processDFS(new Board(board), toVisit.moveRight(), steps);
                    }
                    break;
                    case 2:
                    if (board.isCoordinateValid(toVisit.moveDown()) && board.isNodePassable(toVisit.moveDown()) && !board.isNodeVisited(toVisit.moveDown())) {
                        List<String> steps = new ArrayList<>(currentSteps);
                        steps.add("D");
                        done = processDFS(new Board(board), toVisit.moveDown(), steps);
                    }
                    break;
                    case 3:
                    if (board.isCoordinateValid(toVisit.moveLeft()) && board.isNodePassable(toVisit.moveLeft()) && !board.isNodeVisited(toVisit.moveLeft())) {
                        List<String> steps = new ArrayList<>(currentSteps);
                        steps.add("L");
                        done = processDFS(new Board(board), toVisit.moveLeft(), steps);
                    }
                    break;
                }

                if (!done) {
                    i++;
                }
            }
            return done;
        }
    }

    public void solve(Board board) {
        System.out.println("Papan Permainan:\n" + board);

        Coordinate start = board.findStartCoordinate();
        board.visitNode(start);

        Integer i = 0;
        Boolean done = false;
        while (i < 4 && !done) {
            switch (i) {
                case 0:
                if (board.isCoordinateValid(start.moveUp()) && board.isNodePassable(start.moveUp()) && !board.isNodeVisited(start.moveUp())) {
                    List<String> steps = new ArrayList<>();
                    steps.add("U");
                    done = processDFS(new Board(board), start.moveUp(), steps);
                }
                break;
                case 1:
                if (board.isCoordinateValid(start.moveRight()) && board.isNodePassable(start.moveRight()) && !board.isNodeVisited(start.moveRight())) {
                    List<String> steps = new ArrayList<>();
                    steps.add("R");
                    done = processDFS(new Board(board), start.moveRight(), steps);
                }
                break;
                case 2:
                if (board.isCoordinateValid(start.moveDown()) && board.isNodePassable(start.moveDown()) && !board.isNodeVisited(start.moveDown())) {
                    List<String> steps = new ArrayList<>();
                    steps.add("D");
                    done = processDFS(new Board(board), start.moveDown(), steps);
                }
                break;
                case 3:
                if (board.isCoordinateValid(start.moveLeft()) && board.isNodePassable(start.moveLeft()) && !board.isNodeVisited(start.moveLeft())) {
                    List<String> steps = new ArrayList<>();
                    steps.add("L");
                    done = processDFS(new Board(board), start.moveLeft(), steps);
                }
                break;
            }

            if (!done) {
                i++;
            }
        }

        if (!done) {
            System.out.println("Tidak ada langkah yang mungkin untuk menyelesaikan permainan one-line ini");
        }
    }
}