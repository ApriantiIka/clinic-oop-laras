# <h1 align="center">Clinic Management System - Java OOP</h1>
<p align="center">Aprianti Ika Larasati</p>
<p align="center">2311110023</p>

## Unguided 

### Class Doctor

```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USER
 */
public class Doctor {
    private String id;
    private String name;
    private List<Appointment>appointments;
    
    public Doctor(String id, String name){
        this.id = id;
        this.name = name;
        this.appointments = new ArrayList<>();
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public List<Appointment> getAppointments(){
        return appointments;
    }
    
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
    
    public void printInfo(){
        System.out.println("Doctor ID: " + id + ", Name: " + name);
    }
}
```

Class `Doctor` digunakan untuk menampilkan data seorang dokter dalam sistem. Class ini memiliki tiga atribut utama, yaitu `id`, `name`, dan `appointments`. Atribut `id` digunakan untuk menyimpan identitas unik dokter, sementara `name` menyimpan nama dokter. Atribut `appointments` adalah sebuah list yang menyimpan daftar janji temu (appointment) yang dimiliki dokter tersebut.

Dalam hal encapsulation, semua atribut dalam class ini memiliki akses private, sehingga hanya class itu sendiri yang dapat mengaksesnya. Untuk mengontrol akses ke data, terdapat getter methods seperti `getId()`, `getName()`, dan `getAppointments()` yang memungkinkan objek luar untuk membaca nilai atribut tanpa bisa mengubahnya secara langsung. Selain itu, terdapat method `addAppointment(Appointment appointment)` yang digunakan untuk menambahkan janji temu ke dalam daftar `appointments`. Method `printInfo()` digunakan untuk mencetak informasi dokter ke konsol.

Dengan method ini, data dokter tetap aman dan hanya bisa dimanipulasi dengan method yang telah ditentukan. Hal ini memastikan bahawa data dokter diatur secara teratur di dalam sistem.

### Class Patient
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class Patient {
    private String id;
    private String name;
    private String diagnosis;
    
    public Patient(String id, String name, String diagnosis){
        this.id = id;
        this.name = name;
        this.diagnosis = diagnosis;
        DiagnosisCounter.addDiagnosis();
    }
    
    public String getId(){
        return id;
    }
    
    public String getName(){
        return name;
    }
    
    public String getDiagnosis(){
        return "Access Denied"; // Secure data
    }
    
    public void printInfo(){
        System.out.println("Patient ID: " + id + ", Name: " + name);
    }
}
```

Class `Patient` digunakan untuk menampilkan data seorang pasien dalam sistem. Class ini memiliki tiga atribut utama, yaitu `id`, `name`, dan `diagnosis`. Atribut `id` menyimpan identitas unik pasien, `name` digunakan untuk menyimpan nama pasien, dan `diagnosis` berisi informasi medis mengenai penyakit atau kondisi pasien.

Dalam hal encapsulation, semua atribut bersifat private, sehingga hanya class itu sendiri yang dapat mengaksesnya dan tidak dapat diakses langsung dari luar class. Untuk mengontrol akses ke data, terdapat getter methods seperti `getId()` dan `getName()` yang mengembalikan nilai atributnya masing-masing. Namun, pada `getDiagnosis()`, alih-alih mengembalikan diagnosis asli pasien, method ini hanya mengembalikan string `"Access Denied"`. Hal ini dilakukan untuk memastikan bahwa informasi sensitif seperti data medis pasien tidak dapat diakses secara langsung oleh objek lain.

Selain itu, setiap kali objek `Patient` dibuat, method `DiagnosisCounter.addDiagnosis()` dipanggil untuk menambah jumlah total diagnosis yang telah dicatat dalam sistem. Hal ini berguna untuk melacak jumlah total pasien dengan diagnosis tertentu. Class ini juga memiliki method `printInfo()`, yang digunakan untuk mencetak informasi dasar pasien ke konsol tanpa membocorkan data medisnya. Dengan desain ini, informasi pasien tetap aman, tetapi tetap memungkinkan manipulasi data yang diperlukan dalam sistem.

### Class DataChecker
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class DataChecker {
    public static boolean validateId(String id){
        boolean isValid = id.matches("D\\d{3}") || id.matches("P\\d{3}");
        System.out.println("ID " + id + " is valid" + isValid);
        return isValid;
    }
}
```

Class `DataChecker` berfungsi sebagai validator ID untuk memastikan bahwa ID yang digunakan dalam sistem sesuai dengan format yang telah ditentukan. Class ini hanya memiliki satu static method, yaitu `validateId(String id)`, yang digunakan untuk memeriksa apakah ID yang diberikan valid atau tidak.  

Method `validateId()` bekerja dengan memeriksa apakah ID dimulai dengan huruf `'D'` (untuk dokter) atau `'P'` (untuk pasien), diikuti oleh tiga digit angka. Jika ID sesuai dengan pola ini, maka method akan mencetak bahwa ID tersebut valid dan mengembalikan nilai `true`. Jika tidak sesuai, method akan mencetak bahwa ID tidak valid dan mengembalikan nilai `false`.  

Karena method ini bersifat static, maka tidak perlu membuat objek `DataChecker` untuk menggunakannya. Cukup dengan memanggil `DataChecker.validateId(id)`, sistem dapat langsung memeriksa validitas ID yang diberikan. Dengan adanya class ini, sistem dapat memastikan bahwa setiap dokter dan pasien memiliki ID yang sesuai standar, sehingga membantu dalam menjaga integritas dan keteraturan data.

### Class DiagnosisCounter
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class DiagnosisCounter {
    private static int count = 0;
    
    public static void addDiagnosis(){
        count++;
        System.out.println("New diagnosis recorded. Total diagnosis: " + count);
    }
    
    public static int getDiagnosisCount(){
        return count;
    }
}
```

Class `DiagnosisCounter` digunakan untuk melacak jumlah total diagnosis yang tercatat dalam sistem. Class ini memiliki satu atribut static, yaitu `count`, yang digunakan untuk menyimpan jumlah diagnosis yang telah direkam. Karena atribut ini bersifat static, nilainya akan dipertahankan di seluruh sistem dan tidak tergantung pada objek tertentu.

Method `addDiagnosis()` digunakan untuk menambah jumlah diagnosis setiap kali objek `Patient` baru dibuat. Saat method ini dipanggil, nilai `count` akan bertambah satu, dan sistem akan mencetak pesan yang menunjukkan jumlah total diagnosis yang telah tercatat. Selain itu, terdapat method `getDiagnosisCount()` yang mengembalikan nilai `count` saat ini, memungkinkan bagian lain dari program untuk melihat berapa banyak diagnosis yang telah direkam.

Karena semua atribut dan method dalam class ini bersifat static, class `DiagnosisCounter` berfungsi sebagai utility class yang tidak perlu diinstansiasi untuk digunakan. Dengan adanya class ini, sistem dapat dengan mudah memantau jumlah total diagnosis yang telah dimasukkan, yang dapat berguna untuk analisis data medis atau pelaporan statistik.

### Class Appointment
```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modul4.Unguided.entities;

/**
 *
 * @author USER
 */
public class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String date;
    
    public Appointment(Doctor doctor, Patient patient, String date){
        this.doctor = doctor;
        this.patient = patient;
        this.date = date;
        doctor.addAppointment(this);
    }
    
    public Doctor getDoctor(){
        return doctor;
    }
    
    public Patient getPatient(){
        return patient;
    }
    
    public String getDate(){
        return date;
    }
    
    public void printInfo(){
        System.out.println("Appointment: " + doctor.getName() + " with " + patient.getName() + " on " + date);
    }
    
    public static void main(String[] args) {
        // Create doctor and patient
        Doctor doc = new Doctor("D001", "Dr. Cinta");
        Patient pat = new Patient("P001", "Ms. Alison Swift", "Flu");
        
        //Validate IDs
        DataChecker.validateId(doc.getId());
        DataChecker.validateId(pat.getId());
        
        // Create appointment
        Appointment app = new Appointment(doc, pat, "2025-03-17");
        
        // Print details
        doc.printInfo();
        pat.printInfo();
        app.printInfo();
        
        // Show diagnosis count
        System.out.println("Total Diagnoses recorded: " + DiagnosisCounter.getDiagnosisCount());
    }
}
```
#### Output:
![Image](https://github.com/user-attachments/assets/4a587100-d1c9-43fe-b7b3-25d233517fc7)

Class `Appointment` digunakan untuk menampilkan janji temu antara seorang dokter dan pasien dalam sistem. Class ini memiliki tiga atribut utama, yaitu `doctor`, `patient`, dan `date`. Atribut `doctor` mereferensikan objek dari class `Doctor`, sedangkan `patient` mereferensikan objek dari class `Patient`, sehingga membentuk hubungan yang jelas antara dokter dan pasien. Atribut `date` digunakan untuk menyimpan tanggal janji temu dalam format string.

Dari segi encapsulation, semua atribut dalam class ini bersifat private, yang berarti hanya dapat diakses melalui method yang disediakan. Untuk mengambil informasi dari setiap atribut, terdapat method getter seperti `getDoctor()`, `getPatient()`, dan `getDate()`. Selain itu, terdapat method `printInfo()` yang mencetak informasi lengkap tentang janji temu, termasuk nama dokter, nama pasien, dan tanggal janji temu.

Ketika sebuah objek `Appointment` dibuat, janji temu tersebut secara otomatis ditambahkan ke daftar janji temu dokter dengan memanggil `doctor.addAppointment(this)`. Hal ini memastikan bahwa setiap dokter memiliki daftar janji temu yang tersimpan dengan baik dalam sistem. Selain itu, class `Appointment` juga mengandung method `main()`, yang berarti class ini bisa langsung dijalankan sebagai entry point dari program. Di dalam `main()`, sistem membuat objek dokter dan pasien, memvalidasi ID mereka menggunakan `DataChecker`, membuat janji temu baru, mencetak informasi dokter, pasien, serta janji temu, dan akhirnya menampilkan jumlah total diagnosis yang telah tercatat. Dengan struktur ini, class `Appointment` berfungsi sebagai penghubung utama antara dokter dan pasien, serta menjadi pusat dari eksekusi program utama.

## Kesimpulan
Dengan menggunakan prinsip Java Object-Oriented Programming (OOP), program ini dimaksudkan untuk mengelola data medis, pasien, dan janji temu secara aman dan terorganisir.  

Class `Doctor` dan `Patient` merupakan entitas utama dalam sistem dengan data yang terlindungi melalui encapsulation menggunakan private fields dan getter methods. Data sensitif, seperti diagnosis pasien, dilindungi dengan kontrol akses ketat sehingga tidak dapat diakses secara langsung. Class `Appointment` berfungsi sebagai penghubung antara dokter dan pasien memastikan setiap janji temu tersimpan dalam daftar dokter. Class ini juga mengandung method `main()` yang menjadi titik eksekusi program utama.  
Class `DataChecker` meningkatkan keamanan dan efisiensi sistem dengan memvalidasi ID dokter dan pasien, memastikan format yang benar sebelum data digunakan dalam sistem. Selain itu, class `DiagnosisCounter` memungkinkan sistem untuk melacak jumlah diagnosis yang telah dicatat yang berguna dalam analisis data medis dan pelaporan statistik.  

Dengan struktur ini, program tidak hanya memastikan keteraturan dan keamanan data tetapi juga mempermudah pengembangan di masa depan karena setiap komponen memiliki tanggung jawab yang jelas, memanfaatkan relasi antarclass dengan baik, dan menerapkan best practices dalam OOP.