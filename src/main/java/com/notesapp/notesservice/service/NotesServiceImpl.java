package com.notesapp.notesservice.service;

import com.notesapp.notesservice.form.NotesForm;
import com.notesapp.notesservice.model.NotesModel;
import com.notesapp.notesservice.repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotesServiceImpl implements NotesService {
    @Autowired
    private NotesRepository notesRepo;

    private NotesModel notes(NotesForm form){
        NotesModel notes = new NotesModel();
        notes.setTitleNotes(form.getTitleNotes());
        notes.setBodyNotes(form.getBodyNotes());
        return notes;
    }

    @Override
    public NotesModel create(NotesForm form){
        return notesRepo.save(notes(form));
    }

    @Override
    public List<NotesModel> getAll(){
        return notesRepo.findAll();
    }

    @Override
    public NotesModel findById(Long id) {
        Optional<NotesModel> opt = notesRepo.findById(id);
        return opt.orElse(null);
    }

    @Override
    public NotesModel updateById(NotesForm form, Long id) {
        Optional<NotesModel> notesById = notesRepo.findById(id);
        NotesModel note = notesById.get();
        note.setTitleNotes(form.getTitleNotes());
        note.setBodyNotes(form.getBodyNotes());
        return notesRepo.save(note);
    }

    @Override
    public NotesModel deleteById(Long id) {
        Optional<NotesModel> notesById = notesRepo.findById(id);
        NotesModel note = notesById.get();
        notesRepo.delete(note);
        return notesById.orElse(null);
    }


}
