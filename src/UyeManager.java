import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UyeManager extends Veritabani {
    static Scanner scan = new Scanner(System.in);

    public static void uyeMenu() throws InterruptedException {
        String tercih = "";

        do { //TODO Kullanıcı Çıkış Yapmadığı Sürece, Menüyü Görmeye Devam Etsin...
            System.out.println(
                    "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                            "================= UYE MENU =================\n" +
                            "\n" +
                            "\t   1- Uye Listesi Yazdir\t\n" +
                            "\t   2- Soyisimden Uye Bulma\n" +
                            "\t   3- Sehire Gore Uye Bulma\n" +
                            "\t   4- Bilgilerini Girerek Uye Ekleme\n" +
                            "\t   5- Kimlik No Ile Kayit Silme \t\n" +
                            "\t   A- ANAMENU\n" +
                            "\t   Q- CIKIS\n");
            System.out.print("Tercihiniz : ");
            tercih = scan.nextLine();
            //TODO Kullanıcıdan alacağınız tercihe göre ilgili menü metodlarına yönlendirmeler yapın...
            switch (tercih) {
                case "1":
                    uyeListesiYazdir();
                    break;
                case "2":
                    soyisimdenUyeBulma();
                    break;
                case "3":
                    sehreGoreUyeBulma();
                    break;
                case "4":
                    uyeEkleme();
                    break;
                case "5":
                    tcNoIleUyeSil();
                    break;
                case "A":
                    Helper.anaMenu();
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz: ");

            }

        } while (!tercih.equalsIgnoreCase("Q"));
        Helper.projeDurdur();
    }

    public static void tcNoIleUyeSil() throws InterruptedException {
        // String sonucValue=null;
//        try {
            Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();
            //TODO Kullanıcıdan alacağınız kimlik no ile ilgili üyeyi kayıtlardan siliniz...
            System.out.print("Silinecek uyeye ait kimlik no giriniz: ");
            String silinecekValue = scan.nextLine();
            System.out.print("silinecekUye" + " Siliniyor...");
            for (int i = 0; i < 20; i++) {
                Thread.sleep(100);
                System.out.print(">");
            }
            boolean flag = true;
            for (Map.Entry<String, String> v : uyelerEntrySet) {
                if (v.getKey().equals(silinecekValue)) {
                    uyelerMap.remove(silinecekValue);
                }
                flag = false;
            }
            if (flag) {
                System.out.println("Istediginiz Tc numarasi ile uye bulunamadi.");
            }
            //TODO Gerekli atamaları yapınız. Aşağıdaki try-catch bloğu yardımcı olabilir...


            //boolean sonuc = sonucValue.equals(silinecekValue);
//        } catch (Exception e) {
//            System.out.println("Istediginiz Tc numarasi ile uye bulunamadi.");
//        }
    }

    public static void uyeEkleme() {
        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();
        System.out.print("Eklenecek üyenin TC no giriniz : ");
        String tcNo = scan.nextLine();
        System.out.print("Ad : ");
        String ad = scan.nextLine();
        System.out.print("Soyad : ");
        String soyad = scan.nextLine();
        System.out.print("Sehir : ");
        String sehir = scan.nextLine();
        System.out.print("Doğum Yılı : ");
        String dogumYili = scan.nextLine();
        String valueSehir = ad + ", " + soyad + ", " + sehir + ", " + dogumYili;
        uyelerMap.put(tcNo, valueSehir);
        //TODO Kullanıcıdan Tc no , Isim, Soyisim, Sehir, Dogum Yili alınız...
        //TODO Aldığınız değeri UyelerMap mapine uygun şekilde ekleyiniz...

    }

    public static void sehreGoreUyeBulma() throws InterruptedException {

        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde şehir araması yapın;
        //TODO Girilen şehire sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.print("Aradiginiz Uyenin Sehrini Giriniz : ");
        String arananSehir = scan.nextLine();
        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();
        boolean bulundu = true;
        System.out.println(
                "\n============= TECHNO STUDY CONFLUENCE =============\n" +
                        "=============== SEHIR ILE UYE ARAMA ===============\n" +
                        "TcNo : Isim , Soyisim , Sehir, D.Yili");
        for (Map.Entry<String, String> v : uyelerEntrySet) {
            String[] sehirler = v.getValue().split(", ");
            if (sehirler[2].equalsIgnoreCase(arananSehir)) {
                System.out.println(v.getKey() + " - " + v.getValue());
                bulundu = false;
            }
        }
        if (bulundu) {
            System.out.println("Böyle bir üye yoktur..");
        }
        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir... Zorunlu değil...

    }

    public static void soyisimdenUyeBulma() throws InterruptedException {
        //TODO Kullanıcıdan aldığınız girdiyle, UyelerMap'inde soyisim araması yapın;
        //TODO Girilen soyismine sahip tüm üyeleri map veya liste olarak döndürünüz...
        System.out.print("Aradiginiz uyenin soyisminin tamamini ya da birkismini giriniz : ");
        String arananSoyad = scan.nextLine();
        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();
        boolean bulundu = true;
        System.out.println(
                "\n========== TECHNO STUDY BOOTCAMP ===========\n" +
                        "=========== SOYISIM ILE UYE ARAMA ==========\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");
        for (Map.Entry<String, String> v : uyelerEntrySet) {
            String[] degerler = v.getValue().split(", ");

            if (degerler[1].contains(arananSoyad)) {
                System.out.println(v.getKey() + "-" + v.getValue());
                bulundu = false;
            }
        }
        if (bulundu) {
            System.out.println("Böyle bir üye yoktur..");
        }

        // printf veya String.format metodları kullanılarak daha düzgün bi çıktı elde edilebilir. Şart değil, isteğe bağlı.

        //TODO Syisminin bir kısmı girilse bile bulunan üyeler listelensin...
    }

    public static void uyeListesiYazdir() throws InterruptedException {
        //İPUCU METODU: Bu metodu değiştirmenize gerek yok...

        Set<Map.Entry<String, String>> uyelerEntrySet = uyelerMap.entrySet();

        System.out.print("Uye Listesi yazdiriliyor...");
        for (int i = 0; i < 20; i++) {
            Thread.sleep(100);
            System.out.print(">");
        }

        System.out.println(
                "\n========== TECHNO STUDY CONFLUENCE =========\n" +
                        "=============== UYE LISTESI ================\n" +
                        "TcNo : Isim , Soyisim , Sehir , D.Yili");

        // Daha düzgün bi görünüm için printf veya String.format kullanılabilir...
        for (Map.Entry<String, String> each : uyelerEntrySet) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            System.out.println(eachKey + " : " + eachValue + " | ");
        }
    }
}
