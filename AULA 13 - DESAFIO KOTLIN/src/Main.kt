
fun main(){
    var aluno = Aluno("","",0)
    var professor = Professor("","",0,0)
    var professorTitular = ProfessorTitular("","",0,0, "")
    var professorAdjunto = ProfessorAdjunto("","",0,0, 0)
    var curso = Curso("", 0, 0, 0,0)
    var matricula = Matricula(0,0,0)
    var listaAlunos = ArrayList<Aluno>()
    var listaProfessores = ArrayList<Professor>()
    var listaProfessoresAdjunto = ArrayList<ProfessorAdjunto>()
    var listaProfessoresTitular = ArrayList<ProfessorTitular>()
    var listaCursos = ArrayList<Curso>()
    var listaMatriculas = ArrayList<Matricula>()
    var digitalHouseManager = DigitalHouseManager(listaAlunos, listaProfessores, listaProfessoresAdjunto, listaProfessoresTitular, listaCursos, listaMatriculas)
    var respostaMenu = 1
    //listaAlunos = arrayListOf(), listaProfessores = arrayListOf(), listaDeCursos = arrayListOf(), listDeMatriculas = arrayListOf()

    while (respostaMenu != 0){
        println("*************************************")
        println("1 - Registrar um aluno")
        println("2 - matricular um aluno")
        println("3 - excluir um aluno")
        println("4 - lista de Alunos")

        println("5 - registrar um professor titular")
        println("6 - registrar um professor adjunto")
        println("7 - excluir um professor")
        println("8 - lista de professores")

        println("9 - registrar um curso")
        println("10 - excluir um curso")
        println("11 - lista de cursos")

        println("12 - Lista de matriculas")

        println("0 - encerrar!")
        println("*************************************")
        respostaMenu = readLine()!!.toInt()

        if (respostaMenu == 0){
//"0 - encerrar!"
            break
        }else if(respostaMenu == 1){
//"1 - Registrar um aluno"
            print("Digite o nome do Aluno: ")
            var nome = readLine()!!.toString()
            print("Digite o Sobrenome do Aluno: ")
            var sobrenome = readLine()!!.toString()
            print("Digite um código não usado para o Aluno: ")
            var codigo = readLine()!!.toInt()
            var cont = 0
            var i = 0
            digitalHouseManager.listaAlunos.forEach{aluno
                if(digitalHouseManager.listaAlunos[i].codigo == codigo)
                    cont++
            }
            if (cont > 0) {
                println("Codigo de Aluno já existente")
                println("Aluno não registrado")
                continue
            }
            digitalHouseManager.registrarAluno(nome, sobrenome, codigo)
            println("Aluno registrado")
        }else if(respostaMenu == 2){
//"2 - matricular um aluno"
            print("Digite um código de aluno válido: ")
            var codigoaluno = readLine()!!.toInt()
            print("Digite um codigo de curso valido: ")
            var codigocurso = readLine()!!.toInt()
            digitalHouseManager.matricularAluno(codigoaluno, codigocurso)
            println("Aluno matriculado")
            var i = 0
            digitalHouseManager.listaCursos.forEach{curso
                var codCur = digitalHouseManager.listaCursos[i].codigo
                if (codCur == codigocurso)
                    curso.listaDeAlunos.add(digitalHouseManager.listaAlunos[i])
                i++
            }


        }else if(respostaMenu == 3){
//"3 - excluir um aluno"
            print("Digite o codigo do aluno a ser excluido: ")
            var codigo = readLine()!!.toInt()
            curso.excluirAluno(codigo)

        }else if(respostaMenu == 4){
//"4 - lista de Alunos"
            var i = 0
            println("*************************************")
            println("Lista de todos os alunos registrados: ")
            digitalHouseManager.listaAlunos.forEach{aluno
                var nomeal = digitalHouseManager.listaAlunos[i].nome
                var codial = digitalHouseManager.listaAlunos[i].codigo
                println("Codigo Aluno: " + codial + "   Nome Aluno: " + nomeal)
                i++
            }
            println("*************************************")
                println("")
        }else if(respostaMenu == 5){
//"5 - registrar um professor titular"
            print("Digite o nome do Professor titular: ")
            var nome = readLine()!!.toString()
            print("Digite o Sobrenome do Professor titular: ")
            var sobrenome = readLine()!!.toString()
            print("Digite o tempo de casa do professor titular: ")
            var tempo = readLine()!!.toInt()
            print("Digite um código não usado para o Professor titular: ")
            var codigo = readLine()!!.toInt()
            print("Digite a especialidade do Professor titular: ")
            var especialidade = readLine()!!.toString()
            var cont = 0
            var i = 0
            digitalHouseManager.listaProfessoresTitular.forEach{professor
                if(digitalHouseManager.listaProfessoresTitular[i].codigo == codigo)
                    cont++
            }
            if (cont > 0) {
                println("Codigo de Professor titular já existente")
                println("Professor titular não registrado")
                continue
            }
            digitalHouseManager.registrarProfessorTitular(nome, sobrenome, tempo, codigo, especialidade)
            println("Professor titular registrado")


        }else if(respostaMenu == 6){
//"6 - registrar um professor adjunto"
            print("Digite o nome do Professor adjunto: ")
            var nome = readLine()!!.toString()
            print("Digite o Sobrenome do Professor adjunto: ")
            var sobrenome = readLine()!!.toString()
            print("Digite o tempo de casa do professor adjunto: ")
            var tempo = readLine()!!.toInt()
            print("Digite um código não usado para o Professor adjunto: ")
            var codigo = readLine()!!.toInt()
            print("Digite o tempo de monitoria do Professor adjunto: ")
            var horasMonitoria = readLine()!!.toInt()
            var cont = 0
            var i = 0
            digitalHouseManager.listaProfessoresAdjunto.forEach{professor
                if(digitalHouseManager.listaProfessoresAdjunto[i].codigo == codigo)
                    cont++
            }
            if (cont > 0) {
                println("Codigo de Professor adjunto já existente")
                println("Professor adjunto não registrado")
                continue
            }
            digitalHouseManager.registrarProfessorAdjunto(nome, sobrenome, tempo, codigo, horasMonitoria)
            println("Professor adjunto registrado")


        }else if(respostaMenu == 7){
//"7 - excluir um professor"
            print("Digite o codigo do professor a ser excluido: ")
            var codigo = readLine()!!.toInt()
            digitalHouseManager.excluirProfessor(codigo)


        }else if(respostaMenu == 8){
//"8 - lista de professores"
            var i = 0
            println("*************************************")
            println("Lista de todos os professores registrados: ")
            digitalHouseManager.listaProfessores.forEach{professor
                var nomeprof = digitalHouseManager.listaProfessores[i].nome
                var codprof = digitalHouseManager.listaProfessores[i].codigo
                println("Codigo Professor: " + codprof + "   Nome Professor: " + nomeprof)
                i++
            }
            println("*************************************")
            println("")

        }else if(respostaMenu == 9){
//"9 - registrar um curso"
            var i = 0
            var cont1 = 0
            var cont2 = 0
            var cont3 = 0
            print("Digite o nome do curso: ")
            var nome = readLine()!!.toString()
            print("Digite um código não usado para o curso: ")
            var codigo = readLine()!!.toInt()
            println("Digite um código de professor titular valido: ")
            var codigoProfessorTitular = readLine()!!.toInt()
            println("Digite um código de professor adjunto valido: ")
            var codigoProfessorAdjunto = readLine()!!.toInt()
            println("Digite a quantidade maxima de alunos: ")
            var quantidadeMaximaAlunos = readLine()!!.toInt()

            digitalHouseManager.listaCursos.forEach{curso
                if(digitalHouseManager.listaCursos[i].codigo == codigo)
                    cont1++
            }
            digitalHouseManager.listaProfessoresTitular.forEach{professor
                if(digitalHouseManager.listaProfessoresTitular[i].codigo == codigoProfessorTitular)
                    cont2++
            }
            digitalHouseManager.listaProfessoresAdjunto.forEach{professor
                if(digitalHouseManager.listaProfessoresAdjunto[i].codigo == codigoProfessorAdjunto)
                    cont3++
            }
            if (cont1 > 0) {
                println("Codigo de Curso já existente")
                println("Curso não registrado")
                continue
            }
            if (cont2 == 0) {
                println("Professor Titular invalido")
                println("Curso não registrado")
                continue
            }
            if (cont3 == 0) {
                println("Professor Adjunto invalido")
                println("Curso não registrado")
                continue
            }
            digitalHouseManager.registrarCurso(nome, codigo, codigoProfessorTitular, codigoProfessorAdjunto, quantidadeMaximaAlunos)
            println("Curso registrado")


        }else if(respostaMenu == 10){
//"10 - excluir um curso"
            print("Digite o codigo do curso a ser excluido: ")
            var codigo = readLine()!!.toInt()
            digitalHouseManager.excluirCurso(codigo)

        }else if(respostaMenu == 11){
//"11 - lista de cursos"
            var i = 0
            println("*************************************")
            println("Lista de todos os cursos registrados: ")
            digitalHouseManager.listaCursos.forEach{curso
                var nomeCur = digitalHouseManager.listaCursos[i].nome
                var codCur = digitalHouseManager.listaCursos[i].codigo
                println("Codigo Curso: " + codCur + "   Nome Curso: " + nomeCur)
                i++
            }
            println("*************************************")
            println("")
        }else if(respostaMenu == 12){
//"12 - Lista de matriculas"
/*            var i = 0
            println("*************************************")
            println("Lista de todas as matriculas registrados: ")
            digitalHouseManager.listaDeMatriculas.forEach{matricula
                digitalHouseManager.listaAlunos.forEach{aluno
                    if(digitalHouseManager.listaAlunos[i].codigo == digitalHouseManager.listaDeMatriculas[i].)
                        var nomealu = digitalHouseManager.listaAlunos[i].nome
                }

                var nomeCurso = digitalHouseManager.listaCursos[i].codigo


                println("Codigo Curso: " + codCur + "   Nome Curso: " + nomeCur)
                i++
            }
            println("*************************************")
            println("")

*/
        }else{
//"Resposta invalida"
            println("Resposta invalida")
        }

    }
}