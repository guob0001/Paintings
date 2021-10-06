package edu.kea.paintings.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Table(name = "galleries")
@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    //@ApiModelProperty(notes= "owner name")
    @Column
    private String owner;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int squareFeet;

    @OneToMany(mappedBy = "gallery", fetch =FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Artist> artists;
}
