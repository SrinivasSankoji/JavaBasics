package com.jio.ngo.rc.noteit.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
import com.jio.ngo.rc.noteit.api.viewmodel.NotebookViewModel;
import com.jio.ngo.rc.noteit.db.NotebookRepository;
import com.jio.ngo.rc.noteit.model.Notebook;

@RestController
@RequestMapping("/api/notebook")
@CrossOrigin
public class NotebookController 
{
	@Autowired
    NotebookRepository notebookRepository;
	
	@Autowired
    Mapper mapper;

    public NotebookController(NotebookRepository notebookRepository, Mapper mapper) {
        this.notebookRepository = notebookRepository;
        this.mapper = mapper;
    }

    @GetMapping("/getAllNoteBooks")
	public List<NotebookViewModel> getAllNoteBooks() {
		List<Notebook> notebooks = notebookRepository.findAll();
		return notebooks.stream().map(notebook -> this.mapper.convertToNotebookViewModel(notebook))
				.collect(Collectors.toList());
	}

    @PostMapping("/saveNotebook")
    public Notebook save(@RequestBody NotebookViewModel notebookViewModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		Notebook notebookEntity = this.mapper.convertToNotebookEntity(notebookViewModel);
		this.notebookRepository.save(notebookEntity);
		return notebookEntity;
	}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.notebookRepository.deleteById(UUID.fromString(id));
    }
}
