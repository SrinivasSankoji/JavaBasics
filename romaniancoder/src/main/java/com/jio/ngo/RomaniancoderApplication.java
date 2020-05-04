package com.jio.ngo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jio.ngo.rc.noteit.db.NoteRepository;
import com.jio.ngo.rc.noteit.db.NotebookRepository;

@SpringBootApplication
public class RomaniancoderApplication implements CommandLineRunner
{
	@Autowired
    NotebookRepository notebookRepository;
	
	@Autowired
    NoteRepository noteRepository;

	public static void main(String[] args) {
		SpringApplication.run(RomaniancoderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception 
	{
		 /**this.notebookRepository.deleteAll();
        this.noteRepository.deleteAll();

        // Save a default notebook
        Notebook defaultNotebook = new Notebook("Default");
        this.notebookRepository.save(defaultNotebook);

        Notebook quotesNotebook = new Notebook("Quotes");
        this.notebookRepository.save(quotesNotebook);

        // Save the welcome note
        Note note = new Note("Hello", "Welcome to Note It", defaultNotebook);
        this.noteRepository.save(note);

        // Save a quote note
        Note quoteNote = new Note("Latin Quote", "Carpe Diem", quotesNotebook);
        this.noteRepository.save(quoteNote);**/
	}
}
