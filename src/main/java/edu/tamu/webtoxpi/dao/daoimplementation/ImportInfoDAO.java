package edu.tamu.webtoxpi.dao.daoimplementation;

import org.springframework.stereotype.Repository;

import edu.tamu.webtoxpi.dao.daointeface.IImportInfoDAO;
import edu.tamu.webtoxpi.dao.model.Importinfo;
import edu.tamu.webtoxpi.dao.util.GenericDAOImpl;

@Repository
public class ImportInfoDAO extends GenericDAOImpl<Importinfo, Integer> implements IImportInfoDAO
{
}
