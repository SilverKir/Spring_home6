package com.example.sem6home.controller;

import com.example.sem6home.model.Note;
import com.example.sem6home.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.status(HttpStatus.FOUND).body(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        if (noteService.getNoteById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(noteService.getNoteById(id).get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.addNote(note));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return ResponseEntity.status(HttpStatus.OK).body(noteService.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
