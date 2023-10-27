package com.fit.se.ontap2410.backend.services;

import com.fit.se.ontap2410.backend.enums.StaffStatus;
import com.fit.se.ontap2410.backend.models.Staff;
import com.fit.se.ontap2410.backend.repositories.StaffRepository;

import java.util.List;
import java.util.Optional;

public class StaffService {
    private final StaffRepository staffRepository = new StaffRepository();

    public void insertStaff(Staff staff){
        staffRepository.insert(staff);
    }
    public void deleteStaff(long id){
        Optional<Staff> optionalStaff = staffRepository.getById(id);
        if(optionalStaff.isPresent()){
            Staff staff = optionalStaff.get();
            staff.setStatus(StaffStatus.NOT_ACTIVE);
            staffRepository.update(staff);
        }
    }
    public void updateStaff(Staff staff){
        staffRepository.update(staff);
    }
    public List<Staff> getAll(){
        return staffRepository.getAll();
    }
    public Optional<Staff> getById(long id){
        return staffRepository.getById(id);
    }
}
