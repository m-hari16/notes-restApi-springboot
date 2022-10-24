package com.notesapp.notesservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="notes")
@Data
public class NotesModel extends BaseDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String titleNotes;

    @Column(name = "body", nullable = false)
    private String bodyNotes;
}
