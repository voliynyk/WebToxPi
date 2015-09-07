package edu.tamu.webtoxpi.utils.importdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.tamu.webtoxpi.utils.importdata.toxpi.DataTransformation;

public class ImportManager implements Runnable
{
	private final Logger logger = LoggerFactory.getLogger(ImportManager.class);
	
	private String fileLocation = "";
	
	public ImportManager()
	{}
	
	public ImportManager(String fileLocation)
	{
		this.fileLocation = fileLocation;
	}
	
	public UniversalDataImport parseToxPiFormat()
	{
		UniversalDataImport result = new UniversalDataImport();
		try
		{
			DataTransformation dt = new DataTransformation(fileLocation, fileLocation);
			result = dt.Transform();
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		
		return result;
	}
	
	private void storeDataToDataBase(UniversalDataImport data)
	{
		if (data != null)
		{
			for (Results result : data.getResults())
			{
				Components component = result.getComponent();
				Levels level = component.getLevel();
				while (level != null)
				{
					level = level.getChildLevel();
				}
				
			}
		}
	}

	@Override
	public void run()
	{
		storeDataToDataBase(parseToxPiFormat());
	}
}
