package com.notesapp.notesservice.repository;

import com.notesapp.notesservice.model.NotesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NotesModel, Long> {
}
