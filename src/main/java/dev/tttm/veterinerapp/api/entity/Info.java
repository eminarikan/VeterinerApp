package dev.tttm.veterinerapp.api.entity;

import java.util.HashMap;
import java.util.TreeMap;

public class Info {
    private String isim;
    private String aciklama;
    private TreeMap<Label, String> ucNoktolar= new TreeMap<Label, String>();

    public Info(){
        this.isim = "Veteriner App Web Servisi";
        this.aciklama = "Bu web servis MVC paterninde oluşturulmuş VeterinerApp uygulamasının uygulama programlama arayüzüdür.";
        this.ucNoktolar.put(new Label("/api",1), "GET isteğine karşılık servis hakkında bilgi verir.");
        this.ucNoktolar.put(new Label("/api/owners",2), "GET isteğine karşılık sistemde kayıtlı hayvan sahiplerini döner.");
        this.ucNoktolar.put(new Label("/api/owners",3), "POST isteğine karşılık istek gövdesi olarak gönderilen hayvan sahibini sisteme kaydeder.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}",4), "GET isteğine karşılık istenen 'id'deki hayvan sahibini döner.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}",5), "PUT isteğine karşılık istek gövdesi olarak gönderilen hayvan sahibini sistemde günceller.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}",6), "DELETE isteğine karşılık  istenen 'id'deki hayvan sahibini sistemden siler.");
        this.ucNoktolar.put(new Label("/api/pets",7), "GET isteğine karşılık  sistemde kayıtlı tüm hayvanları döner.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}/pets",8), "GET isteğine karşılık  istenen 'id'deki hayvan sahibinin sistemde kayıtlı tüm hayvanlarını döner.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}/pets",9), "POST isteğine karşılık  istenen 'id'deki hayvan sahibi için istek gövdesi olarak göndeilmiş hayvanı sisteme kaydeder.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}/pets/{petId}",10), "GET isteğine karşılık  istenen 'id'deki hayvan sahibin istenen 'id'deki hayvanını döner.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}/pets/{petId}",11), "PUT isteğine karşılık  istenen 'id'deki hayvan sahibin istenen 'id'deki hayvanını günceller.");
        this.ucNoktolar.put(new Label("/api/owners/{ownerId}/pets/{petId}",12), "DELETE isteğine karşılık  istenen 'id'deki hayvan sahibin istenen 'id'deki hayvanını siler.");
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public TreeMap<Label, String> getUcNoktolar() {
        return ucNoktolar;
    }

    public void setUcNoktolar(TreeMap<Label, String> ucNoktolar) {
        this.ucNoktolar = ucNoktolar;
    }

    private static class Label implements Comparable<Label>{
        String endpoint;
        Integer index;
        Label(String endpoint, Integer index){
            this.endpoint = endpoint;
            this.index = index;
        }

        @Override
        public String toString() {
            return endpoint;
        }

        public Integer getIndex() {
            return index;
        }

        @Override
        public int compareTo(Label o) {
            return this.index.compareTo(o.getIndex());
        }
    }
}
