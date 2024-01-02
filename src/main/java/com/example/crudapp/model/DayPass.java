package com.example.crudapp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="DayPass")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class DayPass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Reason for the day pass
    private String reason;



    // Approval statuses
    private int parent_approval;
    private int res_parent_approval;
    private int guard_sign_off;

    // Many-to-One relationship with Student entity
    @ManyToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;

    // Getter and Setter methods for 'reason'
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    // Getter and Setter methods for 'parent_approval'
    public int getParent_approval() {
        return parent_approval;
    }

    public void setParent_approval(int parent_approval) {
        this.parent_approval = parent_approval;
    }

    // Getter and Setter methods for 'res_parent_approval'
    public int getRes_parent_approval() {
        return res_parent_approval;
    }

    public void setRes_parent_approval(int res_parent_approval) {
        this.res_parent_approval = res_parent_approval;
    }

    // Getter and Setter methods for 'guard_sign_off'
    public int getGuard_sign_off() {
        return guard_sign_off;
    }

    public void setGuard_sign_off(int guard_sign_off) {
        this.guard_sign_off = guard_sign_off;
    }
}
