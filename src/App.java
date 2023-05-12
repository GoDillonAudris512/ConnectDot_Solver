import IO.Parser;
import Solver.OneLineSolver;

public class App {
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Mohon masukkan 1 argumen nama file");
        }
        else {
            try {
                System.out.println("=========================================================================");
                new OneLineSolver().solve(new Parser().parseBoard(args[0]));
                System.out.println("=========================================================================");
            }
            catch (NumberFormatException e) {
                System.out.println("Parsing gagal : Mohon masukkan hanya angka ke dalam file");
                System.out.println("=========================================================================");
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("=========================================================================");
            }
        }
        
    }
}
