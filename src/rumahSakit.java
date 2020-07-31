/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class rumahSakit {

    /**
     * @param args the command line arguments
     */
    koneksi koneksi;
        public static void main(String[] args) {
        // TODO code application logic here
        koneksi konek = new koneksi();
        try 
        {
           new FLogin(null, true).setVisible(true);
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
        }
    }
}
