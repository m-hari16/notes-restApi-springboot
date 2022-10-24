package com.notesapp.notesservice.service;

import com.notesapp.notesservice.form.NotesForm;
import com.notesapp.notesservice.model.NotesModel;

import java.util.List;

public interface NotesService {
    NotesModel create(NotesForm form);

    List<NotesModel> getAll();

    NotesModel findById(Long id);

    NotesModel updateById(NotesForm form, Long id);

    NotesModel deleteById(Long id);
}
