package Entities;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.util.List;

@Entity(name = "customers")
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerNumber;
    private String customerName;
    @Column(name = "contactFirstName")
    private String firstName;
    @Column(name = "contactLastName")
    private String lastName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    @ManyToOne
    private Employee salesRepEmployeeNumber;
    private String pattern = "#,###,###,###.00";
    @Transient
    private DecimalFormat creditLimit = new DecimalFormat(pattern);
    @OneToMany
    private List<Payment> payments;



    public Customer() {
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        boolean wrong = true;
        while(wrong){
            if (firstName.length()<=0){
                System.out.println("please enter your first name");
            }else{
                this.firstName = firstName;
                wrong = false;
            }
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        boolean wrong = true;
        while (wrong) {
            if (lastName.length() <= 0) {
                System.out.println("please enter your first name");
            } else {
                this.lastName = lastName;
                wrong = false;
            }
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(Employee salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public DecimalFormat getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(DecimalFormat creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", customerName='" + customerName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", salesRepEmployeeNumber=" + salesRepEmployeeNumber +
                ", creditLimit=" + creditLimit +
                '}';
    }
}
