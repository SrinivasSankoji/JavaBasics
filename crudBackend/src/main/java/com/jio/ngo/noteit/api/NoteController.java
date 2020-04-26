package com.jio.ngo.noteit.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.noteit.Mapper;
import com.jio.ngo.noteit.api.viewmodel.NoteViewModel;
import com.jio.ngo.noteit.db.NoteRepository;
import com.jio.ngo.noteit.db.NotebookRepository;
import com.jio.ngo.noteit.model.Note;
import com.jio.ngo.noteit.model.Notebook;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController 
{
    private NoteRepository noteRepository;
    private NotebookRepository notebookRepository;
    private Mapper mapper;

    public NoteController(NoteRepository noteRepository, NotebookRepository notebookRepository, Mapper mapper) {
        this.noteRepository = noteRepository;
        this.notebookRepository = notebookRepository;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<NoteViewModel> all() 
	{
		List<Note> notes = this.noteRepository.findAll();
		return notes.stream().map(note -> this.mapper.convertToNoteViewModel(note)).collect(Collectors.toList());

	}

    @GetMapping("/byId/{id}")
    public NoteViewModel byId(@PathVariable String id)
	{
		Note note = this.noteRepository.findById(UUID.fromString(id)).orElse(null);
		if (note == null) {
			throw new EntityNotFoundException();
		}
		NoteViewModel noteViewModel = this.mapper.convertToNoteViewModel(note);
		return noteViewModel;
	}

    @GetMapping("/byNotebook/{notebookId}")
    public List<NoteViewModel> byNotebook(@PathVariable String notebookId) 
	{
		List<Note> notes = new ArrayList<>();
		Optional<Notebook> notebook = this.notebookRepository.findById(UUID.fromString(notebookId));
		if (notebook.isPresent()) {
			notes = this.noteRepository.findAllByNotebook(notebook.get());
		}
		return notes.stream().map(note -> this.mapper.convertToNoteViewModel(note)).collect(Collectors.toList());
	}

    @PostMapping
    public Note save(@RequestBody NoteViewModel noteCreateViewModel, BindingResult bindingResult) 
	{
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Note noteEntity = this.mapper.convertToNoteEntity(noteCreateViewModel);
		this.noteRepository.save(noteEntity);
		return noteEntity;
	}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) 
	{
		this.noteRepository.deleteById(UUID.fromString(id));
	}
}
