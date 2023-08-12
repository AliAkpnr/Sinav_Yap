/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinav_yap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author aliak
 */
public class Sinav_Yap {

    static ArrayList<Soru> soruBankası = new ArrayList<>();
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        
        
        ///////////////////////////////////////// Kullanıcı arayüzü////////////////////////////////
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("1. Soru Ekle\n2. Soru Cikar\n3. Listele\n4. Sınav Yap\n5. Cikis\nSec: ");
            int secim=scan.nextInt();
            switch(secim){
                case 1:{
                    Soru soru=null;
                    System.out.print("1. Test\n2.Dogru-Yanlis\n3.Bosluk Doldurma\n4.Klasik\n5. Cikis\nSec: ");
                    int secim1 = scan.nextInt();
                    switch(secim1){
                        case 1:{
                            
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("A = ");
                            String a = scan.next();

                            System.out.print("B = ");
                            String b = scan.next();

                            System.out.print("C = ");
                            String c = scan.next();

                            System.out.print("D = ");
                            String d = scan.next();
                            
                            System.out.print("Cevap(A,B,C,D) = ");
                            String cevap = scan.next();

                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int derece = scan.nextInt();
                            
                            soru = new Test_Sorusu(a, b, c, d, soruMetni, cevap, puan, derece);
                            soruBankası.add(soru);
                            break;
                        }
                        case 2:{
                            
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap(D,Y) = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int derece = scan.nextInt();
                            
                            soru = new Dogru_Yanlis_Sorusu(soruMetni, cevap, puan, derece);
                            soruBankası.add(soru);
                            break;
                        }
                        case 3:{
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int derece = scan.nextInt();
                            
                            soru = new Dogru_Yanlis_Sorusu(soruMetni, cevap, puan, derece);
                            soruBankası.add(soru);
                            break;
                        }
                        case 4:{
                            System.out.print("Soru metni = ");
                            String soruMetni = scan.next();
                            
                            System.out.print("Cevap = ");
                            String cevap = scan.next();
                            
                            System.out.print("Puan (5,10,15,20) = ");
                            int puan = scan.nextInt();

                            System.out.print("Zorluk(1.Kolay,2.Orta,3.Zor) = ");
                            int derece = scan.nextInt();
                            
                            soru = new Dogru_Yanlis_Sorusu(soruMetni, cevap, puan, derece);
                            soruBankası.add(soru);
                            break;
                        }
                    }
                    SoruyuKaydet(soru);    ////////////////  Dosyaya kaydet
                    break;
                }
                case 2:{
                    System.out.print("Soru bul =");
                    String metin = scan.next();
                    if(Sil(metin)){
                        System.out.println("Silindi");
                    }
                    else{
                        System.out.println("Silinemedi");
                    }
                    break;
                }
                case 3:{
                    System.out.print("a.Soru Metni \nb.Sıklar Metni \nc.Cevaplar\nd.Puan\ne.Derece\nf.Soru Tipi\ng.Hepsi\nFiltre Sec:");
                    String secim2 = scan.next();
                    String filtre="";
                    if(secim2.equals("g")){
                        filtre = "";
                    }
                    else if(secim2.equals("f")){
                        System.out.print("1.Test\n2.Dogru/Yanlis\n3.Klasik\n4.Bosluk Doldurma\nSec:");
                        int secim3 = scan.nextInt();
                        if(secim3==1) filtre = "test";
                        if(secim3==2) filtre = "dy";
                        if(secim3==3) filtre = "klasik";
                        if(secim3==4) filtre = "bosluk";
                    }
                    else{
                        System.out.println("Aranan = ");
                        filtre = scan.next();
                    }
                    
                    Yazdir(Filtrele(secim2, filtre));
                    break;
                }
                case 4:{
                    System.out.print("1.Test\n2.Klasik\n3.Karisik\nSec:");
                    int secim3 = scan.nextInt();
                    ArrayList<Soru> sinavSorulari = SinavSirala(SinavOlustur(secim3));
                    ArrayList<Soru> yapilanlar = new ArrayList<>();
                    int puan=0;
                    for(int i=0;i<sinavSorulari.size();i++){
                        Soru soru=sinavSorulari.get(i);
                        System.out.println(i+".) "+ soru.getSoruMetni());
                        if(soru.getTipi().equals("test")){
                            Test_Sorusu test = (Test_Sorusu) soru;
                            System.out.println("A.)"+test.getA());
                            System.out.println("B.)"+test.getB());
                            System.out.println("C.)"+test.getC());
                            System.out.println("D.)"+test.getD());
                        }
                        
                        System.out.print("Cevap =");
                        String cevap= scan.next();
                        soru.setVerilenCevap(cevap);
                        yapilanlar.add(soru);
                        if(soru.getTipi().equals("test") && cevap.equals(soru.getDogruCevap())) puan+=soru.getPuan();
                    }
                    System.out.println("Test Sinavi Toplam Puan = " + puan);
                    SinaviKaydet(yapilanlar);
                    break;
                }
                case 5:{
                    System.exit(0);
                    break;
                }
            }
            
           
            
        }while(true);
    }
    
    
    
    static void SoruyuKaydet(Soru soru) throws FileNotFoundException, IOException{
        File f = new File("sorubankasi.dat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(soru);
        oos.close();
        fos.close();
    }
    
    static void SinaviKaydet(ArrayList<Soru> list) throws IOException{
        File f = new File("sinavlar.dat");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
    }
    
    static ArrayList<Soru> SinavOlustur(int secim) throws FileNotFoundException{
        
        ArrayList<Soru> havuz = new ArrayList<>();
        if(secim == 1){
            havuz = Filtrele("f","test");
        }
        if(secim == 2){
            havuz = Filtrele("f","klasik");
        }
        if(secim == 3){
            havuz = soruBankası;
        }
        
        ArrayList<Soru> sınavSrulari = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList();
        int TopPuan = 0;
        Random r=new Random();
        do{
            if(list.size() == havuz.size()) break;
            int i = r.nextInt(havuz.size());
            if(Kontrol(list, i)){
                Soru soru = havuz.get(i);
                sınavSrulari.add(soru);
                TopPuan += soru.getPuan();
                list.add(i);
            }
            if(TopPuan>=100 && TopPuan<=110) break;
        }while(true);
        return sınavSrulari;
    }
    
    
    static boolean Kontrol(ArrayList<Integer> list,int i){
        for(int j=0;j<list.size();j++){
            if(list.get(j) == i) return false;
        }
        return true;
    }
    static ArrayList<Soru> Filtrele(String secim, String filtre ){
        ArrayList<Soru> sorular = new ArrayList<>();
        for(Soru soru : soruBankası){
            switch(secim){
                case "a":{
                    if(soru.getSoruMetni().contains(filtre)) sorular.add(soru);
                    break;
                }
                case "b":{
                    if(soru.getTipi().equals("test")){
                        Test_Sorusu ts = (Test_Sorusu) soru;
                        if(ts.getA().contains(filtre) 
                            || ts.getB().contains(filtre)
                            || ts.getC().contains(filtre)
                            || ts.getD().contains(filtre)
                        ) sorular.add(soru);
                    }
                    break;
                }
                case "c":{
                    if(soru.getDogruCevap().equals(filtre)) sorular.add(soru);
                    break;
                }
                case "d": {
                    if(soru.getPuan() == Integer.parseInt(filtre)) sorular.add(soru);
                    break;
                }
                case "e":{
                    if(soru.getDerece()== Integer.parseInt(filtre)) sorular.add(soru);
                    break;
                }
                case "f":{
                    if(soru.getTipi().equals(filtre)) sorular.add(soru);
                    break;
                }
                case "g":{
                    sorular.add(soru);
                }
            }
        }
        return Sirala(sorular);
    }
    
    static ArrayList<Soru> Sirala(ArrayList<Soru> list){
        for(int i=0;i<list.size();i++){
            for(int j=0; j<list.size();j++){
                if(list.get(i).compareTo(list.get(j))<0){
                    Soru gecici = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, gecici);
                }
            }
        }
        return list;
    }
    
    static ArrayList<Soru> SinavSirala(ArrayList<Soru> sorular){
        ArrayList<Soru> list = new ArrayList<>();
        for(int i=0;i<sorular.size();i++){
            if(sorular.get(i).getTipi().equals("test")) list.add(sorular.get(i));
        }
        for(int i=0;i<sorular.size();i++){
            if(sorular.get(i).getTipi().equals("klasik")) list.add(sorular.get(i));
        }
        for(int i=0;i<sorular.size();i++){
            if(sorular.get(i).getTipi().equals("dy")) list.add(sorular.get(i));
        }
        for(int i=0;i<soruBankası.size();i++){
            if(soruBankası.get(i).getTipi().equals("bosluk")) list.add(soruBankası.get(i));
        }
        return list;
    }
    
    static void Yazdir(ArrayList<Soru> sorular){
        for(int i=0;i<sorular.size();i++){
            Soru soru = sorular.get(i);
            System.out.println(i + ".)" + soru.getSoruMetni());
            if(soru.getTipi().equals("test")){
                Test_Sorusu ts = (Test_Sorusu) soru;
                System.out.println("A.)"+ ts.getA());
                System.out.println("B.)"+ ts.getB());
                System.out.println("C.)"+ ts.getC());
                System.out.println("D.)"+ ts.getD());
            }
            System.out.println("Dogru Cevap=)"+ soru.getDogruCevap());
            System.out.println("Puan=)"+ soru.getPuan());
            System.out.println("Derece=)"+ soru.getDerece());
            System.out.println("Tipi=)"+ soru.getTipi());
        }
    }
    
    static boolean Sil(String metin){
        for(int i=0;i<soruBankası.size();i++){
            if(soruBankası.get(i).getSoruMetni().contains(metin)){
                soruBankası.remove(i);
                return true;
            }
        }
        return false;
    } 
}
