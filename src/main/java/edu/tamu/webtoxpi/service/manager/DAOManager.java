package edu.tamu.webtoxpi.service.manager;

import edu.tamu.webtoxpi.dao.daoimplementation.*;

public class DAOManager
{
	private static DAOManager instance = null;

	protected ComponentDAO componentDAO = null;
	protected NoteDAO noteDAO = null;
	protected OrderDAO orderDAO = null;
	protected ResultDAO resultDAO = null;
	protected UserDAO userDao = null;
	protected ViewTemplateDAO viewtemplateDAO = null;
	protected ImportInfoDAO importinfoDAO = null;
	protected UnitDAO unitDAO = null;
	protected ProjectDAO projectDAO = null;
	protected ProjectTypeDAO projectTypeDAO = null;
	protected RowTypeDAO rowTypeDAO = null;
	protected RowHeaderDAO rowHeaderDAO = null;
	
	
	private DAOManager()
	{
	}

	public static DAOManager getInstance()
	{
		if (instance == null)
		{
			synchronized (DAOManager.class)
			{
				if (instance == null)
				{
					instance = new DAOManager();
				}
			}
		}
		return instance;
	}

	public ProjectDAO getProjectDAO()
	{
		if (this.projectDAO == null)
		{
			this.projectDAO = new ProjectDAO();
		}
		return this.projectDAO;
	}
	
	public ProjectTypeDAO getProjectTypeDAO()
	{
		if (this.projectTypeDAO == null)
		{
			this.projectTypeDAO = new ProjectTypeDAO();
		}
		return this.projectTypeDAO;
	}
	
	public ComponentDAO getComponentDAO()
	{
		if (this.componentDAO == null)
		{
			this.componentDAO = new ComponentDAO();
		}
		return this.componentDAO;
	}

	public NoteDAO getNoteDAO()
	{
		if (this.noteDAO == null)
		{
			this.noteDAO = new NoteDAO();
		}
		return this.noteDAO;
	}

	public OrderDAO getOrderDAO()
	{
		if (this.orderDAO == null)
		{
			this.orderDAO = new OrderDAO();
		}
		return this.orderDAO;
	}

	public ResultDAO getResultDAO()
	{
		if (this.resultDAO == null)
		{
			this.resultDAO = new ResultDAO();
		}
		return this.resultDAO;
	}

	public UserDAO getUserDao()
	{
		if (this.userDao == null)
		{
			this.userDao = new UserDAO();
		}
		return this.userDao;
	}

	public ViewTemplateDAO getViewtemplateDAO()
	{
		if (this.viewtemplateDAO == null)
		{
			this.viewtemplateDAO = new ViewTemplateDAO();
		}
		return this.viewtemplateDAO;
	}

	public ImportInfoDAO getImportinfoDAO()
	{
		if (this.importinfoDAO == null)
		{
			this.importinfoDAO = new ImportInfoDAO();
		}
		return this.importinfoDAO;
	}

	public UnitDAO getUnitDAO()
	{
		if (this.unitDAO == null)
		{
			this.unitDAO = new UnitDAO();
		}
		return this.unitDAO;
	}
	
	public RowTypeDAO getRowTypeDAO()
	{
		if (this.rowTypeDAO == null)
		{
			this.rowTypeDAO = new RowTypeDAO();
		}
		return this.rowTypeDAO;
	}
	
	public RowHeaderDAO getRowHeaderDAO()
	{
		if (this.rowHeaderDAO == null)
		{
			this.rowHeaderDAO = new RowHeaderDAO();
		}
		return this.rowHeaderDAO;
	}
	
}
