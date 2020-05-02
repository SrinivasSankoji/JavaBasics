package com.jio.ngo.rc.noteit.db;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jio.ngo.rc.noteit.model.Note;
import com.jio.ngo.rc.noteit.model.Notebook;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> 
{
    List<Note> findAllByNotebook(Notebook notebook);
}
