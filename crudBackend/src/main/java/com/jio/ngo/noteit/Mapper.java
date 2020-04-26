package com.jio.ngo.noteit;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.jio.ngo.noteit.api.viewmodel.NoteViewModel;
import com.jio.ngo.noteit.api.viewmodel.NotebookViewModel;
import com.jio.ngo.noteit.db.NotebookRepository;
import com.jio.ngo.noteit.model.Note;
import com.jio.ngo.noteit.model.Notebook;

@Component
public class Mapper {
	private NotebookRepository notebookRepository;

	public Mapper(NotebookRepository notebookRepository) {
		this.notebookRepository = notebookRepository;
	}

	public NoteViewModel convertToNoteViewModel(Note entity) {
		NoteViewModel viewModel = new NoteViewModel();
		viewModel.setTitle(entity.getTitle());
		viewModel.setId(entity.getId().toString());
		viewModel.setLastModifiedOn(entity.getLastModifiedOn());
		viewModel.setText(entity.getText());
		viewModel.setNotebookId(entity.getNotebook().getId().toString());
		return viewModel;
	}

	public Note convertToNoteEntity(NoteViewModel viewModel) {
		Notebook notebook = this.notebookRepository.findById(UUID.fromString(viewModel.getNotebookId())).get();
		Note entity = new Note(viewModel.getId(), viewModel.getTitle(), viewModel.getText(), notebook);
		return entity;
	}

	public NotebookViewModel convertToNotebookViewModel(Notebook entity) {
		NotebookViewModel viewModel = new NotebookViewModel();
		viewModel.setId(entity.getId().toString());
		viewModel.setName(entity.getName());
		viewModel.setNbNotes(entity.getNotes().size());
		return viewModel;
	}

	public Notebook convertToNotebookEntity(NotebookViewModel viewModel) {
		Notebook entity = new Notebook(viewModel.getId(), viewModel.getName());
		return entity;
	}
}
