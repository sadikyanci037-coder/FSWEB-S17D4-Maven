package com.workintech.sqlintro.repository;

import com.workintech.sqlintro.entity.Ogrenci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OgrenciRepository extends JpaRepository<Ogrenci, Long> {

    String QUESTION_1 = "SELECT * FROM ogrenci";

    @Query(value = QUESTION_1, nativeQuery = true)
    List<Ogrenci> findAll();


    String QUESTION_2 = "SELECT * FROM ogrenci WHERE cinsiyet = 'K'";

    @Query(value = QUESTION_2, nativeQuery = true)
    List<Ogrenci> findGirls();


    String QUESTION_3 = "SELECT DISTINCT sinif FROM ogrenci";

    @Query(value = QUESTION_3, nativeQuery = true)
    List<String> findAllClasses();


    String QUESTION_4 = "SELECT * FROM ogrenci WHERE sinif = '10A' AND cinsiyet = 'K'";

    @Query(value = QUESTION_4, nativeQuery = true)
    List<Ogrenci> find10AGirls();


    String QUESTION_5 =
            "SELECT * FROM ogrenci WHERE ogrno > 5 AND ogrno < 10 AND cinsiyet = 'K'";

    @Query(value = QUESTION_5, nativeQuery = true)
    List<Ogrenci> findGirlsWithOgrno();


    String QUESTION_6 =
            "SELECT * FROM ogrenci " +
                    "ORDER BY LOWER(TRANSLATE(ad, " +
                    "'ÇĞİIÖŞÜçğıiöşü', " +
                    "'CGIIOSUcgiiosu')) ASC";

    @Query(value = QUESTION_6, nativeQuery = true)
    List<Ogrenci> findStudentsAlphabetically();


    String QUESTION_7 =
            "SELECT * FROM ogrenci WHERE sinif = '10A' ORDER BY ogrno DESC";

    @Query(value = QUESTION_7, nativeQuery = true)
    List<Ogrenci> find10AStudentsByOgrNo();


    String QUESTION_8 =
            "SELECT * FROM ogrenci ORDER BY dtarih DESC LIMIT 1";

    @Query(value = QUESTION_8, nativeQuery = true)
    Ogrenci findYoungestStudent();


    String QUESTION_9 =
            "SELECT * FROM ogrenci ORDER BY dtarih ASC LIMIT 1";

    @Query(value = QUESTION_9, nativeQuery = true)
    Ogrenci findElderStudent();


    String QUESTION_10 =
            "SELECT * FROM ogrenci WHERE ad ILIKE '_E%'";

    @Query(value = QUESTION_10, nativeQuery = true)
    List<Ogrenci> findStudentsSecondLetterOfN();
}