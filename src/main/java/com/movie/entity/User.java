package com.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column(name = "ID")
    private String  userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_mobile_number", nullable = false, unique = true)
    private String userMobileNumber;

    @Column(name = "user_email_id", nullable = false, unique = true)
    private String emailId;

    @Column(name = "user_password")
    private String password;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "user", cascade = CascadeType.DETACH)
    private List<Booking> booking;

    @JsonIgnore
    @Transient
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Review> review;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserMobileNumber() {
        return this.userMobileNumber;
    }

    public String getEmailId() {
        return this.emailId;
    }

    public String getPassword() {
        return this.password;
    }

    public List<Booking> getBooking() {
        return this.booking;
    }

    public List<Review> getReview() {
        return this.review;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    @Transient
    public void setBooking(List<Booking> booking) {
        this.booking = booking;
    }

    @JsonIgnore
    public void setReview(List<Review> review) {
        this.review = review;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
