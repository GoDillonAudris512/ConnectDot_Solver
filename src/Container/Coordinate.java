/**
 * Class Coordinate 
 * A class to store a coordinate, pair of row and column index of matrix
 */

package Container;

public class Coordinate {
    /* ATTRIBUTES */

    private Integer row;
    private Integer column;

    /* METHODS */

    /* Constructor */

    public Coordinate() {
        this.row = -1;
        this.column = -1;
    }

    public Coordinate(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }

    /* Getter - Setter */

    public Integer getRow() {
        return this.row;
    }

    public Integer getColumn() {
        return this.column;
    }

    /* Operations */

    public Coordinate moveUp() {
        return new Coordinate(this.row - 1, this.column);
    }

    public Coordinate moveDown() {
        return new Coordinate(this.row + 1, this.column);
    }

    public Coordinate moveRight() {
        return new Coordinate(this.row, this.column + 1);
    }

    public Coordinate moveLeft() {
        return new Coordinate(this.row, this.column - 1);
    }
}
