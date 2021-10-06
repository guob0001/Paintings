package edu.kea.paintings.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Table(name= "paintings")
@Entity
public class Painting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @ApiModelProperty(notes = "Id")
    private Long id;
    @Column
    @ApiModelProperty(notes = "artist name")
    private String artist;
    @Column
    @ApiModelProperty(notes = "price of this painting")
    private double price;
    @Column
    private String title;
    @Column
    private String genre;
    @Column
    private int year;

}
