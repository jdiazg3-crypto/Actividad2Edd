# Ejercicio 21: Comparador Bubble Sort vs Insertion Sort

Asignatura: Estructuras de datos · Ingeniería del software · Universidad de Cartagena
Taller práctico Unidad 3: algoritmos de ordenamiento.

## Descripción
Compara Bubble Sort optimizado e Insertion Sort, implementados manualmente, sobre tres
arreglos con los mismos elementos: aleatorio (con repetidos), casi ordenado e inverso.
Cada algoritmo trabaja sobre su propia copia y se registran comparaciones,
intercambios/desplazamientos y tiempo de ejecución.

## Estructura
- `src/BubbleSortOptimizado.java`: Bubble con bandera de parada anticipada.
- `src/InsertionSort.java`: Insertion Sort con conteo de desplazamientos.
- `src/GeneradorArreglos.java`: genera las tres distribuciones.
- `src/Resultado.java` y `src/Utilidades.java`: apoyo.
- `src/Main.java`: demostración visual y experimentos (n = 10, 100, 1000, 5000).
- `src/Pruebas.java`: casos de borde y verificación de contadores.

## Cómo ejecutar
Requiere JDK 17 o superior.
```bash
javac -d out src/*.java
java -cp out Main
java -cp out Pruebas
```
También puede ejecutarse desde IntelliJ IDEA con el botón Run sobre `Main`.

## Complejidad temporal
| Algoritmo | Mejor caso | Caso promedio | Peor caso | Estable | Memoria extra |
|---|---|---|---|---|---|
| Bubble optimizado | O(n) | O(n²) | O(n²) | Sí | O(1) |
| Insertion | O(n) | O(n²) | O(n²) | Sí | O(1) |

## Análisis
- **Aleatorio:** ambos son cuadráticos. Los movimientos son iguales (cada intercambio de
  Bubble y cada desplazamiento de Insertion corrige una inversión), pero Bubble hace
  aproximadamente el doble de comparaciones.
- **Casi ordenado:** Insertion se acerca a O(n), porque cada elemento casi no se desplaza.
  Bubble mejora gracias a la bandera, pero cada pase recorre el arreglo completo.
- **Inverso:** es el peor caso de ambos, con n(n-1)/2 movimientos.
- **Conclusión:** Insertion Sort se adapta mejor a datos casi ordenados y en general hace
  menos comparaciones. Bubble sirve para aprender el concepto.