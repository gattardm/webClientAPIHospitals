package org.medhead.emergencysystem.webclienthospitals.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.medhead.emergencysystem.webclienthospitals.repository.HospitalProxy;
import org.medhead.emergencysystem.webclienthospitals.model.Hospital;

import lombok.Data;

@Data
@Service
public class HospitalService {

    @Autowired
    private HospitalProxy hospitalProxy;

    public Hospital getHospital(final int id) { return  hospitalProxy.getHospital(id); }

    public Iterable<Hospital> getHospitals() { return hospitalProxy.getHospitals(); }

    public void deleteHospital(final int id) { hospitalProxy.deleteHospital(id); }

    public Hospital saveHospital(Hospital hospital) {
        Hospital savedHospital;

        // Functional rule : name must be capitalized.
        hospital.setName(hospital.getName().toUpperCase());

        if(hospital.getId() == null) {
            //if id is null then it's a new hospital
            savedHospital = hospitalProxy.createHospital(hospital);
        } else {
            savedHospital = hospitalProxy.updateHospital(hospital);
        }

        return savedHospital;
    }
}
