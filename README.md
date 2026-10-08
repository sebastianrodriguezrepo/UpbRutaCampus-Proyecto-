#  Campus UPB - Sistema Inteligente de Rutas y Accesibilidad

Proyecto de software desarrollado en **Java** utilizando una interfaz gráfica moderna (Java Swing) para el cálculo de rutas óptimas dentro del campus de la **Universidad Pontificia Bolivariana (UPB) - Seccional Bucaramanga**. El sistema implementa estructuras de datos personalizadas y lógica de grafos de manera académica para optimizar la movilidad y accesibilidad de la comunidad universitaria.

---

##  Características Principales

* **Estructuras de Datos Propias:** Implementación nativa de listas de adyacencia (`Nodo`, `ListaEnlazada`, `Grafo`) sin depender de colecciones avanzadas externas, cumpliendo con los requerimientos de la asignatura de Estructuras de Datos.
* **Algoritmo de Ruta Óptima:** Búsqueda del camino más corto utilizando lógica inspirada en **Dijkstra** adaptada a los pesos de las aristas (conteo de pasos entre edificios).
* **Filtro de Accesibilidad:** Opción para excluir tramos con escaleras, generando rutas totalmente accesibles para personas con movilidad reducida.
* **Gestión de Cierres Temporales (Mantenimiento):** Menú selector dinámico para bloquear edificios temporalmente y recalcular rutas alternas en tiempo real.
* **Interfaz Gráfica Moderna (GUI):** Vistas limpias organizadas en tarjetas institucionales, paleta de colores corporativa y soporte visual de mapas del campus.

---

##  Tecnologías y Herramientas
* **Lenguaje:** Java (POO)
* **Interfaz Gráfica:** Java Swing
* **Entorno de Desarrollo:** Visual Studio Code / NetBeans
* **Control de Versiones:** Git & GitHub
* **Diseño UI:** Figma

---

##  Arquitectura del Proyecto

El proyecto está modularizado de forma limpia para separar la lógica de datos, los algoritmos y la interfaz de usuario:

* `GrafoListasAdyacencia.java`: Clase principal (`main`) que inicializa la aplicación con un diseño visual moderno.
* `VentanaInicio.java`: Pantalla de bienvenida institucional con el logo oficial de la UPB.
* `VentanaCampus.java`: Panel de control interactivo para la selección de origen, destino, filtros de escaleras y edificios en mantenimiento.
* `VentanaResultado.java`: Vista final que muestra el camino detallado y el conteo de pasos calculados por el algoritmo.
* `Grafo.java` & `ListaEnlazada.java` & `Nodo.java`: Núcleo lógico que administra la red de adyacencia del campus y el algoritmo de búsqueda.

---

##  Cómo Ejecutar el Proyecto

1. Asegúrate de tener instalado **Java JDK** en tu equipo.
2. Clona este repositorio o descarga los archivos fuente en una carpeta local.
3. Asegúrate de incluir las imágenes institucionales (`logo_upb.png` y `mapa_ruta.png`) en la raíz del proyecto para que la interfaz las cargue correctamente.
4. Compila y ejecuta desde la terminal o tu entorno de desarrollo favorito:
   ```bash
   javac *.java
   java GrafoListasAdyacencia
