package com.cydeo.entity;

import com.cydeo.repository.PaymentRepository;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;

    @ManyToMany(mappedBy = "items")
    private List<Cart> carts;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }


}
