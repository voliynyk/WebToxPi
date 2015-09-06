package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.INoteDAO;
import edu.tamu.webtoxpi.dao.model.Notes;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class NoteDAO extends GenericDAOImpl<Notes, Integer> implements INoteDAO
{
}
