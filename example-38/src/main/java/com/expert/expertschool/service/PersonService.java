package com.expert.expertschool.service;

import com.expert.expertschool.constants.ExpertSchoolConstants;
import com.expert.expertschool.model.Person;
import com.expert.expertschool.model.Roles;
import com.expert.expertschool.repository.PersonRepository;
import com.expert.expertschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(ExpertSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
