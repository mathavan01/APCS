import java.util.Scanner;

public class Determinant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the dimension of the square matrix: ");
        int d = scanner.nextInt();

        int[][] matrix = new int[d][d];

        for (int i = 0; i < d; i++){
            for (int j = 0; j < d; j++){
                System.out.println("Enter a value:");
                matrix[i][j] = scanner.nextInt();
                for (int k = 0; k < d; k++){
                    for (int l = 0; l < d; l++){
                        System.out.print(matrix[k][l] + "\t");
                    }
                    System.out.println();
                }
            }
        }


        int determinant = calculateDeterminant(matrix);
        System.out.println("The determinant of the matrix is: " + determinant);
    }

    private static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;

        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            int determinant = 0;

            for (int i = 0; i < n; i++) {
                int[][] submatrix = new int[n - 1][n - 1];

                for (int j = 1; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k < i) {
                            submatrix[j - 1][k] = matrix[j][k];
                        } else if (k > i) {
                            submatrix[j - 1][k - 1] = matrix[j][k];
                        }
                    }
                }

                int sign = (i % 2 == 0) ? 1 : -1;
                determinant += sign * matrix[0][i] * calculateDeterminant(submatrix);
            }

            return determinant;
        }
    }
}
