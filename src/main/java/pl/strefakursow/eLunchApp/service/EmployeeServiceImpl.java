package pl.strefakursow.eLunchApp.service;

import pl.strefakursow.eLunchApp.DTO.EmployeeDTO;
import pl.strefakursow.eLunchApp.repo.EmployeeRepo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<EmployeeDTO> getAll() {
        return null;
    }

    @Override
    public void put(UUID uuid, EmployeeDTO employeeDTO) {

    }

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public Optional<EmployeeDTO> getByUuid(UUID uuid) {
        return Optional.empty();
    }
}