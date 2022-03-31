package DeutscheBank.HomeWork5;

public class Customer {
    private static int autoIncrementId = 0;
    private int id;
    private String username;
    private String last_name;
    private String first_name;
    private String phone;
    private String address;
    private String city;
    private String postal_code;
    private String country;

    public Customer(CustomerBuilder customerBuilder) {
        try {
            this.id = autoIncrementId++;
            this.username = customerBuilder.username;
            this.last_name = customerBuilder.last_name;
            this.first_name = customerBuilder.first_name;
            this.phone = customerBuilder.phone;
            this.address = customerBuilder.address;
            this.city = customerBuilder.city;
            this.postal_code = customerBuilder.postal_code;
            this.country = customerBuilder.country;
        }catch (Exception e){
            System.out.println("Exceptie: Nu se poate crea obiectul customer. (doar postal_code poate fi null)");
            //e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getUsername() {
        return username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", last_name='" + last_name + '\'' +
                ", first_name='" + first_name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    static class CustomerBuilder {
        private String username;
        private String last_name;
        private String first_name;
        private String phone;
        private String address;
        private String city;
        private String postal_code;
        private String country;

        public CustomerBuilder() {
        }

        public CustomerBuilder username(String username) {
            this.username = username;
            return this;
        }

        public CustomerBuilder last_name(String last_name) {
            this.last_name = last_name;
            return this;
        }

        public CustomerBuilder first_name(String first_name) {
            this.first_name = first_name;
            return this;
        }

        public CustomerBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CustomerBuilder postal_code(String postal_code) {
            this.postal_code = postal_code;
            return this;
        }

        public CustomerBuilder country(String country) {
            this.country = country;
            return this;
        }

        public Customer build() {
            if (username != null && first_name != null && last_name != null && phone != null && address != null && city != null && country != null) {
                return new Customer(this);
            }
            return null;
        }
    }
}