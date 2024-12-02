package com.example.qlmc.repository;
import java.util.List;

import com.example.qlmc.entity.PhanCongDanhGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.MinhChung;

import jakarta.transaction.Transactional;

public interface MinhChungRepository extends JpaRepository<MinhChung, Integer> {

    @Query("SELECT mc FROM MinhChung mc WHERE mc.maDungChung = :idMc")
    List<MinhChung> findMinhChungDungChung(@Param("idMc") int idMc);

    @Query("SELECT mc FROM MinhChung mc WHERE mc.goiY.idGoiY = :idGoiY")
    List<MinhChung> findByIdGoiY(@Param("idGoiY") int idGoiY);

    @Query("SELECT COUNT(mc) FROM MinhChung mc WHERE mc.goiY.mocChuan.tieuChi.idTieuChi = :idTieuChi AND mc.maDungChung = 0")
    int totalMinhChungOfTieuChi(@Param("idTieuChi") int idTieuChi);

    @Query("SELECT mc FROM MinhChung mc WHERE mc.idTieuChuan = :idTieuChuan AND mc.goiY.mocChuan.tieuChi.idTieuChi = :idTieuChi")
    MinhChung findMinhChungByIdTieuChuanIdTieuChi(@Param("idTieuChuan") int idTieuChuan, @Param("idTieuChi") int idTieuChi);


    @Modifying
    @Transactional
    @Query("UPDATE MinhChung mc SET mc.maDungChung = :idMc WHERE mc.maDungChung = :maDungChung AND mc.maDungChung != 0")
    void updateNewMaDungChung(@Param("idMc") int idMc, @Param("maDungChung") int maDungChung);

    @Modifying
    @Transactional
    @Query(value = "CREATE TEMPORARY TABLE temp_table AS " +
            "SELECT parent_ma_mc, child_ma_mc " +
            "FROM minhchung WHERE id_mc = :idMc1", nativeQuery = true)
    void createTempTable(@Param("idMc1") int idMc1);

    @Modifying
    @Transactional
    @Query(value = "UPDATE minhchung t1 " +
            "JOIN minhchung t2 ON t1.id_mc = :idMc1 AND t2.id_mc = :idMc2 " +
            "SET t1.child_ma_mc = t2.child_ma_mc", nativeQuery = true)
    void updateFirstRecord(@Param("idMc1") int idMc1, @Param("idMc2") int idMc2);

    @Modifying
    @Transactional
    @Query(value = "UPDATE minhchung t2 " +
            "JOIN temp_table temp ON t2.id_mc = :idMc2 " +
            "SET t2.child_ma_mc = temp.child_ma_mc", nativeQuery = true)
    void updateSecondRecord(@Param("idMc2") int idMc2);



    @Query("SELECT mc FROM MinhChung mc WHERE mc.parentMaMc = :parentMaMc AND mc.childMaMc = :childMaMc AND mc.idTieuChuan = :idTieuChuan")
    MinhChung findMinhChungByParentChildMaMcInTieuChuan(@Param("parentMaMc") String parentMaMc, @Param("childMaMc") String childMaMc, @Param("idTieuChuan") int idTieuChuan);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO minhchung (id_kmc, id_tieuchuan, id_goiy, madungchung) VALUES (:idKmc, :idTieuChuan, :idGoiY, :maDungChung)", nativeQuery = true)
    void insertMinhChung(@Param("idKmc") int idKmc,
                         @Param("idTieuChuan") int idTieuChuan,
                         @Param("idGoiY") int idGoiY,
                         @Param("maDungChung") int maDungChung);
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM minhchung WHERE id_mc = :idMc", nativeQuery = true)
    void deleteByIdMc(@Param("idMc") int idMc);


    @Modifying
    @Transactional
    @Query(value = "CREATE TEMPORARY TABLE temp_table AS " +
                   "SELECT child_ma_mc, LPAD(@row_num := @row_num + 1, 2, '0') AS new_stt " +
                   "FROM minhchung, (SELECT @row_num := 0) AS r " +     
                   "WHERE parent_ma_mc = :parentMaMc " +
                   "ORDER BY CAST(child_ma_mc AS UNSIGNED);", 
           nativeQuery = true)
    void createTempTable(@Param("parentMaMc") String parentMaMc);

    @Modifying
    @Transactional
    @Query(value = "UPDATE minhchung JOIN temp_table " +
                   "ON minhchung.child_ma_mc = temp_table.child_ma_mc " +
                   "SET minhchung.child_ma_mc = temp_table.new_stt " +
                   "WHERE minhchung.parent_ma_mc = :parentMaMc;", 
           nativeQuery = true)
    void updateWithTempTable(@Param("parentMaMc") String parentMaMc);

    @Modifying
    @Transactional
    @Query(value = "DROP TEMPORARY TABLE temp_table;", nativeQuery = true)
    void dropTempTable();

    
}