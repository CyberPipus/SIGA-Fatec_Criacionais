package siga;

/**
 *   - Etapa 4: transformar o AcessoDados em um Singleton.
 */
public class AcessoDados {
    private final FabricaBanco fabrica;

    public AcessoDados(FabricaBanco fabrica) {
        this.fabrica = fabrica;
    }
    public void conectar() {
        Conexao conexao = fabrica.criarConexao();
        Comando comando = fabrica.criarComando();
        conexao.abrir();
        comando.executar("SELECT * FROM aluno");
    }
}