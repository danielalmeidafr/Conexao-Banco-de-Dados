import connection.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Connection connection = DataBaseConnection.getInstance().connection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuarios");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");

                usuarios.add(new Usuario(nome, email));
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }

        usuarios.forEach(usuario -> System.out.println(usuario.getNome() + " " + usuario.getEmail()));

    }
}
