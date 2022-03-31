package DeutscheBank.HomeWork5;

import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonParser;
import com.mysql.cj.xdevapi.JsonValue;
import spark.Spark;


import java.sql.Date;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        Spark.get("/hello", (req, res) -> "Hello, world!");
        Spark.post("/hello", (req, res) -> "Hello, world!");
        Spark.get("/hello/:name", (req, res) -> {
            return "Hello, " + req.params(":name") + '!';
        });

        ArrayList<Customer> customers = new ArrayList<>();
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<OrderDetails> orderDetails = new ArrayList<>();

        orderDetails.add(new OrderDetails.OrderDetailsBuilder().id(0).product_code("99").priceEach(2.33).quantity(55).build());
        orderDetails.add(new OrderDetails.OrderDetailsBuilder().id(1).product_code("77").priceEach(2.66).quantity(100).build());
        orderDetails.add(new OrderDetails.OrderDetailsBuilder().id(2).product_code("55").priceEach(2.44).quantity(900).build());

        // [CUSTOMER] GET by ID
        Spark.get("/customer/:id", (req, res) -> {
            for (Customer customer : customers) {
                if (customer.getId() == Integer.parseInt(req.params(":id"))) {
                    return "Customer " + customer.getId() + "@" + customer.getUsername() + " (last_name=" + customer.getLast_name() +
                            " first_name=" + customer.getFirst_name() + " phone=" + customer.getPhone() + " address=" +
                            customer.getAddress() + " city=" + customer.getCity() + " country=" + customer.getCountry();
                }
            }

            return "The Customer " + req.params(":id") + "@_" + " was not found!";
        });

        // [CUSTOMER] GET ALL
        Spark.get("/customer/", (req, res) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Customer customer : customers) {
                stringBuilder.append("Customer ").append(customer.getId()).append("@").append(customer.getUsername()).
                        append(" (last_name=").append(customer.getLast_name()).append(" first_name=").append(customer.getFirst_name()).
                        append(" phone=").append(customer.getPhone()).append(" address=").append(customer.getAddress()).append(" city=").
                        append(customer.getCity()).append(" country=").append(customer.getCountry()).append("\n");
            }

            return stringBuilder.toString();
        });

        // [CUSTOMER] PUT CREATE
        Spark.put("/customer/:country/:city/:username/:last_name/:first_name/:address/:phone", (req, res) -> {
            customers.add(new Customer.CustomerBuilder()
                    .username(req.params(":username"))
                    .last_name(req.params(":last_name"))
                    .first_name(req.params(":first_name"))
                    .phone(req.params(":phone"))
                    .address(req.params(":address"))
                    .city(req.params(":city"))
                    .country(req.params(":country"))
                    .build());

            return "Customer @" + req.params(":username") + " (last_name=" + req.params(":last_name") + " first_name=" +
                    req.params(":first_name") + " phone=" + req.params(":phone") + " address=" + req.params(":address") +
                    " city=" + req.params(":city") + " country=" + req.params(":country");
        });

        /*Spark.post("/customer/:id/:X", (req, res) -> {
            for (Customer customer : customers) {
                if (customer.getId() == Integer.parseInt(req.params(":id"))) {
                    switch ("{:X}") {
                        case "country":
                            break;
                        case "city":
                            break;
                        case "username":
                            break;
                        case "last_name":
                            break;
                        case "first_name":
                            break;
                        case "address":
                            break;
                        case "phone":
                            break;
                        default:
                            System.out.println("{:X}");
                            return "[ERROR] There is no field=" + req.params(":X") + "to update!";
                    }
                }
            }

            return "Customer @" + req.params(":username") + " (last_name=" + req.params(":last_name") + " first_name=" +
                    req.params(":first_name") + " phone=" + req.params(":phone") + " address=" + req.params(":address") +
                    " city=" + req.params(":city") + " country=" + req.params(":country");
        });*/

        // [CUSTOMER] PUT UPDATE
        Spark.put("/customer/:id/:country/:city/:username/:last_name/:first_name/:address/:phone", (req, res) -> {
            for (Customer customer : customers) {
                if (customer.getId() == Integer.parseInt(req.params(":id"))) {
                    customer.setCountry(req.params(":country"));
                    customer.setCity(req.params(":city"));
                    customer.setUsername(req.params(":username"));
                    customer.setLast_name(req.params(":last_name"));
                    customer.setFirst_name(req.params(":first_name"));
                    customer.setAddress(req.params(":address"));
                    customer.setPhone(req.params(":phone"));

                    return "Customer @" + req.params(":username") + " (last_name=" + req.params(":last_name") + " first_name=" +
                            req.params(":first_name") + " phone=" + req.params(":phone") + " address=" + req.params(":address") +
                            " city=" + req.params(":city") + " country=" + req.params(":country");
                }
            }

            customers.add(new Customer.CustomerBuilder()
                    .username(req.params(":username"))
                    .last_name(req.params(":last_name"))
                    .first_name(req.params(":first_name"))
                    .phone(req.params(":phone"))
                    .address(req.params(":address"))
                    .city(req.params(":city"))
                    .country(req.params(":country"))
                    .build());

            return "Customer @" + req.params(":username") + " (last_name=" + req.params(":last_name") + " first_name=" +
                    req.params(":first_name") + " phone=" + req.params(":phone") + " address=" + req.params(":address") +
                    " city=" + req.params(":city") + " country=" + req.params(":country");
        });

        // [CUSTOMER] delete by ID
        Spark.delete("/customer/:id", (req, res) -> {
            customers.removeIf(customer -> customer.getId() == Integer.parseInt(req.params(":id")));
            return "Deleted the Customer " + req.params(":id") + "@" + req.params(":username") + " (last_name="
                    + req.params(":last_name") + " first_name=" + req.params(":first_name");
        });

        // [ORDER] GET by ID
        Spark.get("/order/:id", (req, res) -> {
            for (Order order : orders) {
                if (order.getId() == Integer.parseInt(req.params(":id"))) {
                    return "Order " + order.getId() + "@" + order.getCustomer_id() + " order_date=" + order.getOrder_date() +
                            " shipped_date=" + order.getShipped_date() +
                            " comments=" + order.getComments() + " status=" + order.getStatus();
                }
            }

            return "The Order " + req.params(":id") + "@_" + " was not found!";
        });

        // [ORDER] GET ALL
        Spark.get("/order/", (req, res) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (Order order : orders) {
                stringBuilder.append("Order ").append(order.getId()).append("@").append(order.getCustomer_id())
                        .append(" order_date=").append(order.getOrder_date()).append(" shipped_date=").append(order.getShipped_date())
                        .append(" comments=").append(order.getComments()).append(" status=").append(order.getStatus()).append("\n");
            }

            return stringBuilder.toString();
        });

        Spark.get("/order", (req, res) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (String values : req.queryParamsValues("customer_id")){
                for (Order order : orders){
                    if (order.getCustomer_id() == Integer.parseInt(values)){
                        stringBuilder.append("Order ").append(order.getId()).append("@").append(order.getCustomer_id())
                                .append(" order_date=").append(order.getOrder_date()).append(" shipped_date=").append(order.getShipped_date())
                                .append(" comments=").append(order.getComments()).append(" status=").append(order.getStatus()).append("\n");
                    }
                }
            }
            return stringBuilder.toString();
        });

        // [ORDER] PUT CREATE
        Spark.put("/order/:customer_id/:shipped_date/:order_date/:status/:comments", (req, res) -> {
            orders.add(new Order.OrderBuilder()
                    .customer_id(Integer.valueOf(req.params(":customer_id")))
                    .shipped_date(Date.valueOf(req.params(":shipped_date")))
                    .order_date(Date.valueOf(req.params(":order_date")))
                    .status(req.params(":status"))
                    .comments(req.params(":comments"))
                    .build());

            return "Order " + orders.get(orders.size() - 1).getId() + "@" + orders.get(orders.size() - 1).getCustomer_id() +
                    " order_date=" + orders.get(orders.size() - 1).getOrder_date() +
                    " shipped_date=" + orders.get(orders.size() - 1).getShipped_date() +
                    " comments=" + orders.get(orders.size() - 1).getComments() + " status=" + orders.get(orders.size() - 1).getStatus();
        });

        /*Spark.post("/customer/:id/:X", (req, res) -> {
            for (Customer customer : customers) {
                if (customer.getId() == Integer.parseInt(req.params(":id"))) {
                    switch ("{:X}") {
                        case "country":
                            break;
                        case "city":
                            break;
                        case "username":
                            break;
                        case "last_name":
                            break;
                        case "first_name":
                            break;
                        case "address":
                            break;
                        case "phone":
                            break;
                        default:
                            System.out.println("{:X}");
                            return "[ERROR] There is no field=" + req.params(":X") + "to update!";
                    }
                }
            }

            return "Customer @" + req.params(":username") + " (last_name=" + req.params(":last_name") + " first_name=" +
                    req.params(":first_name") + " phone=" + req.params(":phone") + " address=" + req.params(":address") +
                    " city=" + req.params(":city") + " country=" + req.params(":country");
        });*/

        // [ORDER] PUT UPDATE STATUS ( doar atat zice in cerinta )
        Spark.put("/order/:id/:status", (req, res) -> {
            for (Order order : orders) {
                if (order.getId() == Integer.parseInt(req.params(":id"))) {
                    order.setStatus(req.params(":status"));

                    return "Order " + orders.get(orders.size() - 1).getId() + "@" + orders.get(orders.size() - 1).getCustomer_id() +
                            " order_date=" + orders.get(orders.size() - 1).getOrder_date() +
                            " shipped_date=" + orders.get(orders.size() - 1).getShipped_date() +
                            " comments=" + orders.get(orders.size() - 1).getComments() + " status=" + orders.get(orders.size() - 1).getStatus();
                }
            }

            return "The Order " + req.params(":id") + "@_" + " was not found!";
        });

        // [ORDER] delete by ID
        Spark.delete("/order/:id", (req, res) -> {
            orders.removeIf(order -> order.getId() == Integer.parseInt(req.params(":id")));
            return "Deleted the Order " + req.params(":id") + "@" + req.params(":customer_id");
        });

        // [ORDERDETAILS] get by id JSON
        Spark.get("/orderdetails/:order_id", (req, res) -> {
            for (OrderDetails array : orderDetails) {
                if (array.getId() == Integer.parseInt(req.params(":order_id"))) {
                    return new Gson().toJson(array) + "\n" + "{product_code : " + new Gson().toJson(array.getProduct_code()) + "}";
                }
            }

            return "There are no orderdetails  " + req.params(":order_id") + "@_" + " was not found!";
        });
    }
}
