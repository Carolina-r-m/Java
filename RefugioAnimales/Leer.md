Refugio de Animales
Descripción de la actividad
Implementa un programa en Java que permita la gestión de un refugio de animales,
siguiendo la descripción que se aporta.
Descripción del Problema:
La Junta de Extremadura requiere una nueva aplicación que le permita gestionar
las protectoras y refugios de animales de las distintas localidades. Para ello,
partimos de los siguientes requisitos:
● La aplicación debe gestionar las protectoras y los veterinarios que tiene
contratados.
● De cada protectora conocemos su identificador único, ubicación y sus
animales.
● Los animales que acogen los refugios pueden ser perros, gatos, pájaros
y peces. De todos ellos se conoce id, nombre, fecha de nacimiento y peso.
Además, si es pájaro se debe conocer la especie y su peso ideal; si es
perro o gato la raza y la fecha de la última vacunación; y si es pez se debe
conocer el color, el ph actual y el ph apropiado para el agua. En ocasiones
muy puntuales llegan otro tipo de animales, como caballos, iguanas… de
los que solo nos interesa almacenar la información genérica.
● De los veterinarios conocemos su id, nombre, dirección, nombre de la
clínica para la que trabaja y especialidad (pequeños animales, mamíferos,
genérico)
La Junta solicita que su aplicación permita realizar las siguientes operaciones:
1. Gestión de protectora. Muestra todas las protectoras y pide seleccionar
una para realizar en ella una de las siguientes opciones:
a. Nuevo animal: inserta un animal en la protectora
b. Revisión veterinaria: se escoge al primer veterinario que aparece
en la lista, que será el encargado de revisar los animales, teniendo
en cuenta que si es de la especialidad pequeños animales solo
podrá atender a pájaros y peces; si es de la especialidad
mamíferos podrá atender a perros y gatos y si es genérico podrá
atender a todos los animales.
En la revisión, si algún perro o gato se vacunó hace más de un
mes, deberá volver a vacunarse, actualizando la fecha
correspondiente. Para los peces se comprueba el PH del agua y
en caso de que no sea el correcto se modifica. Para los pájaros, se
comprueba que tienen el peso adecuado, si no es así se indicará
que se le va a poner una dieta específica. Si es un animal
desconocido, se indicará que no tiene información suficiente para
tratarlo.
Al finalizar las revisiones, el veterinario responsable pasará a
ocupar la última posición de la lista.
c. Mostrar animales: muestra los animales del refugio ordenados por
edad (de menor a mayor) y por nombre alfabéticamente.
2. Salir
Evaluación
Criterios de calificación
● Definición correcta de las clases y sus atributos. (0.5 punto)
● Definición correcta de las relaciones entre clases. (0.5 puntos)
● Uso correcto de herencia (2 puntos).
● Funcionalidad completa de nuevo animal. (2 puntos)
● Funcionalidad completa de revisión veterinaria. (3 puntos)
● Funcionalidad completa de mostrar animales. (2 puntos)
Lista de penalizaciones
● El programa no compila (-10 puntos).
● Plagio o uso de IA (-10 puntos).
● Nomenclatura incorrecta (-1 punto). Se entiende por un correcto uso de la
nomenclatura la aplicación de las siguientes reglas:
1. Atributos y Métodos en formato camelCase.
2. Clases y tipos Enumerados comienzan por letra Mayúscula.
3. Atributos finales en MAYÚSCULA
● Uso de toString (-1 punto por cada clase que lo implemente)
