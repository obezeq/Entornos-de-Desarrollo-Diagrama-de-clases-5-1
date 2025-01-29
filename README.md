# Trabajo: Implementación de Clases Curso y Estudiante en Kotlin

## 1. Interpretación del Diagrama de Clases

### a) Relación entre las clases
- **Tipo de relación**: Asociación unidireccional.
- **Significado**: Un `Estudiante` puede inscribirse en un `Curso`, pero el `Curso` no tiene conocimiento directo del `Estudiante` fuera de su lista.
- **Multiplicidad**:
    - Un `Curso` puede tener **0..*** estudiantes (lista mutable).
    - Un `Estudiante` puede inscribirse en **0..*** cursos.

### b) Elementos de las clases
#### Clase `Curso`
- **Atributos**:
    - `nombre: String`: Nombre del curso.
    - `codigo: String`: Código identificador del curso.
    - `estudiantes: MutableList<Estudiante>`: Lista dinámica de estudiantes inscritos.
- **Propósito**: Gestionar la información y estudiantes asociados a un curso.

#### Clase `Estudiante`
- **Atributos**:
    - `nombre: String`: Nombre del estudiante.
    - `dni: String`: Documento de identidad del estudiante.
- **Propósito**: Representar a un estudiante y permitir su inscripción en cursos.

### c) Método `agregarAlumno()`
- **Significado**: Añade un estudiante a la lista del curso.
- **Funcionamiento**: Recibe un objeto `Estudiante` y lo agrega a la lista `estudiantes`.

### d) Método `inscribirse()`
- **Significado**: Permite que un estudiante se registre en un curso.
- **Funcionamiento**: El estudiante invoca este método y pasa un `Curso` como parámetro. Internamente, el curso añade al estudiante a su lista.

---

## 2. Generación de Código

### a) Clases implementadas
#### Clase `Curso`
```kotlin
class Curso(
    val nombre: String,
    val codigo: String
) {
    private val estudiantes: MutableList<Estudiante> = mutableListOf()

    fun agregarAlumno(estudiante: Estudiante) {
        estudiantes.add(estudiante)
    }

    fun mostrarEstudiantes() {
        println("Estudiantes inscritos en $nombre:")
        estudiantes.forEach { println("- ${it.nombre} (DNI: ${it.dni})") }
    }
}
```

#### Clase `Estudiante`
```kotlin
class Estudiante(
    val nombre: String,
    val dni: String
) {
    fun inscribirse(curso: Curso) {
        curso.agregarAlumno(this)
        println("$nombre se ha inscrito en el curso ${curso.nombre}.")
    }
}
```

### b) Relaciones implementadas
- La relación se logra mediante el método `inscribirse()`, donde un `Estudiante` pasa su instancia (`this`) al método `agregarAlumno()` del `Curso`.

### c) Clase `Main` para pruebas
```kotlin
fun main() {
    // Crear cursos
    val cursoMatematicas = Curso("Matemáticas", "MAT-101")
    val cursoHistoria = Curso("Historia", "HIS-202")

    // Crear estudiantes
    val estudiante1 = Estudiante("Ana López", "12345678A")
    val estudiante2 = Estudiante("Carlos Ruiz", "87654321B")

    // Inscripciones
    estudiante1.inscribirse(cursoMatematicas)
    estudiante2.inscribirse(cursoMatematicas)
    estudiante1.inscribirse(cursoHistoria)

    // Mostrar estudiantes inscritos
    cursoMatematicas.mostrarEstudiantes()
    cursoHistoria.mostrarEstudiantes()
}
```