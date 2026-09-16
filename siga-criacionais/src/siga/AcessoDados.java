package siga;

public class AcessoDados {
    private static AcessoDados instancia;
    private final FabricaBanco fabrica;

    private AcessoDados(FabricaBanco fabrica) {
        this.fabrica = fabrica;
    }
    public static void inicializar(FabricaBanco fabrica) {
        if(instancia != null) {
            throw new IllegalStateException("O AcessoDados já está inicializado e não pode ser alterado.");
        }
        if (fabrica == null) {
            throw new IllegalArgumentException("A fábrica não pode ser nula.");
        }
        instancia = new AcessoDados(fabrica);
    }

    public static AcessoDados obterInstancia() {
        if (instancia == null) {
            throw new IllegalStateException("O AcessoDados não foi inicializado. Chame AcessoDados.inicializar(fabrica) primeiro.");
        }
        return instancia;
    }
    public void conectar() {
        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }
}