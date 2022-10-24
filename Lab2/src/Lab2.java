import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab2 {
        public static String symmetrical(int arr[][], int size_i, int size_j){
            if(size_j != size_i){
                return "Матрица не квадратная";
            }
            for(int i = 0; i<size_i; i++){
                for (int j = 0; j<size_j; j++) {
                    if(arr[i][j] != arr[j][i]){
                        return "Матрица не симметричная";
                    }
                }
            }
            return "Матрица симметричная";
        }
        public static void diagMove(int matrix[][], int size_i, int size_j){
            if(size_i % 2 == 0 && size_j % 2 == 0 || size_j != size_i){
                System.out.println("Нет диагонального");
                return;
            }
            int temp;
            int max = 0;
            int x = 0;
            int y = 0;
            for(int i = 0; i < size_i; i++){
                if(matrix[i][i] > max){
                    max = matrix[i][i];
                    x = i;
                    y = i;
                }
            }
            for(int i = 0; i < size_i; i++) {
                if (matrix[i][size_i - 1 - i] > max) {
                    max = matrix[i][size_i - 1 - i];
                    x = i;
                    y = size_i - 1 - i;
                }
            }

            temp = matrix[size_i/2][size_j/2];
            matrix[size_i/2][size_j/2] = matrix[x][y];
            matrix[x][y] = temp;
        }
        public static String outputMatrix(int matrix[][], int size_i, int size_j){
            String str = "";
            for(int i = 0; i<size_i; i++){
                for (int j = 0; j<size_j; j++) {
                    str += matrix[i][j] + " ";
                    if(j == size_j - 1){
                        str+="\n";
                    }
                }
            }
            return str;
        }
        public static int maxOfSumDiag(int matrix[][], int size_i, int size_j){
            if(size_j != size_i){
                return 0;
            }
            int tempSum = 0;
            int max = 0;
            for(int i = 1; i < size_i - 1; i++){
                int j = 0;
                int n = i;
                do{
                    tempSum+=matrix[n][j];
                    n++;
                    j++;
                }while (n <= size_i - 1);
                if(max < tempSum){
                    max = tempSum;
                }
                tempSum = 0;
            }
            for(int j = 1; j < size_i - 1; j++){
                int i = 0;
                int n = j;
                do{
                    tempSum+=matrix[i][n];
                    n++;
                    i++;
                }while (n <= size_j - 1);
                if(max < tempSum){
                    max = tempSum;
                }
                tempSum = 0;
            }
            return max;
        }
        public static void sortByLines(int matrix[][], int size_i, int size_j){
            int x[] = null;
            for(int i=0; i < size_i; i++) {
                for(int j = size_i-1; j > i; j-- ) {
                    if (matrix[j-1][0] > matrix[j][0] ) {
                        x =matrix[j-1];
                        matrix[j-1]=matrix[j];
                        matrix[j]=x;
                    }
                }
            }
        }
        public static void main(String[] args){
            FileInputStream fin;
            File file;
            PrintWriter pw;
            try {
                fin =new FileInputStream("input.txt");
                file = new File("output.txt");
                pw = new PrintWriter(file);
            }catch (FileNotFoundException exc){
                System.out.println("Файл не найден");
                return;
            }
            Scanner input = new Scanner(fin);
            int size_i = input.nextInt();
            int size_j = input.nextInt();
            int matrix[][] = new int[size_i][size_j];
            for(int i = 0; i < size_i; i++){
                for (int j = 0; j<size_j; j++) {
                    matrix[i][j] = input.nextInt();
                }
            }
            pw.println(outputMatrix(matrix, size_i, size_j));
            pw.println(symmetrical(matrix, size_i, size_j));
            pw.println("Максимальная сумма параллельных диагоналей");
            pw.println(maxOfSumDiag(matrix, size_i, size_j));
            pw.println("Замена максимального главной и побочной на центральный");
            diagMove(matrix, size_i, size_j);
            pw.println(outputMatrix(matrix, size_i, size_j));
            pw.println("Сортировка по первому элементу строки");
            sortByLines(matrix, size_i, size_j);
            pw.println(outputMatrix(matrix, size_i, size_j));
            pw.close();
        }
}

