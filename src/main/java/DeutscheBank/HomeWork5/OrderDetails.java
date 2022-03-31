package DeutscheBank.HomeWork5;

public class OrderDetails {
    private int id;
    private String product_code;
    private Double priceEach;
    private int quantity;

    public OrderDetails(OrderDetailsBuilder orderDetailsBuilder) {
        try {
            this.id = orderDetailsBuilder.id;
            this.product_code = orderDetailsBuilder.product_code;
            this.priceEach = orderDetailsBuilder.priceEach;
            this.quantity = orderDetailsBuilder.quantity;
        } catch (Exception e) {
            System.out.println("Exceptie: Nu se poate crea obiectul order.");
        }
    }

    public int getId() {
        return id;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", product_code='" + product_code + '\'' +
                ", priceEach=" + priceEach +
                '}';
    }

    static class OrderDetailsBuilder {
        private int id;
        private String product_code;
        private Double priceEach;
        private int quantity;

        public OrderDetailsBuilder() {
        }

        public OrderDetailsBuilder id(int id) {
            this.id = id;
            return this;
        }

        public OrderDetailsBuilder product_code(String product_code) {
            this.product_code = product_code;
            return this;
        }

        public OrderDetailsBuilder priceEach(Double priceEach) {
            this.priceEach = priceEach;
            return this;
        }

        public OrderDetailsBuilder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderDetails build() {
            if (quantity != 0 && priceEach != 0) {
                return new OrderDetails(this);
            }
            return null;
        }
    }
}