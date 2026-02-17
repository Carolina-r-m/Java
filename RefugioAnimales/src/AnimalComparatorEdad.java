import java.util.Comparator;
//En el caso de que las dos comparaciones edad y nombre, sean independientes

public class AnimalComparatorEdad implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        //Edad
        return a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento());
    }
}
