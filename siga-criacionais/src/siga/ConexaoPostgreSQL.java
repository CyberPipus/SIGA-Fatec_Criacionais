package siga;
/**
 * Implementação concreta da conexão para o banco de dados PostgreSQL.
 */
public class ConexaoPostgreSQL implements Conexao {
    @Override
    public void abrir() {
        System.out.println("[PostgreSQL] conexão aberta");
    }
    
}
