
#  Taller programación reactiva y funcional
El proyecto es un proyecto Maven. Cargue las dependencias antes de correr los test o ejecutar
alguno de los archivos.
### Ejercicio 1: 
Crear una lista de mínimo 30 correos, de los cuales se le deben aplicar
los siguientes operadores:
- Distinct: para ver si hay correo repetido, si hay correos repetidos eliminarlos
- Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
- Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
- Saber la cantidad de correos que hay, sin usar un ciclo
- Saber la cantidad de correos gmail, hotmail y outlook sin usar un ciclo
- En la misma lista determinar si se envió un correo o no a cada uno de los correos, si se le envió cambiar el estado en la lista, todo esto respetando la inmutabilidad.


### Solución: 
Este primer ejercicio lo solucione mediante una clase utilitaria, que mediante metodos estaticos 
da solución a cada uno de los puntos del problema. la clase es:
```bash
  src/main/java/org/sofkau/email/services/EmailService.
```

En la carpeta test encontrará las pruebas para cada uno de los metodos de esta clase.

### Ejercicio 2: 
Crear un chat, un input donde lo que se ingrese sea almacenado en una
lista, para posteriormente cambiar en la lista las malas palabras, para
sos y compararlas con la lista del chat y si se encuentra una
reemplazarla por: ****, todo esto respetando los principios de la
programación reactiva


### Solución: 
Este ejercicio lo soluciones con la clase Chat, la cual tiene un método para examinar un flujo
de String comparar contra un set de malas palabras y si la contiene remplazarla por '****':
```bash
  src/main/java/org/sofkau/chat/Chat.
```

En la carpeta test encontrará una prueba para este método.
Adicional en el mismo paquete de la clase Chat, encontrará una clase ejecutable App,
ahi puede ingresar por consola mensajes y recibir una respuesta con las palabras cambiadas.

### Ejercicio 3:
Crear dos funciones, una para resolver derivadas y otras integrales, pero esta se deben usar s
i quiero hacer la contraria, es decir, si quiero hacer una derivada inversa o una integral inversa.


### Solución:
Este ejercicio no logré llegar a una solución completa, sin embargo hice un primer acercamiento creando 
una clase Calculus con 2 métodos para obtener derivadas e integrales de algunas funciones trigonométricas.

Para obtener una instancia de la clase, use el método estatico getCalculus.

De cada método hay un test que puede correr. 

## Autor

- [@mateog147](https://github.com/mateog147)


