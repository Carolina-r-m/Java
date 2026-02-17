import java.util.Comparator;
//En el caso de que las dos comparaciones edad y nombre, sean independientes

public class AnimalComparatorNombre implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return a1.getNombre().compareToIgnoreCase(a2.getNombre());
    }
}
