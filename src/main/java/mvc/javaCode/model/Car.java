package mvc.javaCode.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String mark;
    @Column
    private String color;
    @Column
    private int number;


    public Car(String mark, String color, int number) {
        this.mark = mark;
        this.color = color;
        this.number = number;
    }
}