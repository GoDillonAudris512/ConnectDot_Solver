/**
 * Class Board 
 * A class to store board representation in the one-line game.
 */

package Container;

import java.util.*;

public class Board {
    /* ATTRIBUTES */

    private List<List<Node>> map;
    private Integer row;
    private Integer column;

    /* METHODS */

    /* Constructor */

    public Board() {
        this.map = new ArrayList<>();
        this.row = 0;
        this.column = 0;
    }

    public Board(Board other) {
        this.map = new ArrayList<>();
        this.row = other.row;
        this.column = other.column;

        Integer i = 0;
        for (List<Node> listNode : other.map) {
            this.map.add(new ArrayList<>());
            for (Node node : listNode) {
                this.map.get(i).add(new Node(node));
            }
            i++;
        }
    }

    /* Getter - Setter */

    public void setMap(List<List<Node>> map) {
        this.map = map;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    /* Predicate */
    
    public Boolean isCoordinateValid(Coordinate coordinate) {
        return (coordinate.getRow() >= 0) && (coordinate.getRow() < this.row) && (coordinate.getColumn() >= 0) && (coordinate.getColumn() < this.column);
    }

    public Boolean isNodePassable(Coordinate coordinate) {
        return this.map.get(coordinate.getRow()).get(coordinate.getColumn()).isPassable();
    }

    public Boolean isNodeVisited(Coordinate coordinate) {
        return this.map.get(coordinate.getRow()).get(coordinate.getColumn()).isVisited();
    }

    public Boolean isNodeFinish(Coordinate coordinate) {
        return this.map.get(coordinate.getRow()).get(coordinate.getColumn()).isFinish();
    }

    public Boolean isAllVisited() {
        Integer i = 0;
        Integer j = 0;
        Boolean allVisited = true;

        while (i < this.row && allVisited) {
            j = 0;
            while (j < this.column && allVisited) {
                if (this.map.get(i).get(j).isPassable() && !this.map.get(i).get(j).isVisited()) {
                    allVisited = false;
                }
                else {
                    j++;
                }
            }
            if (allVisited) {
                i++;
            }
        }

        return allVisited;
    }

    /* Operations */

    public Coordinate findStartCoordinate() {
        for (Integer i = 0; i < this.row; i++) {
            for (Integer j = 0; j < this.column; j++) {
                if (this.map.get(i).get(j).isStart()) {
                    return new Coordinate(i, j);
                }
            }
        }
        return new Coordinate();
    }

    public void visitNode(Coordinate coordinate) {
        this.map.get(coordinate.getRow()).get(coordinate.getColumn()).visit();
    }

    public String toString() {
        String result = "";
        for (List<Node> listNode : this.map) {
            for (Node node : listNode) {
                if (node.isFinish()) {
                    result += "F ";
                }
                else if (node.isStart()) {
                    result += "S ";
                }
                else if (node.isPassable()) {
                    result += "R ";
                }
                else {
                    result += "  ";
                }
            }
            result += "\n";
        }
        return result;
    }
}