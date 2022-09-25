import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {

	public static void main(String[] args) throws SQLException {

		String nome = "MOUSE";
		String descricao = "MOUSE SEM FIO";
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.recuperarConexao();
		
		String sql = "INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('" + nome + "', '" + descricao + "')";
		
		System.out.println(sql);

		Statement stm = connection.createStatement();
		stm.execute("INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES ('" + nome + "', '" + descricao + "')",
				Statement.RETURN_GENERATED_KEYS);

		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1);
			System.out.println("O ID criado foi: " + id);
		}

	}

}
