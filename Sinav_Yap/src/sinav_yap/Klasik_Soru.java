/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinav_yap;

/**
 *
 * @author engineer
 */
public class Klasik_Soru extends Soru{
    
    public Klasik_Soru(String soruMetni, String dogruCevap, int puan, int derece) {
        super(soruMetni, dogruCevap, puan, derece, "klasik");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Klasik_Soru{soruMetni=").append(getSoruMetni());
        sb.append(",dogruCevap=").append(getDogruCevap());
        sb.append(",verilenCevap=").append(getVerilenCevap());
        sb.append(",puan=").append(getPuan());
        sb.append(",derece=").append(getDerece());
        sb.append(",tipi=").append(getTipi());
        sb.append('}');
        return sb.toString();
    }
}
