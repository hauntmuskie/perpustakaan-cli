import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

class App {

    public static void main(String[] args) throws IOException, Exception {
        // Class Input
        BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));
        Scanner scInput = new Scanner(System.in);

        // Rionggo Rahardi
        // Menu
        System.out.println("Selamat Datang di Aplikasi Sistem Informasi Perpustakaan");
        System.out.println("#--------------#");
        System.out.println("| 1. Login    |");
        System.out.println("| 2. Register |");
        System.out.println("| 3. Exit     |");
        System.out.println("#--------------#");
        System.out.println();

        // Menu Input
        System.out.print("Masukkan Pilihan Anda : ");
        int userMenuInput = Integer.parseInt(brInput.readLine());

            while (!(userMenuInput == 1 || userMenuInput == 2 || userMenuInput == 3)) {
                System.out.println("Pilihan Anda Salah!, Silahkan Coba Lagi ");
                System.out.println("#--------------#");
                System.out.println("| 1. Login    |");
                System.out.println("| 2. Register |");
                System.out.println("| 3. Exit     |");
                System.out.println("#--------------#");
                System.out.println();

                // Menu Input
                System.out.print("Masukkan Pilihan Anda : ");
                userMenuInput = Integer.parseInt(brInput.readLine());
            }

            if (userMenuInput == 1) {
                String userLoginUsername = JOptionPane.showInputDialog(null, "Masukkan Username Anda : ");
                String userLoginPassword = JOptionPane.showInputDialog(null, "Masukkan Password Anda : ");
                while (!(userLoginUsername.equals("admin") && userLoginPassword.equals("lmao"))) {
                    JOptionPane.showMessageDialog(null, "Username atau Password Anda Salah!, Silahkan Coba Lagi ");
                    userLoginUsername = JOptionPane.showInputDialog(null, "Masukkan Username Anda : ");
                    userLoginPassword = JOptionPane.showInputDialog(null, "Masukkan Password Anda : ");
                }

                // Greetings Message
                JOptionPane.showMessageDialog(null, "Selamat Datang " + userLoginUsername);
                JOptionPane.showMessageDialog(null, "Anda Berhasil Login Pada, " + new Date() + 
                                                    "\nSilahkan Ikuti Instruksi Selanjutnya.\n" + 
                                                    "\nJika Terdapat Error Silahkan Kirim Email Ke rioclasher4@proton.me");
                
            } else if (userMenuInput == 2) {
                // Register
                System.out.println("Register");
                String userNameRegister = JOptionPane.showInputDialog("Buat Username : ");
                String userFullNameRegister = JOptionPane.showInputDialog("Nama Lengkap : ");
                String userPasswordRegister = JOptionPane.showInputDialog("Password : ");
                String pwdConfirm = JOptionPane.showInputDialog("Konfirmasi Password : ");

                    // Cek Password
                    while (!userPasswordRegister.equals(pwdConfirm)) {
                        JOptionPane.showMessageDialog(null, "Password Tidak Sama \nSilahkan Coba Lagi!");
                        userPasswordRegister = JOptionPane.showInputDialog("Masukkan Password : ");
                        pwdConfirm = JOptionPane.showInputDialog("Konfirmasi Password : ");
                    }

                long userNpmRegister = Long.parseLong(JOptionPane.showInputDialog("Masukkan NPM : "));
                String userEmailRegister = JOptionPane.showInputDialog("Masukkan Email : ");

                // Cek Register
                JOptionPane.showMessageDialog(null, "Selamat Datang Pengguna Baru @" + userNameRegister +
                                                    "\nNama Lengkap : " + userFullNameRegister +
                                                    "\nNPM : " + userNpmRegister +
                                                    "\nEmail : " + userEmailRegister);

                int emailNotifier = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Dapat Peberitahuan Melalui Email? ");

                    if (emailNotifier == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Pemberitahuan Melalui Email Telah Diaktifkan");
                    }

                System.out.println("Selamat Datang di Perpustakaan dan Selamat Menggunakan Program Kami");

            } else if (userMenuInput == 3) {
                int exit = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Ingin Keluar?");

                    if (exit == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Terima Kasih Telah Menggunakan Perpustakaan Kami");
                        System.exit(420);
                    }
            }

        System.out.println();
        System.out.println("Silahkan Pilih Menu Berikut Ini");
        System.out.println("#-------------------------#");
        System.out.println("| 1. Lanjutkan Peminjaman |");
        System.out.println("| 2. Pengembalian Buku    |");
        System.out.println("#-------------------------#");
        System.out.println();

        // Menu Input
        System.out.print("Masukkan Pilihan Anda : ");
        int nextMenu = Integer.parseInt(brInput.readLine());

            if (nextMenu == 2) {
                // Egi Saputra
                // Variabel
                String kelasPeminjam, namaPeminjam, prodiPeminjam = "";
                long npmPeminjam, notlpPeminjam = 0;            

                // Input
                System.out.println("-----------------------------------------------");
                System.out.println("|               DATA PENGEMBALIAN             |");
                System.out.println("-----------------------------------------------");
                System.out.println();
                System.out.println("Dimohon Untuk Mengisi Data Diri Anda : ");
                System.out.println();
                System.out.print("Silahkan Masukkan Nama Anda   : ");
                namaPeminjam = scInput.nextLine();

                System.out.print("Silahkan Masukkan NPM Anda    : ");
                npmPeminjam = Long.parseLong(scInput.nextLine());

                System.out.print("Silahkan Masukkan Kelas Anda  : ");
                kelasPeminjam = scInput.nextLine();

                System.out.print("Silahkan Masukkan No.Tlp Anda : ");
                notlpPeminjam = Long.parseLong(scInput.nextLine());
                
                System.out.print("Silahkan Masukkan Program Studi Anda : ");
                prodiPeminjam = scInput.nextLine(); 

            } else if (nextMenu == 1) {
                // Main Program After Success Login
                int confirm = JOptionPane.showConfirmDialog(null, "Silahkan Baca Instruksi Berikut! \n" +
                "1. Kamu akan Diminta Untuk Memasukkan Data Diri\n" + 
                "2. Setelah itu, kamu akan diminta untuk memasukkan data buku yang ingin kamu pinjam\n" +
                "3. Input data petugas yang sedang bekerja\n" +
                "4. Dan terakhir anda akan diminta untuk mengkonfirmasi data yang telah diinputkan\n" +
                "\n" + 
                "Apakah Anda Ingin Melanjutkan? ");

                if (confirm != JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Terima Kasih Telah Menggunakan Perpustakaan Kami");
                    System.exit(420);
                }


            // Main Program If User Confirm
            // Amelia Azra Pakaya 
            String jenisBukuPilihan = "";
            System.out.println(" .....Pilihan Jenis Buku.....");
            System.out.println();
            System.out.println(" ============================");
            System.out.println(" |    No   |   Jenis Buku   |");
            System.out.println(" ============================");
            System.out.println(" |   [1]   |     Fiksi      |");  
            System.out.println(" |   [2]   |   Non Fiksi    |"); 
            System.out.println(" ============================");
                            
            System.out.print("Masukan Pilihan [1/2] : ");
            int userJenisBuku = Integer.parseInt(scInput.nextLine());

                switch (userJenisBuku) {
                    default :
                        System.out.println("Pilihan anda tidak ada!");
                        break;
                        
                    case 1 :    
                        System.out.println("Pilihan Anda : Fiksi");
                        String[] jenisBuku = new String[4];
                        jenisBuku[1] = "[ 1. Novel  ]";
                        jenisBuku[2] = "[ 2. Komik  ]";
                        jenisBuku[3] = "[ 3. Cerpen ]";

                            for (int i=1; i < jenisBuku.length; i++) {
                                System.out.println(jenisBuku[i]);
                            }

                        System.out.println();
                        System.out.print("Masukan Pilihan Jenis Buku [1/2/3] : ");
                        int userBuku = Integer.parseInt(scInput.nextLine());

                            if (userBuku == 1) {
                                jenisBukuPilihan += "Novel";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan);
                
                            } else if (userBuku == 2) {
                                jenisBukuPilihan += "Komik";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan);
                
                            } else if (userBuku == 3) {
                                jenisBukuPilihan += "Cerpen";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan);
                            } else {
                                System.out.println("Maaf, Pilihan tidak tersedia");
                                System.out.println("Silahkan Coba Lagi");
                                System.exit(0);
                            }
                        break;
                            
                    case 2 :
                        System.out.println("Pilihan Anda : Non Fiksi");
                        String[] jenis = new String[4];
                        jenis[1] = "[  1.    Kamus      ]";
                        jenis[2] = "[  2. Pengetahuan   ]";
                        jenis[3] = "[  3. Ensiklopedia  ]";

                            for (int i=1; i < jenis.length; i++){
                                System.out.println(jenis[i]);
                            }

                        System.out.println();
                        System.out.print("Masukan Pilihan Jenis Buku [1/2/3] : ");
                        int userBook = Integer.parseInt(scInput.nextLine());
                    
                            if (userBook == 1) {
                                jenisBukuPilihan += "Kamus";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan );
                    
                            } else if (userBook == 2) {
                                jenisBukuPilihan += "Pengetahuan";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan);
                    
                            } else if (userBook == 3) {
                                jenisBukuPilihan += "Ensiklopedia";
                                System.out.println("Jenis Buku : "+ jenisBukuPilihan);
                                
                            } else {
                                System.out.println("Maaf, Pilihan tidak tersedia");
                                System.out.println("Silahkan Coba Lagi");
                                System.exit(0);
                            }

                    
                }

            // Siti Mawwadah
            System.out.println();
            System.out.println("------------------------------");
            System.out.println("|     Input Data Petugas     |");
            System.out.println("------------------------------");
            System.out.print("Masukkan Nama : ");
            String userNama = scInput.nextLine();
            
            String Jabatan = "";
            System.out.println("--------------------------------");
            System.out.println("  | No |        Jabatan       |");
            System.out.println("--------------------------------");
            System.out.println("  | 1  | Kepala Perpustakaan  |");
            System.out.println("  | 2  | Waka Perpustakaan    |");
            System.out.println("  | 3  | Pustakawan           |");
            System.out.println("  | 4  | Staff Administrasi   |");
            System.out.println("--------------------------------");
            System.out.print("Masukkan Jabatan : ");
            int userJabatan = Integer.parseInt(scInput.nextLine());
            
                if (userJabatan == 1) {
                    Jabatan += "Kepala Perpustakaan";
                    System.out.println("Jabatan : Kepala Perpustakaan");
                } else if (userJabatan == 2) {
                    Jabatan += "Waka Perpustakaan";
                    System.out.println("Jabatan : Waka Perpustakaan");   
                } else if (userJabatan == 3) {
                    Jabatan += "Pustakawan";
                    System.out.println("Jabatan : Pustakawan");          
                } else if (userJabatan == 4) {
                    Jabatan += "Staff Administrasi";
                    System.out.println("Jabatan : Staff Administrasi");
                } else {
                    System.out.println("Maaf, Pilihan tidak tersedia");
                }    
            
            long userPhone;
            System.out.print("Masukkan No. Telepon (+62)");
            userPhone = Long.parseLong(scInput.nextLine());

            System.out.print("Masukkan Alamat : ");
            String userAlamat = scInput.nextLine();
            
            int terlambat,denda,buku;
            int bayar,total;
            Scanner baca = new Scanner(System.in);
            System.out.println("------------------------------");
            System.out.println("|       Transaksi Denda      |");
            System.out.println("------------------------------");
            System.out.print("Jumlah Buku Yang Di Pinjam : ");
            buku = Integer.parseInt(baca.nextLine());

            System.out.print("Jumlah Hari Keterlambatan  : ");
            terlambat = Integer.parseInt(baca.nextLine());
            
                if (terlambat >= 10) {
                    bayar = buku * 5000;
                    System.out.println("Denda Yang Dibayar : " + bayar);
                } else if (terlambat > 6 && terlambat <= 9) {
                    bayar = buku * 1500;
                    System.out.println("Denda Yang Dibayar : " + bayar);
                } else if (terlambat > 3 && terlambat <= 6){
                    bayar = buku * 1000;
                    System.out.println("Denda Yang Dibayar : " + bayar);
                } else if (terlambat > 1 && terlambat <= 3){
                    bayar = buku * 500;
                    System.out.println("Denda Yang Dibayar : " + bayar);
                } else {
                    bayar = buku * 0;
                    System.out.println("Denda Yang Dibayar : " + bayar);
                }

            // Farden Ramzy Muharram
            // Instansiasi Peminjaman
            String namaPeminjam, kelasPeminjam, prodiPeminjam,hariPeminjam, lanjut ;
            long npmPeminjam, notlpPeminjam ;
            double waktuPeminjam ;
            
            System.out.println("\n");
            System.out.println("Dimohon Untuk Mengisi Data Diri Anda : ");
            System.out.print("Silahkan Masukkan Nama Anda   : ");
            namaPeminjam = scInput.nextLine();

            System.out.print("Silahkan Masukkan NPM Anda    : ");
            npmPeminjam = Long.parseLong(scInput.nextLine());

            System.out.print("Silahkan Masukkan Kelas Anda  : ");
            kelasPeminjam = scInput.nextLine();

            System.out.print("Silahkan Masukkan No.Tlp Anda : ");
            notlpPeminjam = Long.parseLong(scInput.nextLine());

            System.out.print("Silahkan Masukkan Program Studi Anda : ");
            prodiPeminjam = scInput.nextLine();

            System.out.print("Silahkan Masukkan Hari/Tanggal Peminjaman : ");
            hariPeminjam = scInput.nextLine();

            System.out.print("Silahkan Masukkan Jam Peminjaman : ");
            waktuPeminjam = Double.parseDouble(scInput.nextLine());

            System.out.print("\nYakin Sudah Mengisi Data Diri Anda Dengan Benar (y/N) : ");
            lanjut = scInput.nextLine();
            
                while (!lanjut.equalsIgnoreCase("y")) {
                    System.out.println("\n");
                    System.out.println("Silahkan Mengisi Ulang Data Diri Anda : ");
                    System.out.print("Silahkan Masukkan Nama Anda   : ");
                    namaPeminjam = scInput.nextLine();
                    System.out.print("Silahkan Masukkan NPM Anda    : ");
                    npmPeminjam = Long.parseLong(scInput.nextLine());
                    System.out.print("Silahkan Masukkan Kelas Anda  : ");
                    kelasPeminjam = scInput.nextLine();
                    System.out.print("Silahkan Masukkan No.TLP Anda : ");
                    notlpPeminjam = Long.parseLong(scInput.nextLine());
                    System.out.print("Silahkan Masukkan Program Studi Anda : ");
                    prodiPeminjam = scInput.nextLine();
                    System.out.print("Silahkan Masukkan Hari dan Tanggal : ");
                    hariPeminjam = scInput.nextLine();
                    System.out.print("Silahkan Masukkan Jam Peminjaman : ");
                    waktuPeminjam = Double.parseDouble(scInput.nextLine());
                }
            JOptionPane.showInputDialog(null, "Struk Telah Berhasil Di Generate", "Struk Akhir");
        }
    }
}