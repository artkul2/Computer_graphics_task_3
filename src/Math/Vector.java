package Math;

import java.text.DecimalFormat;

import static java.lang.Math.*;

public class Vector {
    private double[] coordinates;

    public Vector(int i){
        if (i == 0) {
            throw new IllegalArgumentException("Вектор не может быть пустым");
        }

        this.coordinates = new double[i];
    }

    public Vector(double[] coordinates){
        if (coordinates == null || coordinates.length == 0) {
            throw new IllegalArgumentException("Вектор не может быть пустым");
        }

        this.coordinates = coordinates.clone();
    }

    public Vector(Vector vector) {
        coordinates = vector.get_array().clone();
    }

    public void multiply_vector_on_const(double value){
        for(int i = 0; i < size(); i++){
            multiply_value(i, value);
        }
    }

    public void divide_vector_on_const(double value){
        if (value == 0){
            throw new IllegalArgumentException("Деление вектора на 0");
        }

        multiply_vector_on_const(1 / value);
    }

    public void add_vector(Vector vector){
        for(int i = 0; i < min(size(), vector.size()); i++){
            add_to_value(i, vector.get_value(i));
        }
    }

    public void subtract_vector(Vector vector){
        for(int i = 0; i < min(size(), vector.size()); i++){
            add_to_value(i, -1 * vector.get_value(i));
        }
    }

    public void normalize(){
        double length = length();

        if (length == 0){
            throw new IllegalArgumentException("Нулевой вектор нельзя нормализовать");
        }

        for(int i = 0; i < length(); i++){
            coordinates[i] = coordinates[i] / length;
        }
    }

    public static Vector sum_of_vectors(Vector Vector_1, Vector Vector_2){
        Vector Vector_sum = new Vector(max(Vector_1.size(), Vector_2.size()));

        for(int i = 0; i < Vector_1.size(); i++){
            Vector_sum.add_to_value(i, Vector_1.get_value(i));
        }

        for(int i = 0; i < Vector_2.size(); i++){
            Vector_sum.add_to_value(i, Vector_2.get_value(i));
        }

        return Vector_sum;
    }

    public static Vector dif_of_vectors(Vector Vector_1, Vector Vector_2){
        Vector Vector_sum = new Vector(max(Vector_1.size(), Vector_2.size()));

        for(int i = 0; i < Vector_1.size(); i++){
            Vector_sum.add_to_value(i, Vector_1.get_value(i));
        }

        for(int i = 0; i < Vector_2.size(); i++){
            Vector_sum.add_to_value(i, -1 * Vector_2.get_value(i));
        }

        return Vector_sum;
    }

    public static Vector normalize(Vector vector){
        double length = vector.length();

        if (length == 0){
            throw new IllegalArgumentException("Нулевой вектор нельзя нормализовать");
        }

        Vector vector_normalized = new Vector(vector.size());

        for (int i = 0; i < vector.size(); i++){
            double coord_normalized = vector.get_value(i) / length;
            vector_normalized.set_value(i, coord_normalized);
        }

        return vector_normalized;
    }

    public static double scalar_multiplication_of_vectors(Vector vector_1, Vector vector_2){
        if (vector_1.size() != vector_2.size()) {
            throw new IllegalArgumentException("Векторы разной длинны");
        }

        double sum = 0;

        for(int i = 0; i < vector_1.size(); i++){
            sum += vector_1.get_value(i) * vector_2.get_value(i);
        }

        return sum;
    }

    public static Vector vector_multiplication_of_vectors(Vector vector_1, Vector vector_2){
        if (vector_1.size() != 3 || vector_2.size() != 3) {
            throw new IllegalArgumentException("Векторы не трёхмерные");
        }

        Vector vector_out = new Vector(3);

        double temp = vector_1.get_value(1) * vector_2.get_value(2) - vector_1.get_value(2) * vector_2.get_value(1);
        vector_out.set_value(0, temp);

        temp = vector_1.get_value(2) * vector_2.get_value(0) - vector_1.get_value(0) * vector_2.get_value(2);
        vector_out.set_value(1, temp);

        temp = vector_1.get_value(0) * vector_2.get_value(1) - vector_1.get_value(1) * vector_2.get_value(0);
        vector_out.set_value(2, temp);

        return vector_out;    //Заглушка
    }


    public void add_to_value(int coord, double value){
        coordinates[coord] += value;
    }

    public void multiply_value(int coord, double value){
        coordinates[coord] *= value;
    }

    public void set_value(int coord, double value){
        coordinates[coord] = value;
    }

    public double length(){
        double sqrt_sum = 0;
        for (double val : coordinates){
            sqrt_sum += val * val;
        }
        return sqrt(sqrt_sum);
    }

    public int size(){
        return coordinates.length;
    }

    public double get_value(int i){
        return coordinates[i];
    }

    public double[] get_array(){
        return coordinates;
    }

    public void print(){
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.print("{");
        for(int i = 0; i < size() - 1; i++){
            System.out.print(df.format(get_value(i)));
            System.out.print(", ");
        }
        System.out.print(df.format(get_value(size() - 1)));
        System.out.println("}");
    }
}
