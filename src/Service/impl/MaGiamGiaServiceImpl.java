/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service.impl;

import Model.MaGiamGia;
import Repository.MaGiamGiaRepository;
import Repository.impl.MaGiamGiaRepositoryImpl;
import Service.MaGiamGiaService;
import java.util.List;

/**
 *
 * @author admin
 */
public class MaGiamGiaServiceImpl implements MaGiamGiaService{

    private MaGiamGiaRepository maRepo = new MaGiamGiaRepositoryImpl();
    @Override
    public List<MaGiamGia> getAll() {
        return maRepo.getAll();
    }

    @Override
    public String addMa(MaGiamGia ma) {
        boolean addMa = maRepo.addMa(ma);
        if(addMa){
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String updateMa(String id, MaGiamGia ma) {
        boolean updateMa = maRepo.updateMa(id, ma);
        if(updateMa){
            return "Sửa thành công";
        }
        return "Sửa thất bại";
    }

    @Override
    public String delete(String id) {
        boolean deleteMa = maRepo.delete(id);
        if(deleteMa){
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public String searchMa(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
