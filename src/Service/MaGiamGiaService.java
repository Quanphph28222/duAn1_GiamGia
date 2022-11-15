/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MaGiamGia;
import java.util.List;

/**
 *
 * @author admin
 */
public interface MaGiamGiaService {

    List<MaGiamGia> getAll();

    String addMa(MaGiamGia ma);

    String updateMa(String id, MaGiamGia ma);

    String delete(String id);

    String searchMa(String id);
}
