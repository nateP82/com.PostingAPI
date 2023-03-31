package com.posting.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "first_name", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;
    @Basic
    @Column(name = "business", nullable = true, length = 50)
    private String business;
    @Basic
    @Column(name = "phone_primary", nullable = false, length = 11)
    private String phonePrimary;
    @Basic
    @Column(name = "phone_secondary", nullable = true, length = 11)
    private String phoneSecondary;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "street_address", nullable = false, length = 100)
    private String streetAddress;
    @Basic
    @Column(name = "city", nullable = false, length = 100)
    private String city;
    @Basic
    @Column(name = "state_abbr", nullable = false, length = 2)
    private String stateAbbr;
    @Basic
    @Column(name = "zip_code", nullable = false, length = 15)
    private String zipCode;
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Invoice> invoicesById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getPhonePrimary() {
        return phonePrimary;
    }

    public void setPhonePrimary(String phonePrimary) {
        this.phonePrimary = phonePrimary;
    }

    public String getPhoneSecondary() {
        return phoneSecondary;
    }

    public void setPhoneSecondary(String phoneSecondary) {
        this.phoneSecondary = phoneSecondary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(business, user.business) && Objects.equals(phonePrimary, user.phonePrimary) && Objects.equals(phoneSecondary, user.phoneSecondary) && Objects.equals(email, user.email) && Objects.equals(streetAddress, user.streetAddress) && Objects.equals(city, user.city) && Objects.equals(stateAbbr, user.stateAbbr) && Objects.equals(zipCode, user.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, business, phonePrimary, phoneSecondary, email, streetAddress, city, stateAbbr, zipCode);
    }

    public Collection<Invoice> getInvoicesById() {
        return invoicesById;
    }

    public void setInvoicesById(Collection<Invoice> invoicesById) {
        this.invoicesById = invoicesById;
    }
}
