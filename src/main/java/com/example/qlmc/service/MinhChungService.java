package com.example.qlmc.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.KhoMinhChung;
import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.entity.TieuChuan;
import com.example.qlmc.repository.MinhChungRepository;
import com.example.qlmc.repository.TieuChuanRepository;

import jakarta.transaction.Transactional;

@Service
public class MinhChungService {

    @Autowired
    private MinhChungRepository minhChungRepository;


    public List<MinhChung> getAllMinhChung() {
        return minhChungRepository.findAll();
    }
    public List<MinhChung> findByMaCtdt(String maCtdt) {
        return minhChungRepository.findByMaCtdt(maCtdt);
    }

    public List<Object[]> getAllWithIdGoiY(int idGoiY) {
        return minhChungRepository.findAllByIdGoiY(idGoiY);
    }

    public List<Object[]> getAllWithIdTieuChi(int idTieuChi) {
        return minhChungRepository.findAllByIdTieuChi(idTieuChi);
    }

    @Transactional
    public void processMinhChung(int idMc, String parentMaMc) {
        minhChungRepository.deleteByIdMc(idMc);
        minhChungRepository.createTempTable(parentMaMc);
        minhChungRepository.updateWithTempTable(parentMaMc);
        minhChungRepository.dropTempTable();
    }
    public MinhChung saveData(MinhChung data){
        return minhChungRepository.save(data);
    }
}