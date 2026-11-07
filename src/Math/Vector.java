package Math;

import static java.lang.Math.*;

public class Vector {
    private double[] coordinates;

    public Vector() {
        coordinates = new double[0];
    }

    public Vector(int i){
        this.coordinates = new double[i];
    }

    public Vector(double[] coordinates){
        this.coordinates = coordinates;
    }

    public Vector(Vector vector) {
        coordinates = vector.get_coords_array();
    }

    public void scalar_multiply(double value){
        for(int i = 0; i < coords_count(); i++){
            multiply_coord(i, value);
        }
    }

    public void add_vector(Vector vector){
        for(int i = 0; i < min(coords_count(), vector.coords_count()); i++){
            add_to_coord(i, vector.get_coord(i));
        }
    }

    public void normalize(){
        double length = length();
        for(int i = 0; i < length(); i++){
            coordinates[i] = coordinates[i] / length;
        }
    }

    public static Vector sum_of_vectors(Vector Vector_1, Vector Vector_2){
        Vector Vector_sum = new Vector(max(Vector_1.coords_count(), Vector_2.coords_count()));

        for(int i = 0; i < Vector_1.coords_count(); i++){
            Vector_sum.add_to_coord(i, Vector_1.get_coord(i));
        }

        for(int i = 0; i < Vector_2.coords_count(); i++){
            Vector_sum.add_to_coord(i, Vector_2.get_coord(i));
        }

        return Vector_sum;
    }

    public static Vector normalize(Vector vector){
        double length = vector.length();

        Vector vector_normalized = new Vector(vector.coords_count());

        for (int i = 0; i < vector.coords_count(); i++){
            double coord_normalized = vector.get_coord(i) / length;
            vector_normalized.set_coord(i, coord_normalized);
        }

        return vector_normalized;
    }


    public void add_to_coord(int coord, double value){
        coordinates[coord] += value;
    }

    public void multiply_coord(int coord, double value){
        coordinates[coord] *= value;
    }

    public void set_coord(int coord, double value){
        coordinates[coord] = value;
    }

    public double length(){
        double sqrt_sum = 0;
        for (double val : coordinates){
            sqrt_sum += val * val;
        }
        return sqrt(sqrt_sum);
    }

    public int coords_count(){
        return coordinates.length;
    }

    public double get_coord(int i){
        return coordinates[i];
    }

    public double[] get_coords_array(){
        return coordinates;
    }
}
