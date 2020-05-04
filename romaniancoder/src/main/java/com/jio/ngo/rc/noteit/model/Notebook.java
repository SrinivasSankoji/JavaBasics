package com.jio.ngo.rc.noteit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
//@Table(name = "NOTEBOOK")
public class Notebook 
{
    @Id
    @GeneratedValue
    @Column(name = "notebook_Id")
    private UUID notebookId;
    
    @Column(name = "\"name\"")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "notebook_Id", referencedColumnName = "notebook_Id")
    private List<Note> notes;

    protected Notebook() {
        this.notebookId = UUID.randomUUID();
        this.notes = new ArrayList<>();
    }

    public Notebook(String name) {
        this();
        this.name = name;
    }

    public Notebook(String id, String name) {
        this();
        if (id != null) {
            this.notebookId = UUID.fromString(id);
        }
        this.name = name;
    }


    public UUID getNotebookId() {
        return notebookId;
    }

    public String getName() {
        return name;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public int getNbOfNotes() {
        return this.notes.size();
    }

}
