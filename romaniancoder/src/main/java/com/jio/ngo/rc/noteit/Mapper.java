package com.jio.ngo.rc.noteit;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jio.ngo.rc.noteit.api.viewmodel.NoteViewModel;
import com.jio.ngo.rc.noteit.api.viewmodel.NotebookViewModel;
import com.jio.ngo.rc.noteit.db.NotebookRepository;
import com.jio.ngo.rc.noteit.model.Note;
import com.jio.ngo.rc.noteit.model.Notebook;

/**
 * Component that handles all mappings in this project
 * - entity to view model
 * - view model to entity
 * <p>
 * All mappings are handled here, but in production code this is not the
 * best approach. You can take a look at ModelMapper project or at least split mapping classes
 * across many files.
 */

@Component
public class Mapper 
{
	@Autowired
    NotebookRepository notebookRepository;


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
