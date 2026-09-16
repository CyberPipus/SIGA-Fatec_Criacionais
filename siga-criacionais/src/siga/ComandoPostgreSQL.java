package siga;
/**
 * Implementação concreta do comando para o banco de dados PostgreSQL.
 */
public class ComandoPostgreSQL implements Comando {
    @Override
    public void executar(String sql) {
        System.out.println("[PostgreSQL] executando: " + sql);
    }
    
}
