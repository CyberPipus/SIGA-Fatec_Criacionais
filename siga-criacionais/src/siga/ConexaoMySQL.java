package siga;
/**
 * Implementação concreta da conexão para o banco de dados MySQL.
 */
public class ConexaoMySQL implements Conexao {
    @Override
    public void abrir() {
        System.out.println("[MySQL] conexão aberta");
    }
}