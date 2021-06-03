package io.javabrains.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column
    private String id;

    @Column
    private String game;

    @Column
    private String category;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Information information;
}
