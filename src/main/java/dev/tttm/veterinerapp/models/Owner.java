package dev.tttm.veterinerapp.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="firstName", nullable = false)
    @NotEmpty(message = "Lütfen isim giriniz!")
    private String firstName;

    @Column(name="lastName", nullable = false)
    @NotEmpty(message = "Lütfen soyisim giriniz!")
    private String lastName;

    @Column(name="address", nullable = false)
    @NotEmpty(message = "Lütfen adres giriniz!")
    private String address;

    @Column(name="email", nullable = false, unique = true)
    @NotEmpty(message = "Lütfen email giriniz!")
    @Email(message = "Lütfen geçerli bir email giriniz")
    private String email;

    @Column(name="phone", nullable = false)
    @NotEmpty(message = "Lütfen telefon numarası giriniz!")
    private String phone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE)
    private List<Pet> pets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
