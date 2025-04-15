package kunalJ.patterns;

public class Diamond {
    public static void main(String[] args) {
    pattern(8);


    }
    static void pattern(int n){

        for (int i = 0; i <= 2 * n ; i++){ // Row = i
            int totalCountInRow = i >n ? 2*n - i: i;

            int numSpaces = n - totalCountInRow;
            for (int s = 0; s < numSpaces; s++){
                System.out.print(" ");
            }

            for (int j = 1; j <totalCountInRow; j++){ // Col = j
                System.out.print("* ");
            }

            // when one row is printed then we need to print a new line
            System.out.println();

        }

}
}
