package com.example.qlmc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Object[]> findAllAndCtdt() {
        return minhChungRepository.findAllAndCtdt();
    }
    public List<Object[]> getAllWithIdGoiY(int idGoiY) {
        return minhChungRepository.findAllByIdGoiY(idGoiY);
    }

    public List<Object[]> getAllWithIdTieuChi(int idTieuChi) {
        return minhChungRepository.findAllByIdTieuChi(idTieuChi);
    }
    public List<Object[]> countMinhChungWithTieuChi(int idTieuChi){
        return minhChungRepository.countMinhChungWithTieuChi(idTieuChi);
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