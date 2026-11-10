package Math;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Matrix {
    private double[][] matrix;

    public Matrix(int size){
        matrix = new double[size][size];
    }

    public Matrix(double[][] arr){
        if (arr.length != arr[0].length) {
            throw new IllegalArgumentException("Матрица обязательно квадратная");
        }
        this.matrix = arr.clone();
    }

    public static Matrix create_zero_matrix(int size){
        return new Matrix(size);
    }

    public static Matrix create_identity_matrix(int size){
        Matrix matrix = new Matrix(size);
        for (int i = 0; i < size; i++){
            matrix.set_value(i, i, 1);
        }
        return matrix;
    }

    public void add_matrix(Matrix matrix){
        int min_size = min(size(), matrix.size());

        for(int i = 0; i < min_size; i++){
            for(int j = 0; j < min_size; j++){
                add_value(i, j, matrix.get_value(i, j));
            }
        }
    }

    public void subtract_matrix(Matrix matrix){
        int min_size = min(size(), matrix.size());

        for(int i = 0; i < min_size; i++){
            for(int j = 0; j < min_size; j++){
                add_value(i, j, -1 * matrix.get_value(i, j));
            }
        }
    }

    public void transpose(){
        for (int i = 1; i < size(); i++){
            for (int j = 0; j < i; j++){
                double temp = get_value(i, j);
                set_value(i, j, get_value(j, i));
                set_value(j, i, temp);
            }
        }
    }

    public static Matrix sum_of_matrices(Matrix matrix_1, Matrix matrix_2){
        Matrix matrix_sum = new Matrix(max(matrix_1.size(), matrix_2.size()));

        for(int i = 0; i < matrix_1.size(); i++){
            for(int j = 0; j < matrix_1.size(); j++){
                matrix_sum.add_value(i, j, matrix_1.get_value(i, j));
            }
        }

        for(int i = 0; i < matrix_2.size(); i++){
            for(int j = 0; j < matrix_2.size(); j++){
                matrix_sum.add_value(i, j, matrix_2.get_value(i, j));
            }
        }

        return matrix_sum;
    }

    public static Matrix dif_of_matrices(Matrix matrix_1, Matrix matrix_2){
        Matrix matrix_sum = new Matrix(max(matrix_1.size(), matrix_2.size()));

        for(int i = 0; i < matrix_1.size(); i++){
            for(int j = 0; j < matrix_1.size(); j++){
                matrix_sum.add_value(i, j, matrix_1.get_value(i, j));
            }
        }

        for(int i = 0; i < matrix_2.size(); i++){
            for(int j = 0; j < matrix_2.size(); j++){
                matrix_sum.add_value(i, j, -1 * matrix_2.get_value(i, j));
            }
        }

        return matrix_sum;
    }

    public static Vector multiplication_of_matrix_and_vector(Matrix matrix, Vector vector){
        if (matrix.size() != vector.size()){
            throw new IllegalArgumentException("Умножение матрицы и вектора разных размеров");
        }

        Vector vector_out = new Vector(vector.size());
        int size = vector.size();

        for (int i = 0; i < size; i++){
            double sum = 0;
            for (int j = 0; j < size; j++){
                sum += matrix.get_value(i, j) * vector.get_value(j);
            }
            vector_out.set_value(i, sum);
        }

        return vector_out;
    }

    public static Matrix multiplication_of_matrices(Matrix matrix_1, Matrix matrix_2){
        if (matrix_1.size() != matrix_2.size()) {
            throw new IllegalArgumentException("Умножение матриц разных размеров");
        }

        Matrix matrix_multiply = new Matrix(matrix_1.size());

        int size = matrix_multiply.size();

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                double sum = 0;

                for(int k = 0; k < size; k++){
                    sum += matrix_1.get_value(i, k) * matrix_2.get_value(k, j);
                }

                matrix_multiply.set_value(i, j, sum);
            }
        }

        return matrix_multiply;
    }

    public static double get_determinant(Matrix matrix){
        if (matrix.size() == 1){
            return matrix.get_value(0, 0);
        }

        if (matrix.size() == 2){
            return matrix.get_value(0, 0) * matrix.get_value(1, 1) - matrix.get_value(0, 1) * matrix.get_value(1, 0);
        }

        double det = 0;
        for (int i = 0; i < matrix.size(); i++){
            det += matrix.get_value(i, 0) * get_algebraic_complement(matrix, i, 0);
        }

        return det;
    }

    public static double get_algebraic_complement(Matrix matrix, int i, int j){
        Matrix temp_matrix = new Matrix(matrix.size() - 1);
        int size = temp_matrix.size();

        for(int row = 0; row < i; row++){
            for (int col = 0; col < j; col++){
                temp_matrix.set_value(row, col, matrix.get_value(row, col));
            }

            for (int col = j; col < size; col++){
                temp_matrix.set_value(row, col, matrix.get_value(row, col + 1));
            }
        }
        for(int row = i; row < size; row++){
            for (int col = 0; col < j; col++){
                temp_matrix.set_value(row, col, matrix.get_value(row + 1, col));
            }

            for (int col = j; col < size; col++){
                temp_matrix.set_value(row, col, matrix.get_value(row + 1, col + 1));
            }
        }
        return get_determinant(temp_matrix) * Math.pow(-1, i + j);
    }

    public static Matrix get_inverse_matrix(Matrix matrix){
        double det = get_determinant(matrix);

        if (det == 0){
            throw new IllegalArgumentException("Детерминант равен нулю, обратной матрицы не существует");
        }

        int size = matrix.size();

        Matrix inverse_matrix = new Matrix(size);

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                inverse_matrix.set_value(i, j, get_algebraic_complement(matrix, i, j));
            }
        }

        inverse_matrix.transpose();

        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                inverse_matrix.set_value(i, j, inverse_matrix.get_value(i, j) / det);
            }
        }

        return inverse_matrix;
    }

    public int size(){
        return matrix.length;
    }

    public double get_value(int i, int j){
        return matrix[i][j];
    }

    public double[][] get_array(){
        return matrix;
    }

    public void add_value(int i, int j, double value){
        matrix[i][j] += value;
    }

    public void set_value(int i, int j, double value){
        matrix[i][j] = value;
    }

    public void print(){
        DecimalFormat df = new DecimalFormat("#.###");

        System.out.println("{");
        for (int i = 0; i < size(); i++){
            for(int j = 0; j < size(); j++){
                System.out.print(df.format(get_value(i, j)));
                System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("}");
    }
}
