/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.putri.buku.service.service;

import com.putri.buku.service.entity.Buku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.putri.buku.service.repository.BukuRepository;
import java.util.List;

/**
 *
 * @author putri
 */
@Service
public class BukuService {

    @Autowired
    private BukuRepository bukuRepository;

    public Buku saveBuku(Buku buku) {
        return bukuRepository.save(buku);

    }

    public Buku findBukuById(Long bukuId) {
        return bukuRepository.findByBukuId(bukuId);
    }

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    public void deleteBukuById(Long bukuId) {
        bukuRepository.deleteById(bukuId);
    }

    public Buku updateBuku(Buku buku) {
        return bukuRepository.save(buku);
    }

}
