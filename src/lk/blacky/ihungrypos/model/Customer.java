package lk.blacky.ihungrypos.model;

public class Customer {
    private String custId;
    private String name;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer() {
    }

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId='" + custId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
