package com.algodomain.services;

import com.algodomain.models.DTC;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DTCService {
    public DTC addDTC(DTC dtc);
    public DTC getDTC(int id);
    public DTC updateDTC(DTC dtc);
    public List<DTC> getAllDTC();
    public String deleteDTC(int id);
    public DTC getDTCByCategory(String category);

}
