package dev.tttm.veterinerapp.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable = false)
    @NotEmpty(message = "Lütfen hayvanın adını giriniz!")
    private String name;

    @Column(name="type", nullable = false)
    @NotEmpty(message = "Lütfen hayvanın türünü giriniz!")
    private String type;

    @Column(name="breed", nullable = false)
    @NotEmpty(message = "Lütfen hayvanın cinsini giriniz!")
    private String breed;

    @Column(name="age", nullable = false)
    @NotNull(message = "Yaş rakam olmalıdır!")
    private int age;

    @Column(name="description", nullable = false)
    @NotEmpty(message = "Lütfen açıklama giriniz!")
    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH, targetEntity = Owner.class, fetch = FetchType.EAGER)
    private Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
