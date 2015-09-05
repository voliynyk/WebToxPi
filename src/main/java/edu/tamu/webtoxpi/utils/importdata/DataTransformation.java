package edu.tamu.webtoxpi.utils.importdata;

import java.util.List;

public class DataTransformation
{
	private FileData _fileData = null;

	public DataTransformation(FileData fileData)
	{
		this._fileData = fileData;
	}

	public boolean Transform()
	{
		boolean bResult = false;
		try
		{
/*			HibernateUtil.beginTransaction();
			if (_fileData != null)
			{
				List<Substance> chemicalList = _fileData.getChemicals();
				for (int chemCount = 0; chemCount < chemicalList.size(); chemCount++)
				{
					Substance substance = chemicalList.get(chemCount);

					Sources currentSource = DAOManager.getInstance().getSourceDAO().findExistOrCreateNewSource(substance.getSource_name_sid());
					Casregistrynumbers currentCASRN = DAOManager.getInstance().getCasregistrynumberDAO().findExistOrCreateNewCASRN(substance.getCasrn());
					Chemicals currentChemical = DAOManager.getInstance().getChemicalDAO().findExistOrCreateNewChemical(substance.getName());

					Orders currentOrder = DAOManager.getInstance().getOrderDAO().findExistOrCreateNewOrder(Auth.getCurrentUser(), _fileData.getFileName(), _fileData.getOriginalFileName(), currentSource, currentCASRN, currentChemical);

					for (int sliceCount = 0; sliceCount < substance.getSlices().size(); sliceCount++)
					{
						Slice slice = substance.getSlices().get(sliceCount);

						Weights currentWeight = DAOManager.getInstance().getWeightDAO().findExistOrCreateNewWeight(slice.getWeight());
						Groups currentGroup = DAOManager.getInstance().getGroupDAO().findExistOrCreateNewGroup(slice.getName(), currentWeight, slice.getColor());

						for (Component component : slice.getComponents())
						{
							Types currentType = DAOManager.getInstance().getTypeDAO().findExistOrCreateNewType(component.getType(), currentGroup);
							Componentsources currentComponentSource = DAOManager.getInstance().getComponentsourceDAO().findExistOrCreateNewComponentSources(component.getSource());
							Components currentComponent = DAOManager.getInstance().getComponentDAO().findExistOrCreateNewComponent(component.getName(), currentType, currentComponentSource);
							Results currentResult = DAOManager.getInstance().getResultDAO().findExistOrCreateNewResult(currentOrder, currentComponent, substance.getComponents().get(component.getName()));
						}
					}
				}
				HibernateUtil.commitTransaction();
				bResult = true;
			}*/
		}
		catch (Exception ex)
		{
/*			HibernateUtil.rollbackTransaction();
			System.out.println(ex.getMessage());
			bResult = false;*/
		}

		return bResult;
	}

}
