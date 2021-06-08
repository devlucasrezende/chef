package br.com.gt.trainee.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_peoples")
public class Peoples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String aboutMe;
    private String favouriteFood;
    private Integer age;

    public Peoples(){

    }

    public Peoples(Long id, String name, String aboutMe, String favouriteFood, Integer age) {
        this.id = id;
        this.name = name;
        this.aboutMe = aboutMe;
        this.favouriteFood = favouriteFood;
        this.age = age;
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

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Peoples)) return false;
        Peoples peoples = (Peoples) o;
        return getId().equals(peoples.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}