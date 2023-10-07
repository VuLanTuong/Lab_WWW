package models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company;
    private Date fromDate;
    private String role;
    private Date toDate;
    private String workDescription;

    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }
}
