/**
 * Class Node 
 * A class to store node representation in the one-line game
 */

package Container;

public class Node {
    /* ATTRIBUTES */

    private Integer symbol;
    private Boolean visited;

    /* METHODS */

    /* Constructor */

    public Node() {
        this.symbol = 0;
        this.visited = false;
    }

    public Node(Integer _symbol) throws Exception {
        if (_symbol < 0 || _symbol > 3) {
            throw new Exception("Parsing gagal : Terdapat simbol tidak valid");
        }

        this.symbol = _symbol;
        this.visited = false;
    }

    public Node(Node other) {
        this.symbol = other.symbol;
        this.visited = other.visited;
    }

    /* Getter - Setter */

    public void visit() {
        this.visited = true;
    }

    /* Predicate */

    public Boolean isVisited() {
        return this.visited;
    }

    public Boolean isStart() {
        return this.symbol == 2;
    }

    public Boolean isFinish() {
        return this.symbol == 3;
    }

    public Boolean isPassable() {
        return this.symbol != 0;
    }
}