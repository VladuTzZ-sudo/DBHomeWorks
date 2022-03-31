package DeutscheBank.HomeWork5;

import java.sql.Date;

public class Order {
    private static int autoIncrementId = 0;
    private int id;
    private Date order_date;
    private Date shipped_date;
    private String status;
    private String comments;
    private int customer_id;

    public Order(OrderBuilder orderBuilder) {
        try {
            this.id = autoIncrementId++;
            this.order_date = orderBuilder.order_date;
            this.shipped_date = orderBuilder.shipped_date;
            this.status = orderBuilder.status;
            this.comments = orderBuilder.comments;
            this.customer_id = orderBuilder.customer_id;
        }catch (Exception e){
            System.out.println("Exceptie: Nu se poate crea obiectul order.");
        }
    }

    public int getId() {
        return id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public Date getShipped_date() {
        return shipped_date;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public String getComments() {
        return comments;
    }

    public String getStatus() {
        return status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public void setShipped_date(Date shipped_date) {
        this.shipped_date = shipped_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", order_date=" + order_date +
                ", shipped_date=" + shipped_date +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", customer_id=" + customer_id +
                '}';
    }

    static class OrderBuilder {
        private Date order_date;
        private Date shipped_date;
        private String status;
        private String comments;
        private int customer_id = -1;

        public OrderBuilder() {
        }

        public OrderBuilder order_date(Date order_date) {
            this.order_date = order_date;
            return this;
        }

        public OrderBuilder shipped_date(Date shipped_date) {
            this.shipped_date = shipped_date;
            return this;
        }

        public OrderBuilder status(String status) {
            this.status = status;
            return this;
        }

        public OrderBuilder comments(String comments) {
            this.comments = comments;
            return this;
        }

        public OrderBuilder customer_id(Integer customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public Order build() {
            if (order_date != null && status != null && customer_id != -1) {
                return new Order(this);
            }
            return null;
        }
    }
}