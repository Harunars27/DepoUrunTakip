# Mad Med Depo - F&B Envanter Yönetim Sistemi

Otel ve restoranların Yiyecek & İçecek (F&B) departmanları için özel olarak tasarlanmış, gerçek zamanlı bir stok takip ve envanter yönetim otomasyonudur. Departmanlar arası malzeme akışını (giriş/çıkış) kontrol altına alarak operasyonel süreçleri hızlandırmayı ve stok kayıplarını en aza indirmeyi hedefler.

## 🚀 Öne Çıkan Özellikler

* **Dinamik Kategori Yönetimi:** Ürünleri Züccaciye, Sarf Malzeme, Temizlik, Bar Ekipmanları gibi departmanlara göre otomatik gruplayarak listeleme.
* **Hızlı Stok Operasyonları:** Tek tıkla ana depodan mal çekme (+ Giriş) ve kullanıma verme (- Çıkış) işlemleri.
* **Asenkron Veri Akışı:** Sayfa yenilenmesine gerek kalmadan, JavaScript Fetch API ile anlık stok güncellemeleri.
* **Güvenli İşlem Yapısı:** Yetersiz stok durumlarında veya hatalı girişlerde devreye giren Backend validasyonları (Transaction yönetimi).
* **Responsive Arayüz:** Bootstrap 5 ile kurgulanmış, kullanıcı dostu ve modern tasarım.

## 🛠️ Kullanılan Teknolojiler

* **Backend:** Java 21, Spring Boot, Spring Data JPA, Hibernate
* **Veritabanı:** MySQL
* **Frontend:** HTML5, CSS3, Vanilla JavaScript, Bootstrap 5
* **Mimari:** RESTful API Katmanlı Mimari (Controller, Service, Repository)

## ⚙️ Kurulum ve Çalıştırma

Projeyi yerel ortamınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

1. Bu depoyu bilgisayarınıza klonlayın:
   ```bash
   git clone [https://github.com/Harunars27/envanterkontrol.git](https://github.com/Harunars27/envanterkontrol.git)

2. MySQL veritabanınızda `madmeddepo` adında boş bir şema oluşturun.
3. `src/main/resources/application.properties` dosyası içerisindeki MySQL kullanıcı adı ve şifre bilgilerinizi kendi lokal ortamınıza göre güncelleyin.
4. Projeyi bir IDE (IntelliJ IDEA vb.) üzerinden çalıştırın.
5. Tarayıcınızdan `http://localhost:8080` adresine giderek arayüze erişim sağlayın.

## 📡 REST API Uç Noktaları (Endpoints)

Sistem dışarıya açık aşağıdaki API uç noktalarını sunmaktadır:

| HTTP Metodu | Endpoint | Açıklama |
| --- | --- | --- |
| **GET** | `/api/stok/urunler` | Veritabanındaki tüm ürünleri listeler. |
| **POST** | `/api/stok/urun-ekle` | Sisteme yeni bir ürün tanımlar. |
| **POST** | `/api/stok/hareket` | Mevcut ürünün stok miktarını günceller (Giriş/Çıkış). |
| **DELETE** | `/api/stok/sil/{id}` | Belirtilen ID'ye sahip ürünü veritabanından kalıcı olarak siler. |

---

**Geliştirici:** Harun Arslan

