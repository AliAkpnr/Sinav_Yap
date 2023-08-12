package sinav_yap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali Akpınar
 */
public class Test_Sorusu extends Soru{

    private final String a;
    private final String b;
    private final String c;
    private final String d;

    
    public Test_Sorusu(String a, String b, String c, String d, String soruMetni, String dogruCevap, int puan, int derece) {
        super(soruMetni, dogruCevap, puan, derece, "test");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test_Sorusu{soruMetni=").append(getSoruMetni());
        sb.append(",a=").append(a);
        sb.append(",b=").append(b);
        sb.append(",c=").append(c);
        sb.append(",d=").append(d);
        sb.append(",dogruCevap=").append(getDogruCevap());
        sb.append(",verilenCevap=").append(getVerilenCevap());
        sb.append(",puan=").append(getPuan());
        sb.append(",derece=").append(getDerece());
        sb.append(",tipi=").append(getTipi());
        sb.append('}');
        return sb.toString();
    }
    
}
