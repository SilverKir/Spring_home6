package com.example.sem6home.service;

import com.example.sem6home.aspects.TrackUserAction;
import com.example.sem6home.model.Note;
import com.example.sem6home.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    @TrackUserAction
    public Note addNote(Note note){
        return repository.save(note);
    }

    @TrackUserAction
    public List<Note> getAllNotes(){
        return repository.findAll();

    }
    @TrackUserAction
    public Optional<Note> getNoteById(Long id){
        return repository.findById(id);
    }
    @TrackUserAction
    public Note updateNote(Long id, Note note){
        note.setId(id);
        return repository.save(note);
    }
    @TrackUserAction
    public void deleteNote(Long id){
        repository.deleteById(id);
    }
}
