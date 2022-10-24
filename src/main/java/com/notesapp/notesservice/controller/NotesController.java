package com.notesapp.notesservice.controller;

import com.notesapp.notesservice.form.NotesForm;
import com.notesapp.notesservice.model.NotesModel;
import com.notesapp.notesservice.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NotesController {
    private final NotesService noteService;

    @Autowired
    public NotesController(NotesService noteService){

        this.noteService = noteService;
    }

    @PostMapping
    public NotesModel create(@RequestBody NotesForm notes){

        return noteService.create(notes);
    }

    @GetMapping
    public List<NotesModel> getAll(){
        return noteService.getAll();
    }

    @GetMapping(value = "{id}")
    public NotesModel getById(@PathVariable Long id){
        return noteService.findById(id);
    }

    @PutMapping(value = "{id}")
    public NotesModel updateById(@RequestBody NotesForm notes, @PathVariable Long id){
        return noteService.updateById(notes, id);
    }

    @DeleteMapping(value = "{id}")
    public  NotesModel deleteById(@PathVariable Long id){
        return  noteService.deleteById(id);
    }


}
