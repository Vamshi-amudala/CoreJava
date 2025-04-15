package kunalJ.patterns;

public class numbers {
        public static void main(String[] args) {
            pattern(5);
        }
        static void pattern(int n){

            for (int i = 1; i <= n ; i++){ // Row = i
                for (int j = 1; j <= i; j++){ // Col = j
                    System.out.print(j + " ");
                }
                // when one row is printed then we need to print a new line
                System.out.println();
            }

//    return n;
        }
}
