package Math;

public class VectorOfThreeDimensions extends Vector{
    public VectorOfThreeDimensions(int size) {
        if (size != 3){
            throw new IllegalArgumentException("Размер не равен 3");
        }
        super(size);
    }

    public VectorOfThreeDimensions(double[] coordinates) {
        if (coordinates.length != 3){
            throw new IllegalArgumentException("Размер массива не равен 3");
        }
        super(coordinates);
    }

    public VectorOfThreeDimensions(Vector vector) {
        if (vector.size() != 3){
            throw new IllegalArgumentException("Размер вектора не равен 3");
        }
        super(vector);
    }

    public static Vector vector_multiplication_of_vectors(VectorOfThreeDimensions vector_1, VectorOfThreeDimensions vector_2){
        Vector vector_out = new Vector(3);

        double temp = vector_1.get_value(1) * vector_2.get_value(2) - vector_1.get_value(2) * vector_2.get_value(1);
        vector_out.set_value(0, temp);

        temp = vector_1.get_value(2) * vector_2.get_value(0) - vector_1.get_value(0) * vector_2.get_value(2);
        vector_out.set_value(1, temp);

        temp = vector_1.get_value(0) * vector_2.get_value(1) - vector_1.get_value(1) * vector_2.get_value(0);
        vector_out.set_value(2, temp);

        return vector_out;    //Заглушка
    }
}
