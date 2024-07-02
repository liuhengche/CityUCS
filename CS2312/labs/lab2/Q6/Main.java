import java.util.*;

public class Main {
    public static void main(String[] args) {
     
        int width, height;

        System.out.print("Input the width of the multiplication table (2-10): ");

        System.out.print("Input the height of the multiplication table (2-10): ");
        /* Notes to students:
        1. We need a Scanner object to get user input (like Lab01-Q1 in Lab01.pdf Page 3):
        - Add the import statement at the beginning: import java.util.*;
        - Declare a scanner object: Scanner [object variable name]; 
        - Create a scanner object as: new Scanner(System.in);
        - To read an integer, we call the .nextInt() method: [scanner object].nextInt();
        - Close the scanner object: [scanner object].close();
        2. Learn from Q1: System.out.printf("%5d", x); // Show x, "%" means a field,
        // right aligned, width=5, 
        // d means decimal 
        */ 

        Scanner sc = new Scanner(System.in);
        width = sc.nextInt();
        height = sc.nextInt();

        System.out.print('/');
        for (int i = 0; i < 6*width + 1; i++) {
            System.out.print('-');
        }
        System.out.print('\\');
        System.out.println();

        for (int r = 0; r < height; r++) {           // (i,j) are not good for this question; (row, col), (r,c), (y, x) are good
            for(int c = 0; c < width; c++) {        // always use start from 0 and < for the iterations
                //System.out.printf("%5d|", (r+1)*(c+1));
                if(c == 0) {
                    System.out.print("|");
                    System.out.printf("%5d|", (r+1)*(c+1));
                }
                else {
                    System.out.printf("%6d", (r+1)*(c+1));
                }
            }
            System.out.print(" |");
            System.out.println();
            if(r == 0) {
                System.out.print('|');
                for (int i = 0; i < 6*width + 1; i++) {
                    System.out.print('-');
                }
                System.out.print('|');
                System.out.println();
            }         
        }

        System.out.print('\\');
        for (int i = 0; i < 6*width + 1; i++) {
            System.out.print('-');
        }
        System.out.print('/');
        System.out.println();

        sc.close();
     
     } 
    } 