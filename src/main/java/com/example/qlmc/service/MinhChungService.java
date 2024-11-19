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
    public int totalMinhChungOfTieuChi(int idTieuChi) {
        return minhChungRepository.totalMinhChungOfTieuChi(idTieuChi);
    }
    public MinhChung findByIdTieuChuanIdTieuChi(int idTieuChuan, int idTieuChi) {
        return minhChungRepository.findMinhChungByIdTieuChuanIdTieuChi(idTieuChuan, idTieuChi);
    }
    public void UpdateNewMaDungChung(int idMc, int maDungChung){
        minhChungRepository.updateNewMaDungChung(idMc, maDungChung);
    }

    public MinhChung findById(int id) {
        return minhChungRepository.findById(id).orElse(null);
    }

    public List<MinhChung> getAllMinhChung() {
        return minhChungRepository.findAll();
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

    public List<MinhChung> findByMaDungChung(int idMc) {
        return minhChungRepository.findMinhChungDungChung(idMc);
    }
    public MinhChung findByParentChildMaMcInTieuChuan(String parentMaMc, String childMaMc, int idTieuChuan){
        return minhChungRepository.findMinhChungByParentChildMaMcInTieuChuan(parentMaMc, childMaMc, idTieuChuan);
    }
    public void SwapData(int idMc1, int idMc2){
        minhChungRepository.createTempTable(idMc1);
        minhChungRepository.updateFirstRecord(idMc1, idMc2);
        minhChungRepository.updateSecondRecord(idMc2);
        minhChungRepository.dropTempTable();
    }
}