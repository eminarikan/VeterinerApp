package dev.tttm.veterinerapp.models;

import dev.tttm.veterinerapp.api.entity.AddPetDto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="pets")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private Owner owner;

    public static Pet from(AddPetDto petDto) {
        Pet p = new Pet(petDto.getName(),
                petDto.getBreed(),
                petDto.getAge(),
                petDto.getType(),
                petDto.getDescription());
        return p;
    }
    public Pet(String name, String breed, int age, String type, String description){
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.type = type;
        this.description = description;
    }
    public Pet(){}
    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                '}';
    }

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

    public void update(AddPetDto petDto) {
        this.name = petDto.getName();
        this.age = petDto.getAge();
        this.breed = petDto.getBreed();
        this.type = petDto.getType();
        this.description = petDto.getDescription();
    }
}
