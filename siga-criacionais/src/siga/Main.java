package siga;

/**
 * Ponto de entrada do SIGA (código INICIAL da atividade da Aula 6).
 *
 * Demonstra o acesso a dados nos dois fornecedores. O programa FUNCIONA, mas:
 * (1) nada garante que conexão e comando sejam do mesmo fornecedor;
 * (2) a montagem da consulta usa um método com parâmetros demais;
 * (3) qualquer parte do sistema pode instanciar seu próprio AcessoDados.
 * Sua tarefa é aplicar Abstract Factory, Builder e Singleton.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Padrões Criacionais (código inicial) ===\n");

        AcessoDados acessoMySQL = new AcessoDados(new FabricaMySQL());
        acessoMySQL.conectar();
        System.out.println();

        AcessoDados acessoPostgreSQL = new AcessoDados(new FabricaPostgreSQL());
        acessoPostgreSQL.conectar();
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