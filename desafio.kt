// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Aluno(val nome: String, val matricula: String) {
        override fun toString(): String {
            return "$nome - matricula: $matricula"
        }
    }

data class ConteudoEducacional(val nome: String, val duracao: Int = 60) {
        override fun toString(): String {
            return "$nome: duracao $duracao horas"
        }
}

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Aluno>()

    fun matricular(vararg alunos: Aluno){
        inscritos.addAll(alunos)
    }

    override fun toString(): String{
        return """
            Nome: $nome
            Nivel: $nivel
            Conteudo Educacional: $conteudos
            Alunos inscritos: $inscritos
            
        """.trimIndent()
    }
}

fun main() {
    val ven = Aluno("Venilton", "012345")
    val gui = Aluno("Guilherme", "678910")

    val kotlin = ConteudoEducacional("Kotlin", 117)
    val java = ConteudoEducacional("Java", 150)
    val ed = ConteudoEducacional("Estrutura de Dados", 130)
    val bd = ConteudoEducacional("Banco de Dados", 90)
    val logicaProgramacao = ConteudoEducacional("Logica de Programacao", 120)

    val desenvolvedorWeb = Formacao(
        "Desenvolvedor Web",
        Nivel.BASICO,
        listOf(logicaProgramacao, ed,kotlin)
    )

    val desenvolvedorBackEnd = Formacao(
        "Desenvolvedor BackEnd",
        Nivel.AVANCADO,
        listOf(logicaProgramacao, ed, bd, java)
    )

    desenvolvedorWeb.matricular(ven)
    desenvolvedorBackEnd.matricular(gui)

    println(desenvolvedorWeb)
    println(desenvolvedorBackEnd)
}
