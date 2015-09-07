package edu.tamu.webtoxpi.utils.importdata.toxpi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.tamu.webtoxpi.utils.importdata.*;

public class DataTransformation
{
	private final Logger logger = LoggerFactory.getLogger(DataTransformation.class);
	private FileData _fileData = null;

	public DataTransformation(String uploadedFileLocation, String originalFileName)
	{
		Map<String, FileData> fileDataList = new HashMap<String, FileData>();
		FileProcessor fp = new FileProcessor();
		try
		{
			fp.readFile(uploadedFileLocation, fileDataList, originalFileName);
			_fileData = fp.getFileData();
		}
		catch (Exception ex)
		{
		}
	}
	
	public DataTransformation(FileData fileData)
	{
		this._fileData = fileData;
	}
	
	public UniversalDataImport Transform()
	{
		UniversalDataImport resultData = new UniversalDataImport();
		try
		{
			if (_fileData != null)
			{
				List<Substance> chemicalList = _fileData.getChemicals();
				for (int chemCount = 0; chemCount < chemicalList.size(); chemCount++)
				{
					Substance substance = chemicalList.get(chemCount);
					String source = substance.getSource_name_sid();
					String casrn = substance.getCasrn();
					String chemical = substance.getName();
					
					for (int sliceCount = 0; sliceCount < substance.getSlices().size(); sliceCount++)
					{
						Slice slice = substance.getSlices().get(sliceCount);
						String weight = String.valueOf(slice.getWeight());
						String group = slice.getName();
						for (Component comp : slice.getComponents())
						{
							String type = comp.getType();
							String componentSource = comp.getSource();
							String componentName = comp.getName();
							String resultValue = String.valueOf(substance.getComponents().get(comp.getName()));
							
							Levels level1 = new Levels(null, componentSource);
							Levels level2 = new Levels(level1, type);
							Levels level3 = new Levels(level2, group);
							Levels level4 = new Levels(level3, weight);
							Components component = new Components(componentName, level4);
							
							Results result = new Results();
							result.getRows().add(source);
							result.getRows().add(casrn);
							result.getRows().add(chemical);
							result.setComponent(component);
							result.setValue(resultValue);
							
							resultData.getResults().add(result);
						}
						
					}
				}
			}
		}
		catch (Exception e)
		{
			logger.error(e.getMessage(), e);
		}
		
		return resultData;
	}

}
