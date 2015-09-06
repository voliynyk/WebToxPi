package edu.tamu.webtoxpi.service.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import edu.tamu.webtoxpi.dao.entity.Project;
import edu.tamu.webtoxpi.service.ProjectService;

@Component
public class ProjectFormValidator implements Validator
{
	@Autowired
	ProjectService projectService;

	@Override
	public boolean supports(Class<?> clazz)
	{
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors)
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "code", "NotEmpty.projectForm.code");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.projectForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "access", "NotEmpty.projectForm.access");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projecttype", "NotEmpty.projectForm.projecttype");
	}

}
