package com.example.qlmc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.qlmc.entity.MinhChung;

import jakarta.transaction.Transactional;

public interface MinhChungRepository extends JpaRepository<MinhChung, Integer> {
    @Query("SELECT m FROM MinhChung m WHERE m.idGoiY = :idGoiY")
    List<MinhChung> findByIdGoiY(int idGoiY);

    @Query(value = "SELECT mc.parent_ma_mc, mc.child_ma_mc, kmc.ten_mc, kmc.sohieu, kmc.thoigian, dvbh.ten_dvbh, kmc.linkluutru, mc.madungchung FROM minhchung mc, khominhchung kmc, donvibanhanh dvbh, goiynguonmc goiy, mocchuan WHERE mocchuan.id_tieuchi = :idTieuChi AND mocchuan.id_mocchuan = goiy.id_mocchuan AND mc.id_goiy = goiy.id_goiy AND mc.id_kmc = kmc.id_kmc AND kmc.id_dvbh = dvbh.id_dvbh", nativeQuery =  true)
    List<Object[]> findAllByIdTieuChi(@Param("idTieuChi") int idTieuChi);

    @Query(value = "SELECT minhchung.*, khominhchung.ten_mc FROM minhchung, tieuchuan, khominhchung WHERE tieuchuan.ma_ctdt = :maCtdt AND tieuchuan.id_tieuchuan = minhchung.id_tieuchuan AND khominhchung.id_kmc = minhchung.id_kmc;", nativeQuery = true)
    List<Object[]> findByMaCtdt(@Param("maCtdt") String maCtdt);

    @Query (value = "SELECT minhchung.id_mc, minhchung.parent_ma_mc, minhchung.child_ma_mc, khominhchung.ten_mc, khominhchung.linkluutru FROM minhchung, khominhchung WHERE minhchung.madungchung = 0 AND minhchung.id_kmc = khominhchung.id_kmc;", nativeQuery=true)
    List<Object[]> getAllMinhChung();

    @Query(value = "SELECT COUNT(*) FROM minhchung WHERE minhchung.id_tieuchuan = :idTieuChuan", nativeQuery=true)
    int countMinhChungByTieuChuan(@Param("idTieuChuan") int idTieuChuan);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO minhchung (id_kmc, id_tieuchuan, id_goiy, madungchung) VALUES (:idKmc, :idTieuChuan, :idGoiY, :maDungChung)", nativeQuery = true)
    void insertMinhChung(@Param("idKmc") int idKmc,
                         @Param("idTieuChuan") int idTieuChuan,
                         @Param("idGoiY") int idGoiY,
                         @Param("maDungChung") int maDungChung);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM minhchung WHERE id_mc = :idMc OR madungchung = :idMc", nativeQuery = true)
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