package siga;
/**
 * Implementação concreta do comando para o banco de dados MySQL.
 */
public class ComandoMySQL implements Comando {
    @Override
    public void executar(String sql) {
        System.out.println("[MySQL] executando: " + sql);
    }
}
