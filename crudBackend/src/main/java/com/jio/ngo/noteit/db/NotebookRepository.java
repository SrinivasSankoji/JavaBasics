package com.jio.ngo.noteit.db;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jio.ngo.noteit.model.Notebook;

@Repository
public interface NotebookRepository extends JpaRepository<Notebook, UUID> 
{
}
