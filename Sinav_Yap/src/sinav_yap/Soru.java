/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinav_yap;

import java.io.Serializable;

public class Soru implements Serializable, Comparable<Soru>{
    
    private static final long serialVersionUID = -299482035708790407L;
    
    private String soruMetni;
    private String DogruCevap;
    private String VerilenCevap;
    private int puan;
    private int derece;
    private String tipi;

    public Soru() {
    }
    
    

    public Soru(String soruMetni, String dogruCevap, int puan, int derece, String tipi) {
        this.soruMetni = soruMetni;
        this.DogruCevap = dogruCevap;
        this.VerilenCevap = "";
        this.puan = puan;
        this.derece = derece;
        this.tipi = tipi;
    }
    
    

    public String getSoruMetni() {
        return soruMetni;
    }

    public String getDogruCevap() {
        return DogruCevap;
    }

    public int getPuan() {
        return puan;
    }

    public int getDerece() {
        return derece;
    }

    public String getTipi() {
        return tipi;
    }

    public String getVerilenCevap() {
        return VerilenCevap;
    }

    public void setVerilenCevap(String VerilenCevap) {
        this.VerilenCevap = VerilenCevap;
    }
    
    

    @Override
    public int compareTo(Soru o) {
        if(getPuan() > o.getPuan()) return 1;
        if(getPuan() < o.getPuan()) return -1;
        else return 0;
    }
}
