package Edu_Bridge.patterns;

public class somePattern {
    public static void main(String[] args) {
        pattern(6);
    }
static void pattern(int n){

        for (int i = 1; i <= n ; i++){ // Row = i
            for (int j = 1; j <= i; j++){ // Col = j
                System.out.print("* ");
            }
            // when one row is printed then we need to print a new line
            System.out.println();
        }

//    return n;
}

}
