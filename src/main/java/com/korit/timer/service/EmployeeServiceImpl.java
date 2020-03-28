package com.korit.timer.service;

import com.korit.timer.api.responses.message.MsgSource;
import com.korit.timer.model.Employee;
import com.korit.timer.repository.EmployeeRepository;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends AbstractCommonService implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(MsgSource msgSource, EmployeeRepository employeeRepository) {
        super(msgSource);
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return null;
    }
}
