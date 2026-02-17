import java.util.ArrayList;

public class Protectora {
    private int idProtectora=0;
    private int id;
    private String ubicacion;
    private ArrayList<Animal> animales;

    public Protectora(String ubicacion){
        this.ubicacion=ubicacion;
        idProtectora++;
        this.id=idProtectora;
        this.animales=new ArrayList<>(); //NEW para Inicializar arraylist
    }

    //Constructor que nos da el arrayList
    public Protectora(String ubicacion,ArrayList<Animal> animales){
        this.ubicacion=ubicacion;
        this.idProtectora++;
        this.id=idProtectora;
        this.animales=animales;

    }

    public String getUbicacion() {
        return ubicacion;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public int getId() {
        return id;
    }

    public int getIdProtectora() {
        return idProtectora;
    }
    //Método revisión veterinaria
    public void revisionVeterinaria(Veterinario v) {
        for(Animal animal:animales){
            switch (v.getEspecialidad()) {
                case GENERICO:
                    //Trata a todo tipo de animal
                    if(animal instanceof PerroOGato){
                        //Si se vacunó hace más de un mes

                        ((PerroOGato)animal).actualizarFechaVacunacion();

                    }
                    else if(animal instanceof Pajaro) {
                        //pájaro
                        if(((Pajaro) animal).revisarPesoIdeal()){
                            System.out.println("Peso insuficiente. Se le pondrá una dieta específica");
                        }
                    }
                    else if( animal instanceof Pez){
                        //pez
                        ((Pez)animal).revisarPh();
                    }
                    else{
                    System.out.println("No hay información suficiente para tratarlo");
                }
                    break;
                case MAMIFEROS:
                    if(animal instanceof PerroOGato){
                        //Si se vacunó hace más de un mes

                        ((PerroOGato)animal).actualizarFechaVacunacion();

                    }
                    break;
                case PEQUENOS_ANIMALES:
                    if(animal instanceof Pajaro) {
                        //pájaro
                        if(((Pajaro) animal).revisarPesoIdeal()){
                            System.out.println("Peso insuficiente. Se le pondrá una dieta específica");
                        }
                    }
                    if( animal instanceof Pez){
                        //pez
                        ((Pez)animal).revisarPh();
            }
                    break;
            }
        }
    }
    //Método que nos permita  agrega un animal
    public void agregarAnimal(Animal a) {
        animales.add(a);
    }
}
