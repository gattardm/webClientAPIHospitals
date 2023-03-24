package org.medhead.emergencysystem.webclienthospitals.model;

import lombok.Data;

@Data
public class Hospital {
    private Integer id;

    private String name;

    private String longitude;

    private String latitude;

    private String bedsQuantity;

    private String bedsAvailable;

    private String speciality;

    private String incidentId;

    private String attributedBy;

}
