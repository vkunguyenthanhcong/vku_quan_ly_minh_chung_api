package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.qlmc.entity.MinhChung;
import com.example.qlmc.repository.MinhChungRepository;

import jakarta.transaction.Transactional;

@Service
public class MinhChungService {

    @Autowired
    private MinhChungRepository minhChungRepository;

    public void addMinhChungDungChung(int idKmc, int idTieuChuan, int idGoiY, int maDungChung) {
        minhChungRepository.insertMinhChung(idKmc, idTieuChuan, idGoiY, maDungChung);
    }

    public List<MinhChung> getAllMinhChung() {
        return minhChungRepository.findAll();
    }
    public List<Object[]> findByMaCtdt(String maCtdt) {
        return minhChungRepository.findByMaCtdt(maCtdt);
    }
    public List<Object[]> getAllMinhChungAndidTieuChi() {
        return minhChungRepository.getAllMinhChungAndidTieuChi();
    }

    public List<Object[]> getAllWithIdTieuChi(int idTieuChi) {
        return minhChungRepository.findAllByIdTieuChi(idTieuChi);
    }
    public int countMinhChungWithTieuChi(int idTieuChi){
        return minhChungRepository.findAllByIdTieuChi(idTieuChi).size();
    }
    public List<Object[]> getAllMinhChungKhongDungChung(){
        return minhChungRepository.getAllMinhChung();
    }
    public int countMinhChungByTieuChuan(int idTieuChuan){
        return minhChungRepository.countMinhChungByTieuChuan(idTieuChuan);
    }
    @Transactional
    public void processMinhChung(int idMc, String parentMaMc) {
        minhChungRepository.deleteByIdMc(idMc);
        minhChungRepository.createTempTable(parentMaMc);
        minhChungRepository.updateWithTempTable(parentMaMc);
        minhChungRepository.dropTempTable();
    }
    @Modifying
    public void saveData(MinhChung data){
        minhChungRepository.save(data);
    }
}