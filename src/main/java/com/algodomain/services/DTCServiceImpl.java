package com.algodomain.services;

import com.algodomain.models.DTC;
import com.algodomain.repos.DTCRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DTCServiceImpl implements DTCService{
    @Autowired
    DTCRepo dtcRepo;

    @Override
    public DTC addDTC(DTC dtc) {
        DTC dtc1 = null;
        try{
            dtc1 = dtcRepo.save(dtc);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dtc1;
    }

    @Override
    public DTC getDTC(int id) {
        DTC dtc1 = null;
        try{
            dtc1 = dtcRepo.findById(id).get();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dtc1;
    }

    @Override
    public DTC updateDTC(DTC dtc) {
        DTC dtc1 = null;
        try{

            DTC oldDtc = dtcRepo.findById(dtc.getDTCID()).get();
            oldDtc.setDiscount(dtc.getDiscount());
            oldDtc.setGST(dtc.getGST());
            oldDtc.setDeliveryCharges(dtc.getDeliveryCharges());
            oldDtc.setProductCategory(dtc.getProductCategory());
            dtc1 = dtcRepo.save(oldDtc);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dtc1;
    }

    @Override
    public List<DTC> getAllDTC() {
        List<DTC> dtcList = null;
        try{
            dtcList = dtcRepo.findAll();

        }
        catch (Exception e){
            e.printStackTrace();
        }



        return dtcList;
    }

    @Override
    public String deleteDTC(int id) {
        String msg = "There is some server Error!";
        try{

            dtcRepo.deleteById(id);
            msg = "Item deleted successfully!";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return msg;
    }

    @Override
    public DTC getDTCByCategory(String category) {
        DTC dtc1 = null;
        try{
            dtc1 = dtcRepo.getDTCByCategory(category);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return dtc1;
    }
}
