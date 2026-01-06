package Ex01;

public class Main {
    static void main() {
        DatabaseConnection connection =
                DatabaseConnection.getInstance("jdbc:mysql://localhost:3306/mydatabase");
        connection.connect();

    }
}
