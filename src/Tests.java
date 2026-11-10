import Math.Vector;
import Math.Matrix;

import java.util.Arrays;

public class Tests {
    public static void sum_of_same_vectors(){
        Vector vector_1 = new Vector(new double[] {2, -1, 6, 11, 0});
        Vector vector_2 = new Vector(new double[] {-3, 1, 11, 0, -7});

        System.out.println("Тест суммы двух векторов одинаковой размерности");

        vector_1.print();
        vector_2.print();

        Vector vector_result = Vector.sum_of_vectors(vector_1, vector_2);
        Vector expected_result = new Vector(new double[] {-1, 0, 17, 11, -7});

        System.out.println("Ожидаемая сумма: {-1, 0, 17, 11, -7}");
        System.out.print("Полученная сумма: ");
        vector_result.print();

        if (!Arrays.equals(vector_result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void sum_of_different_vectors(){
        Vector vector_1 = new Vector(new double[] {2, -1, 6, 11, 0});
        Vector vector_2 = new Vector(new double[] {-3, 1, 11, 0, -7, 10, 2});



        System.out.println("Тест суммы двух векторов разной размерности");

        vector_1.print();
        vector_2.print();

        Vector vector_result = Vector.sum_of_vectors(vector_1, vector_2);
        Vector expected_result = new Vector(new double[] {-1, 0, 17, 11, -7, 10, 2});

        System.out.println("Ожидаемая сумма: {-1, 0, 17, 11, -7, 10, 2}");
        System.out.print("Полученная сумма: ");
        vector_result.print();

        if (!Arrays.equals(vector_result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void add_vector_bigger_size(){
        Vector vector_1 = new Vector(new double[] {2, -1, 6, 11, 0});
        Vector vector_2 = new Vector(new double[] {-3, 1, 11, 0, -7, 10, 2});



        System.out.println("Тест прибавления вектору вектора большей размерности");

        vector_1.print();
        vector_2.print();

        vector_1.add_vector(vector_2);
        Vector expected_result = new Vector(new double[] {-1, 0, 17, 11, -7});

        System.out.println("Ожидаемая сумма: {-1, 0, 17, 11, -7}");
        System.out.print("Полученная сумма: ");
        vector_1.print();

        if (!Arrays.equals(vector_1.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void multiply_vector_on_const(){
        Vector vector = new Vector(new double[] {2, -1, 6, 11, 0});

        System.out.println("Тест умножения вектора на число");

        vector.print();
        System.out.println("3");

        vector.multiply_vector_on_const(3);
        Vector expected_result = new Vector(new double[] {6, -3, 18, 33, 0});

        System.out.println("Ожидаемый вектор: {6, -3, 18, 33, 0}");
        System.out.print("Полученный вектор: ");
        vector.print();
        if (!Arrays.equals(vector.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void divide_vector_on_const(){
        Vector vector = new Vector(new double[] {2, -1, 6, 11, 0});

        System.out.println("Тест деления вектор на число");

        vector.print();
        System.out.println("4");

        vector.divide_vector_on_const(4);
        Vector expected_result = new Vector(new double[] {0.5, -0.25, 1.5, 2.75, 0});

        System.out.println("Ожидаемый вектор: {0.5, -0.25, 1.5, 2.75, 0}");
        System.out.print("Полученный вектор: ");
        vector.print();
        if (!Arrays.equals(vector.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void normalize_vector() {
        Vector vector = new Vector(new double[] {3, 4});

        System.out.println("Тест нормализации вектора");

        System.out.print("Исходный вектор: ");
        vector.print();

        vector.normalize();

        Vector expected_result = new Vector(new double[] {0.6, 0.8});

        System.out.println("Ожидаемый результат: {0.6, 0.8}");
        System.out.print("Полученный результат: ");
        vector.print();

        if (!Arrays.equals(vector.get_array(), expected_result.get_array())) {
            System.out.println("!!!!Тест не пройден!!!!");
        } else {
            System.out.println("Тест пройден");
        }
    }

    public static void scalar_multiplication_of_vectors(){
        Vector vector_1 = new Vector(new double[] {2, -1, 6, 11, 0});
        Vector vector_2 = new Vector(new double[] {-3, 1, 11, 0, -7});



        System.out.println("Тест скалярного произведения векторов");

        vector_1.print();
        vector_2.print();

        double result = Vector.scalar_multiplication_of_vectors(vector_1, vector_2);

        double expected_result = 59;

        System.out.println("Ожидаемый результат: 59");
        System.out.print("Полученный результат: ");
        System.out.println(result);


        if (expected_result != result){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void vector_multiplication_of_vectors(){
        Vector vector_1 = new Vector(new double[] {2, -1, 6});
        Vector vector_2 = new Vector(new double[] {-3, 1, 11});



        System.out.println("Тест векторного произведения векторов:");

        vector_1.print();
        vector_2.print();

        Vector vector_result = Vector.vector_multiplication_of_vectors(vector_1, vector_2);
        Vector expected_result = new Vector(new double[] {-17, -40, -1});

        System.out.println("Ожидаемое произведение: {-17, -40, -1}");
        System.out.print("Полученное произведение: ");
        vector_result.print();

        if (!Arrays.equals(vector_result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    // //////////////////////////////////////////////
    // МАТРИЦЫ
    // //////////////////////////////////////////////

    public static void create_zero_matrix(){
        Matrix matrix = Matrix.create_zero_matrix(3);



        System.out.println("Тест создания нулевой матрицы размера 3 X 3");


        Matrix expected_result = new Matrix(new double[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}});

        System.out.println("Ожидаемая матрица:");
        expected_result.print();
        System.out.println("Полученная матрица: ");
        matrix.print();

        if (!Arrays.deepEquals(matrix.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void create_identity_matrix(){
        Matrix matrix = Matrix.create_identity_matrix(3);



        System.out.println("Тест создания единичной матрицы размера 3 X 3");


        Matrix expected_result = new Matrix(new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});

        System.out.println("Ожидаемая матрица:");
        expected_result.print();
        System.out.println("Полученная матрица: ");
        matrix.print();

        if (!Arrays.deepEquals(matrix.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void transpose(){
        Matrix matrix = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});

        System.out.println("Тест транспонирования матрицы:");

        matrix.print();

        matrix.transpose();

        Matrix expected_result = new Matrix(new double[][] {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}});

        System.out.println("Ожидаемая матрица:");
        expected_result.print();
        System.out.println("Полученная матрица: ");
        matrix.print();

        if (!Arrays.deepEquals(matrix.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void sum_of_matrices(){
        Matrix matrix_1 = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix matrix_2 = new Matrix(new double[][] {{4, 3}, {2, 1}});

        System.out.println("Тест суммы матриц:");

        matrix_1.print();
        matrix_2.print();

        Matrix expected_result = new Matrix(new double[][] {{5, 5, 3}, {6, 6, 6}, {7, 8, 9}});
        Matrix result = Matrix.sum_of_matrices(matrix_1, matrix_2);

        System.out.println("Ожидаемая сумма:");
        expected_result.print();
        System.out.println("Полученная сумма: ");
        result.print();

        if (!Arrays.deepEquals(result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void multiplication_of_matrix_and_vector(){
        Matrix matrix = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Vector vector = new Vector(new double[] {2, 1, 3});

        System.out.println("Тест произведения матрицы и вектора:");

        matrix.print();
        vector.print();

        Vector expected_result = new Vector(new double[] {13, 31, 49});
        Vector result = Matrix.multiplication_of_matrix_and_vector(matrix, vector);

        System.out.println("Ожидаемое произведение:");
        expected_result.print();
        System.out.println("Полученное произведение: ");
        result.print();

        if (!Arrays.equals(result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void multiplication_of_matrices(){
        Matrix matrix_1 = new Matrix(new double[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        Matrix matrix_2 = new Matrix(new double[][] {{2, 0, 1}, {1, 3, 2}, {3, 1, 0}});

        System.out.println("Тест произведения матрицы и вектора:");

        matrix_1.print();
        matrix_2.print();

        Matrix expected_result = new Matrix(new double[][] {{13,  9,  5}, {31, 21, 14}, {49, 33, 23}});
        Matrix result = Matrix.multiplication_of_matrices(matrix_1, matrix_2);

        System.out.println("Ожидаемое произведение:");
        expected_result.print();
        System.out.println("Полученное произведение: ");
        result.print();

        if (!Arrays.deepEquals(result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void get_determinant_2x2(){
        Matrix matrix = new Matrix(new double[][] {{5, 3}, {2, 4}});

        System.out.println("Тест подсчёта детерминанта матрицы 2 x 2:");

        matrix.print();

        double expected_result = 14;
        double result = Matrix.get_determinant(matrix);

        System.out.print("Ожидаемый детерминант: ");
        System.out.println(expected_result);
        System.out.print("Полученный детерминант: ");
        System.out.println(result);

        if (expected_result != result){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void get_determinant_3x3(){
        Matrix matrix = new Matrix(new double[][] {{2, 0, 3}, {0, 1, 4},  {1, 0, -1}});

        System.out.println("Тест подсчёта детерминанта матрицы 3 x 3:");

        matrix.print();

        double expected_result = -5;
        double result = Matrix.get_determinant(matrix);

        System.out.print("Ожидаемый детерминант: ");
        System.out.println(expected_result);
        System.out.print("Полученный детерминант: ");
        System.out.println(result);

        if (expected_result != result){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void get_determinant_4x4(){
        Matrix matrix = new Matrix(new double[][] {{2, 0, 3, 1}, {0, 1, 4, 2},  {1, 0, -1, 3}, {0, 0, 2, 5}});

        System.out.println("Тест подсчёта детерминанта матрицы 4 x 4:");

        matrix.print();

        double expected_result = -35;
        double result = Matrix.get_determinant(matrix);

        System.out.print("Ожидаемый детерминант: ");
        System.out.println(expected_result);
        System.out.print("Полученный детерминант: ");
        System.out.println(result);

        if (expected_result != result){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    public static void get_inverse_matrix(){
        Matrix matrix = new Matrix(new double[][] {{1, 2 ,1}, {0, 1, 2},  {3, 1, 1}});

        System.out.println("Тест нахождения обратной матрицы:");

        matrix.print();

        Matrix expected_result = new Matrix(new double[][] {{-0.125, -0.125, 0.375}, {0.75, -0.25, -0.25}, {-0.375, 0.625, 0.125}});
        Matrix result = Matrix.get_inverse_matrix(matrix);

        System.out.print("Ожидаемая матрица: ");
        expected_result.print();
        System.out.print("Полученная матрица: ");
        result.print();

        if (!Arrays.deepEquals(result.get_array(), expected_result.get_array())){
            System.out.println("!!!!Тест не пройден!!!!");
        }else{
            System.out.println("Тест пройден");
        }
    }

    // //////////////////////////////////////////

    public static void run_tests(){
        System.out.println();
        System.out.println();

        Tests.sum_of_same_vectors();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.sum_of_different_vectors();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.add_vector_bigger_size();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.multiply_vector_on_const();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.divide_vector_on_const();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.normalize_vector();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.scalar_multiplication_of_vectors();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.vector_multiplication_of_vectors();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();


        Tests.create_zero_matrix();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.create_identity_matrix();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.transpose();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.sum_of_matrices();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.multiplication_of_matrix_and_vector();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.multiplication_of_matrices();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.get_determinant_2x2();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.get_determinant_3x3();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.get_determinant_4x4();

        System.out.println();
        System.out.println("//////////////////////////////");
        System.out.println();

        Tests.get_inverse_matrix();
    }
}
