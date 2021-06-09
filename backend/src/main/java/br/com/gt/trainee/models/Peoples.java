package br.com.gt.trainee.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tb_peoples")
public class Peoples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String aboutMe;
    @NotNull
    private String favouriteFood;
    @NotNull
    @Min(1)
    private Integer age;

}