package kunalJ.patterns;

public class pattern5 {
        public static void main(String[] args) {
            pattern(6);
        }
        static void pattern(int n){

            for (int i = 0; i <= 2 * n ; i++){ // Row = i
                int totalCountInRow = i >n ? 2*n - i: i;
                for (int j = 1; j <totalCountInRow; j++){ // Col = j
                    System.out.print("* " + " ");
                }

                // when one row is printed then we need to print a new line
                System.out.println();

            }
//
//            for (int i = n - 1; i >= 1; i--) { // Row = i
//                for (int j = 1; j <= i; j++) { // Col = j
//                    System.out.print("* " + " ");// Print star
//                }
//                System.out.println(); // New line after each row
//            }

//    return n;
        }
}