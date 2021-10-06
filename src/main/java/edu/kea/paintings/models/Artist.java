package edu.kea.paintings.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Table(name = "artists")
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private int age;
    @Column
    private String primaryStyle;
    @Column(length = 40)
    private String nationality;
    @Column
    private Date date;
    @Enumerated(value = EnumType.STRING)
    @Column
    private Gender gender;

    @ManyToOne
    @JoinColumn(name= "gallery_id")
    private Gallery gallery;

}
