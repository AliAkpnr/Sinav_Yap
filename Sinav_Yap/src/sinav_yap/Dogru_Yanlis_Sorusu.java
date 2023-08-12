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
class Dogru_Yanlis_Sorusu extends Soru{

    public Dogru_Yanlis_Sorusu(String soruMetni, String dogruCevap, int puan, int derece) {
        super(soruMetni, dogruCevap, puan, derece, "dy");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test_Sorusu{soruMetni=").append(getSoruMetni());
        sb.append(",dogruCevap=").append(getDogruCevap());
        sb.append(",verilenCevap=").append(getVerilenCevap());
        sb.append(",puan=").append(getPuan());
        sb.append(",derece=").append(getDerece());
        sb.append(",tipi=").append(getTipi());
        sb.append('}');
        return sb.toString();
    }
}
