package com.jio.ngo.rc.noteit.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jio.ngo.rc.noteit.Mapper;
import com.jio.ngo.rc.noteit.api.viewmodel.NoteViewModel;
import com.jio.ngo.rc.noteit.db.NoteRepository;
import com.jio.ngo.rc.noteit.db.NotebookRepository;
import com.jio.ngo.rc.noteit.model.Note;
import com.jio.ngo.rc.noteit.model.Notebook;

/*
Requests can be tested using the built in HTTP Rest Client. Use the
examples found in 'noteit.http' file.
 */

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController 
{
	@Autowired
    NoteRepository noteRepository;
	
	@Autowired
    NotebookRepository notebookRepository;
	
	@Autowired
    Mapper mapper;

    

    @GetMapping("/getAllNotes")
    public List<NoteViewModel> getAllNotes() 
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
		return this.mapper.convertToNoteViewModel(note);
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

    @PostMapping("/saveNotes")
    public Note save(@RequestBody NoteViewModel noteCreateViewModel, BindingResult bindingResult)
	{
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Note noteEntity = mapper.convertToNoteEntity(noteCreateViewModel);
		Note result=noteRepository.save(noteEntity);
		return result;
	}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.noteRepository.deleteById(UUID.fromString(id));
    }
}
