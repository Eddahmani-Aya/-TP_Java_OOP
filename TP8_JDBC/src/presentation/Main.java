package presentation;


import java.sql.*;

public class Main {

	public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";
        String password = "AYATON223"; // si tu as un mdp, mets-le ici

        try {
            // 1. Charger driver (facultatif en Java 8+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connexion
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion réussie !");

            // 3. Exemple d’insertion
            String sql = "INSERT INTO users(name) VALUES (?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "Amina");
            ps.executeUpdate();

            // 4. Lecture
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
