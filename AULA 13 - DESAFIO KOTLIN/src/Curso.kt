class Curso(val nome: String,
            val codigo: Int,
            val codigoprofessorTitular: Int,
            val codigoprofessorAdjunto: Int,
            val quantidadeMaxAlunos: Int) {
    val listaDeAlunos = arrayListOf<Aluno>()

    fun adicionarUmAluno(umAluno: Aluno,
                         quantidadeMaxAlunos: Int): Boolean{
        if(listaDeAlunos.size >= quantidadeMaxAlunos)
            return false
        else{
            listaDeAlunos.add(umAluno)
            return true
        }
    }
    fun excluirAluno(umAluno: Int){
        var i = 0
        listaDeAlunos.forEach{
            if (umAluno == codigo)
                listaDeAlunos.removeAt(i)
            println("Aluno excluido")
            i++
        }
    }
}