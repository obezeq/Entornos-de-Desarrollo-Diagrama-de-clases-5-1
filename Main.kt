fun main() {
    // CREAMOS LOS CURSOS
    val cursoMatematicas = Curso("Matemáticas", "MAT-101")
    val cursoHistoria = Curso("Historia", "HIS-202")

    // CREAMOS LOS ESTUDIANTES
    val estudiante1 = Estudiante("Ana López", "12345678A")
    val estudiante2 = Estudiante("Carlos Ruiz", "87654321B")

    // INSSCRIPCIONES
    estudiante1.inscribirse(cursoMatematicas)
    estudiante2.inscribirse(cursoMatematicas)
    estudiante1.inscribirse(cursoHistoria)

    // MOSTRAMOS CON ESTO LSO ESTUDIANTES INSCRITOS
    cursoMatematicas.mostrarEstudiantes()
    cursoHistoria.mostrarEstudiantes()
}