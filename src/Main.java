import Math.Vector;

public class Main {
    public static void main(String[] args) {
        double[] arr_1 = {0, 2, 4, 6};
        double[] arr_2 = {1, 3, 5, 7, 9, 11};

        Vector vector_1 = new Vector(arr_1);
        Vector vector_2 = new Vector(arr_2);

        Vector vector_sum = Vector.sum_of_vectors(vector_1 , vector_2);

        for(int i = 0; i < vector_sum.coords_count(); i++){
            System.out.print(vector_sum.get_coord(i));
            System.out.print(", ");
        }

        System.out.println();

        Vector vector_norm = Vector.normalize(vector_sum);

        for(int i = 0; i < vector_sum.coords_count(); i++){
            System.out.print(vector_sum.get_coord(i));
            System.out.print(", ");
        }

        System.out.println();

        for(int i = 0; i < vector_norm.coords_count(); i++){
            System.out.print(vector_norm.get_coord(i));
            System.out.print(", ");
        }
    }
}