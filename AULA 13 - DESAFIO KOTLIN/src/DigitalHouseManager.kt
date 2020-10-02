import java.time.LocalDateTime
class DigitalHouseManager(var listaAlunos: ArrayList<Aluno>,
                          var listaProfessores: ArrayList<Professor>,
                          var listaProfessoresAdjunto: ArrayList<ProfessorAdjunto>,
                          var listaProfessoresTitular: ArrayList<ProfessorTitular>,
                          var listaCursos: ArrayList<Curso>,
                          var listaDeMatriculas: ArrayList<Matricula>) {

    fun registrarCurso(nome: String,
                       codigoCurso: Int,
                       professorTitular: Int,
                       professorAdjunto: Int,
                       quantidadeMaximaDeAlunos: Int){
        listaCursos.add(Curso(nome, codigoCurso, professorTitular, professorAdjunto, quantidadeMaximaDeAlunos))
    }
    fun excluirCurso(codigoCurso: Int){
        var i = 0
        listaCursos.forEach{
            if (listaCursos[i].codigo == codigoCurso) {
                listaCursos.removeAt(i)
                println("Curso removido")
            }
            i++
        }
    }
    fun registrarProfessorAdjunto(nome: String,
                                  sobrenome: String,
                                  tempoCasa: Int,
                                  codigoProfessor: Int,
                                  quantidadeDeHoras: Int){
        listaProfessoresAdjunto.add(ProfessorAdjunto(nome, sobrenome, tempoCasa,codigoProfessor, quantidadeDeHoras))
        listaProfessores.add(Professor(nome, sobrenome, tempoCasa, codigoProfessor))

    }
    fun registrarProfessorTitular(nome: String,
                                  sobrenome: String ,
                                  tempoCasa: Int,
                                  codigoProfessor: Int,
                                  especialidade: String ){
        listaProfessoresTitular.add(ProfessorTitular(nome, sobrenome, tempoCasa,codigoProfessor, especialidade))
        listaProfessores.add(Professor(nome, sobrenome, tempoCasa, codigoProfessor))

    }
    fun excluirProfessor(codigoProfessor: Int){
        var i = 0
        listaProfessores.forEach{
            if (listaProfessores[i].codigo == codigoProfessor) {
                listaProfessores.removeAt(i)
                println("Professor removido")
            }
            i++
        }

    }
    fun registrarAluno(nome: String,
                        sobrenome: String,
                        codigoAluno: Int){
        listaAlunos.add(Aluno(nome, sobrenome, codigoAluno))
    }
    fun matricularAluno(codigoAluno: Int,
                        codigoCurso: Int){
        var hora = 0
        listaDeMatriculas.add(Matricula(codigoAluno, codigoCurso, hora))


    }
    fun alocarProfessores(codigoCurso: Int,
                          codigoProfessorTitular: Int,
                          codigoProfessorAdjunto: Int){

    }
}