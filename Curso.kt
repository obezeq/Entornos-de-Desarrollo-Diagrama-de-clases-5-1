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