/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.MaGiamGia;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MaGiamGiaRepository {
    List<MaGiamGia> getAll();

    boolean addMa(MaGiamGia ma);

    boolean updateMa(String id, MaGiamGia ma);

    boolean delete(String id);
    
    boolean searchMa(String id);
}
