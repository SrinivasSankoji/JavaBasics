package com.jio.ngo.rc.noteit.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "NOTE")
public class Note
{
    @Id
    @GeneratedValue
    @Column(name = "note_Id")
    private UUID noteId;
    
    @Column(name = "\"title\"")
    private String title;
    
    @Column(name = "\"text\"")
    private String text;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notebook_Id", referencedColumnName = "notebook_Id")
    private Notebook notebook;

    @Column(name = "LASTMODIFIEDON")
    private Date lastModifiedOn;

    protected Note() {
        this.noteId = UUID.randomUUID();
        this.lastModifiedOn = new Date();
    }

    public Note(String title, String text, Notebook notebook) {
        this();
        this.title = title;
        this.text = text;
        this.notebook = notebook;
    }

    public Note(String id, String title, String text, Notebook notebook) {
        this(title, text, notebook);
        if (id != null) {
            this.noteId = UUID.fromString(id);
        }
    }

    public UUID getNoteId() {
		return noteId;
	}

	public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Notebook getNotebook() {
        return notebook;
    }

    public String getNotebookId() {
        return this.notebook.getNotebookId().toString();
    }

    public Date getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(Date lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }
}
