class Estudiante(
    val nombre: String,
    val dni: String
) {
    fun inscribirse(curso: Curso) {
        curso.agregarAlumno(this)
        println("$nombre se ha inscrito en el curso ${curso.nombre}.")
    }
}