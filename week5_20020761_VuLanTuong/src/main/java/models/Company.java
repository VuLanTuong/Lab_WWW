package models;

import jakarta.persistence.*;

@Table
@Entity
public class Company {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private long compId;
    private String about;
    private String email;
    private String compName;
    private String phone;
    private String web_url;

    @OneToOne
    @JoinColumn(name = "add_id")
    private Address address;

    public Company() {
    }
}
