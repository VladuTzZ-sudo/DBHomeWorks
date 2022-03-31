package DeutscheBank.HomeWork4;

import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.sql.*;
import java.util.ArrayList;

public class Test {
    /*public static Customer getById(Connection connection, int id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM customers WHERE id =" + id);

        try {
            rs.next();
            return new Customer.CustomerBuilder()
                    .id(rs.getInt("id"))
                    .username(rs.getString("username"))
                    .last_name(rs.getString("last_name"))
                    .first_name(rs.getString("first_name"))
                    .phone(rs.getString("phone"))
                    .address(rs.getString("address"))
                    .city(rs.getString("city"))
                    .postal_code(rs.getString("postal_code"))
                    .country(rs.getString("country")).build();
        } catch (Exception e) {
            System.out.println("Nu exista un obiect customer cu id = " + id);
        }
        return null;
    }

    public static ArrayList<Customer> getAll(Connection connection) throws SQLException {
        // Intrucat aplic metoda pentru a crea o lista de customers, am eliminat string-ul tableName din argumente.
        String tableName = "customers";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM " + tableName);

        ArrayList<Customer> customers = new ArrayList<>();

        while(rs.next()) {
            System.out.println("id: " + rs.getInt("id"));
            System.out.println("username: " + rs.getString("username"));
            System.out.println("last_name: " + rs.getString("last_name"));
            System.out.println("first_name: " + rs.getString("first_name"));
        }

        return customers;
    }

    public static void update(Connection connection, Customer customer) throws SQLException {
        Statement statement = connection.createStatement();

        // As fi existat si varianta sa dau delete la old customer si apoi sa dau insert la new customer, dar mi-am zis ca scopul exercitiului este sa folosesc comanda UPDATE si am scris asa !
        // De asemenea am considerat un singur update mai eficient decat daca as fi facut mai multe update-uri intr-o bucla (pt fiecare coloana).
//        ResultSet resultSet = statement.executeQuery("UPDATE customers SET username = " + customer.getUsername() + ", last_name = " + customer.getLast_name() + ", first_name = " +
        //               customer.getFirst_name() + ", phone = " + customer.getPhone() + ", address = " + customer.getAddress() + ", city = " + customer.getCity() + ", postal_code = " + customer.getPostal_code() +
        //             ", country = " + customer.getCountry() + " WHERE id = " + customer.getId());

        PreparedStatement ps = connection.prepareStatement("UPDATE customers SET username = ?, last_name = ?, first_name = ?, phone = ?, address = ?, city = ?, postal_code = ?, country= ? WHERE id = ?");
        ps.setString(1, customer.getUsername());
        ps.setString(2, customer.getLast_name());
        ps.setString(3, customer.getFirst_name());
        ps.setString(4, customer.getPhone());
        ps.setString(5, customer.getAddress());
        ps.setString(6, customer.getCity());
        ps.setString(7, customer.getPostal_code());
        ps.setString(8, customer.getCountry());
        ps.setInt(9, customer.getId());
        ps.execute();
    }

    public static void insert(Connection connection, Customer customer) throws SQLException {
        PreparedStatement ps = connection.prepareStatement("INSERT INTO customers (id, username, last_name, first_name, phone, address, city, postal_code, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        ps.setInt(1, customer.getId());
        ps.setString(2, customer.getUsername());
        ps.setString(3, customer.getLast_name());
        ps.setString(4, customer.getFirst_name());
        ps.setString(5, customer.getPhone());
        ps.setString(6, customer.getAddress());
        ps.setString(7, customer.getCity());
        ps.setString(8, customer.getPostal_code());
        ps.setString(9, customer.getCountry());
        ps.execute();
    }

    public static int delete(Connection connection, int id) {
        // DELETE FROM table_name WHERE condition;

        try {
            Statement statement = connection.createStatement();
            int rs = statement.executeUpdate("DELETE FROM customers WHERE id = " + id);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    // M-am gandit ca argumentele din select pot sa nu existe, dar cumva o conditie de where ar fi
    // obligatorie in cazul unui filter de aceea am ales un ArrayList<Expression> pt expresii si vaargs pt arg din select.
    public static void filter(Connection connection, String table, ArrayList<org.springframework.expression.Expression> expressions, String... f_args) throws SQLException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT ");
        if (f_args.length >= 1) {
            int i = 0;
            for (String arg : f_args) {
                i++;
                if (i < f_args.length) {
                    stringBuilder.append(arg).append(", ");
                } else {
                    stringBuilder.append(arg).append(" FROM ").append(table).append(" ");
                }
            }
        } else {
            stringBuilder.append("* FROM ").append(table).append(" ");
        }

        if (expressions.size() > 0) {
            stringBuilder.append("WHERE ");
            int  i = 0;
            for (Expression expression : expressions){
                i++;
                if (i < expressions.size()){
                    stringBuilder.append(expression.getExpressionString()).append(" AND ");
                }else{
                    stringBuilder.append(expression.getExpressionString());
                }
            }
        }

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(stringBuilder.toString());

        while (resultSet.next()) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
            {
                System.out.print(resultSetMetaData.getColumnName(i) + " -> ");
                switch (resultSetMetaData.getColumnType(i)){
                    case Types.INTEGER -> System.out.println(resultSet.getInt(i));
                    case Types.BIGINT -> System.out.println(resultSet.getBigDecimal(i));
                    case Types.BLOB -> System.out.println(resultSet.getBlob(i));
                    case Types.DOUBLE -> System.out.println(resultSet.getDouble(i));
                    case Types.DATE -> System.out.println(resultSet.getDate(i));
                    case Types.FLOAT -> System.out.println(resultSet.getFloat(i));
                    case Types.TIMESTAMP -> System.out.println(resultSet.getTimestamp(i));
                    case Types.TIME -> System.out.println(resultSet.getTime(i));
                    case Types.VARCHAR -> System.out.println(resultSet.getString(i));
                }
            }
        }
    }

    /*public static void insertOrder(Connection connection, String date, String status, int customerId) throws SQLException {

        try {
            // getById(connection, customerId);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO orders (order_date, status,customer_id) VALUES (?, ?, ?)");

            preparedStatement.setDate(1, Date.valueOf(date));
            preparedStatement.setString(2, status);

            preparedStatement.setInt(3, customerId);
            preparedStatement.execute();
            System.out.println(preparedStatement.getUpdateCount());
        } catch (SQLException e) {
            System.out.println("nu exista un customer cu acel id.");
        }
    }*/

    public static void main(String[] args) throws SQLException {
        String connectionUrl = "jdbc:mysql://localhost:3306/shop";
        String username = "vlad";
        String password = "Mateivlad2001.";
        Connection connection = DriverManager.getConnection(connectionUrl, username, password);

        /*for (Customer customer : getAll(connection)) {
            System.out.println(customer);
        }

        Customer update_customer = new Customer.CustomerBuilder().address("acasa").username("utilizator5").city("iasi_modified").country("India").id(19).phone("12312313").last_name("nume").first_name("nume").build();
        //insert(connection, update_customer);
        update(connection, update_customer);
        System.out.println();
        for (Customer customer : getAll(connection)) {
            System.out.println(customer);
        }

        delete(connection, 3);

        System.out.println();
        for (Customer customer : getAll(connection)) {
            System.out.println(customer);
        }*/

        // Am folosit SpringFramework.expression.Expression deoarece ma gandesc ca poate oferi mult mai multa functionalitate.
        // Cumva poate as vrea chiar sa testez in cod o expresie inainte de a o folosi in sql.. in orice caz am incercat sa gasesc
        // o solutie mai buna decat un simplu string. Adaugarea intr-un arraylist ofera libertatea de a adauga oricate expresii,
        // aceasta fiind o alternativa la faptul ca o functie nu poate accepta decat o singura posibilitate de vaargs.
//        ArrayList<org.springframework.expression.Expression> expressions = new ArrayList<>();
//        expressions.add(new SpelExpressionParser().parseExpression("id <= 20"));
//        expressions.add(new SpelExpressionParser().parseExpression("address = 'acasa'"));
//        System.out.println();
//        System.out.println("TEST FILTER");
//        filter(connection,"customers", expressions, "id", "username", "first_name", "last_name", "address", "city", "country");
//        System.out.println();
//
//        expressions.add(new SpelExpressionParser().parseExpression("city = 'iasi'"));
//        filter(connection, "customers" ,expressions);


    }
}
