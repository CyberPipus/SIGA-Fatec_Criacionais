package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais ===\n");

        AcessoDados.inicializar(new FabricaMySQL());
        AcessoDados acessoMySQL = AcessoDados.obterInstancia();
        acessoMySQL.conectar();

        System.out.println();

        AcessoDados acessoDuploMySQL = AcessoDados.obterInstancia();
        System.out.println("Mesma instância? (MySQL): " + (acessoMySQL == acessoDuploMySQL));

        System.out.println();

        try {
            AcessoDados.inicializar(new FabricaPostgreSQL());
        } catch (IllegalStateException e) {
            System.out.println("Não podemos inicializar novamente: " + e.getMessage());
        }

        System.out.println();

        System.out.println("Famílias produzidas por cada fábrica:");

        FabricaBanco fabricaMySQL = new FabricaMySQL();
        fabricaMySQL.criarConexao().abrir();
        fabricaMySQL.criarComando().executar("SELECT * FROM aluno");

        System.out.println();

        FabricaBanco fabricaPostgreSQL = new FabricaPostgreSQL();
        fabricaPostgreSQL.criarConexao().abrir();
        fabricaPostgreSQL.criarComando().executar("SELECT * FROM aluno");

        System.out.println();

        String consulta = new ConsultaBuilder("aluno")
                .comFiltro("curso = 'DSM'")
                .comOrdenacao("nome")
                .comLimite(50)
                .comOffset(0)
                .comSomenteAtivos(true)
                .construir();
        System.out.println("Consulta montada: " + consulta);
    }
}