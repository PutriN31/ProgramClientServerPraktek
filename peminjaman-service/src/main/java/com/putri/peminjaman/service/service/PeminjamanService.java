/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.putri.peminjaman.service.service;

import com.putri.peminjaman.service.entity.Peminjaman;
import com.putri.peminjaman.service.repository.PeminjamanRepository;
import com.putri.peminjaman.service.vo.Anggota;
import com.putri.peminjaman.service.vo.Buku;
import com.putri.peminjaman.service.vo.ResponseTemplate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Administrator
 */
@Service
public class PeminjamanService {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
    
    public ResponseTemplate getPeminjamanById(Long id){
        ResponseTemplate vo = new ResponseTemplate();
        Peminjaman peminjaman = peminjamanRepository
                .findPeminjamanById(id);
        Anggota anggota = restTemplate
                .getForObject("http://localhost:8080/anggota/"+peminjaman
                        .getIdAnggota(), Anggota.class);
        Buku buku = restTemplate
                .getForObject("http://localhost:8090/buku/"+peminjaman
                        .getIdBuku(), Buku.class);
        vo.setPeminjaman(peminjaman);
        vo.setAnggota(anggota);
        vo.setBuku(buku);
        return vo;
    }
    
    public List<Peminjaman> getAllPeminjaman(){
        return peminjamanRepository.findAll();
    }
    
    public Peminjaman updatePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
    
    public void deletePeminjamanById(Long id){
        peminjamanRepository.deleteById(id);
    }
}
