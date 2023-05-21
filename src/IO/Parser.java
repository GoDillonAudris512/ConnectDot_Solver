/**
 * Class Parser
 * A class to parse a file and create the board object
 */

package IO;

import java.util.*;
import java.nio.file.*;

import Container.*;

public class Parser {
    /* ATTRIBUTES */

    private List<List<Node>> map;
    private Integer firstRowColumn;
    private Boolean firstRowParsed;
    private Boolean startFound;
    private Boolean finishFound;
    
    /* METHODS */

    /* Constructor */

    public Parser() {
        this.map = new ArrayList<>();
        this.firstRowColumn = 0;
        this.firstRowParsed = false;
        this.startFound = false;
        this.finishFound = false;
    }

    /* Operations */

    private void reset() {
        this.map = new ArrayList<>();
        this.firstRowColumn = 0;
        this.firstRowParsed = false;
        this.startFound = false;
        this.finishFound = false;
    }

    private void processRow(String line) throws Exception { 
        String[] tokens = line.trim().split("\s+");
       
        if (!this.firstRowParsed) {
            this.firstRowColumn = tokens.length;
            this.firstRowParsed = true;
        }
        else if (tokens.length != this.firstRowColumn) {
            throw new Exception("Parsing gagal : Terdapat perbedaan jumlah kolom");
        }

        List<Node> listNode = new ArrayList<>();
        for (String token : tokens) {
            Integer symbol = Integer.parseInt(token);
            
            if (symbol == 2) {
                if (this.startFound) {
                    throw new Exception("Parsing gagal : Ditemukan 2 start node");
                }
                else {
                    this.startFound = true;
                }
            }
            
            if (symbol == 3) {
                if (this.finishFound) {
                    throw new Exception("Parsing gagal : Ditemukan 2 finish node");
                }
                else {
                    this.finishFound = true;
                }
            }

            listNode.add(new Node(symbol));
        }
        this.map.add(listNode);
    }

    public Board parseBoard(String filename) throws Exception {
        this.reset();

        Board board = new Board();
        List<String> listLine=  Files.readAllLines(Path.of(filename));

        if (listLine.size() == 0) {
            throw new Exception("Parsing gagal : File kosong");
        }
        else {
            board.setRow(listLine.size());
            for (String line : listLine) {
                processRow(line);
            }
            board.setColumn(this.firstRowColumn);
            board.setMap(this.map);
        }

        if (!this.startFound) {
            throw new Exception("Parsing gagal : Tidak terdapat start node pada papan permainan");
        } 
        if (!this.finishFound) {
            throw new Exception("Parsing gagal : Tidak terdapat finish node pada papan permainan");
        }

        return board;
    }
}