import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

class App {

    public static void main(String[] args) throws IOException {
        // Class Input
        BufferedReader brInput = new BufferedReader(new InputStreamReader(System.in));

        // Kumpulan Variable
            // Rionggo Rahardi
            String userLoginUsername = "", userLoginPassword, userNameRegister = "";
            int userMenuInput, nextMenuInput, tryAgain;

            // Amelia Azra Pakaya
            String[] judulBuku = {""}, namaPengarang = {""}, namaPenerbit = {""};
            long[] tahunTerbit = {0L}, noIsbn = {0L}, jumlahHal = {0L};
            int libraryBookInput, i;


            // Farden Ramzy Muharram
            String namaPeminjam = "", kelasPeminjam = "", prodiPeminjam = "",hariPeminjam = "", lanjut = "";
            long npmPeminjam = 0L, notlpPeminjam = 0L;
            double waktuPeminjam = 0.0;

            // Siti Mawaddah
            String namaPetugas, nipPetugas, jeniskelaminPetugas, alamatPetugas, jabatanPetugas;
            long notlpPetugas;


            // Egi Saputra
            String namaPeminjamPengembalian , kelasPeminjamPengembalian, prodiPeminjamPengembalian;
            long npmPeminjamPengembalian, notlpPeminjamPengembalian, noIsbnPengembalian;


        do {
            // Rionggo Rahardi
            // Menu
            System.out.println();
            System.out.println("Selamat Datang di Aplikasi Sistem Informasi Perpustakaan");
            System.out.println( "+---------------+\n" +
                                "| 1. Login      |\n" +
                                "| 2. Registrasi |\n" +
                                "| 3. Exit       |\n" +
                                "+---------------+\n");

            // Menu Input
            System.out.print("Masukkan Pilihan Anda : ");
            userMenuInput = Integer.valueOf(brInput.readLine());

            if (!(userMenuInput == 1 || userMenuInput == 2 || userMenuInput == 3)) {
                System.out.println("Pilihan Anda Tidak Valid!, Silahkan Coba Lagi [1/2/3]");
            }

            if (userMenuInput == 3) {
                System.out.println("Anda Memilih Keluar dari Aplikasi");
                System.out.print("Tekan Enter Untuk Keluar <|");
                brInput.readLine();
                System.exit(0);
            }

        } while (!(userMenuInput == 1 || userMenuInput == 2 || userMenuInput == 3));

        // Login
        if (userMenuInput == 1) {

            do {
                System.out.println("Login..");
                System.out.println();
                userLoginUsername = JOptionPane.showInputDialog(null, "Username : ", "Masukkan Username Anda", JOptionPane.QUESTION_MESSAGE);
                userLoginPassword = JOptionPane.showInputDialog(null, "Password : ", "Masukkan Password Anda", JOptionPane.QUESTION_MESSAGE);

                if (!(userLoginUsername.equals("admin") && userLoginPassword.equals("lmao"))) {
                    JOptionPane.showMessageDialog(null,
                            "Username atau Password Anda Salah, Silahkan Coba Lagi\nJika Lupa Password Harap Lapor Petugas Yang Sedang Bertugas",
                            "Login Failed", JOptionPane.OK_OPTION);
                }

            } while (!(userLoginUsername.equals("admin") && userLoginPassword.equals("lmao")));

            // Greetings Message
            JOptionPane.showMessageDialog(null, "Selamat Datang " + userLoginUsername);
            JOptionPane.showMessageDialog(null, "Anda Berhasil Login Pada, " + new Date() +
                    "\nSilahkan Ikuti Instruksi Selanjutnya.\n" +
                    "\nJika Terdapat Error Silahkan Kirimkan Email Ke rioclasher4@proton.me");

            // Register
        } else if (userMenuInput == 2) {
            System.out.println("Anda Memilih Registrasi");
            System.out.println();
            userNameRegister = JOptionPane.showInputDialog(null, "Username : ", "Buat Username", JOptionPane.QUESTION_MESSAGE);
            String userFullNameRegister = JOptionPane.showInputDialog(null, "Nama Lengkap : ", "Input Nama Lengkap", JOptionPane.QUESTION_MESSAGE);
            String userPasswordRegister = JOptionPane.showInputDialog(null, "Password : ", "Buat Password", JOptionPane.QUESTION_MESSAGE);
            String pwdConfirm = JOptionPane.showInputDialog(null, "Konfirmasi Password : ", "Konfirmasi Password yg telah diinput sebelumnya", JOptionPane.QUESTION_MESSAGE);

            // Cek Password
            while (!userPasswordRegister.equals(pwdConfirm)) {
                JOptionPane.showMessageDialog(null, "Password Tidak Sama \nSilahkan Coba Lagi!");
                userPasswordRegister = JOptionPane.showInputDialog(null, "Masukkan Password : ", "Buat Password", JOptionPane.QUESTION_MESSAGE);
                pwdConfirm = JOptionPane.showInputDialog(null, "Konfirmasi Password : ", "Konfirmasi Password yg telah diinput sebelumnya", JOptionPane.QUESTION_MESSAGE);
            }

            long userNpmRegister = Long.valueOf(JOptionPane.showInputDialog("Masukkan NPM : "));
            String userEmailRegister = JOptionPane.showInputDialog("Masukkan Email : ");

            // Cek Register
            JOptionPane.showMessageDialog(null, "Selamat Datang Pengguna Baru @" + userNameRegister +
                    "\nNama Lengkap : " + userFullNameRegister +
                    "\nNPM : " + userNpmRegister +
                    "\nEmail : " + userEmailRegister);

            int emailNotifier = JOptionPane.showConfirmDialog(null,
                    "Apakah Anda Ingin Dapat Peberitahuan Melalui Email? ");

            if (emailNotifier == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Pemberitahuan Melalui Email Telah Diaktifkan!");
            }

            System.out.println("Anda Telah Selesai Melakukan Registrasi..");
            System.out.println("Selamat Datang di Perpustakaan dan Selamat Menggunakan Program Kami");
        }

        // Lanjutakan / Pengembalian Buku
        do {
            do {
                System.out.println("+==============================+");
                System.out.println("| 1. Lanjutkan Peminjaman      |");
                System.out.println("| 2. Pengembalian              |");
                System.out.println("| 3. Keluar                    |");
                System.out.println("+==============================+");

                System.out.println();
                System.out.print("Masukkan Pilihan Anda : ");
                nextMenuInput = Integer.valueOf(brInput.readLine());
                System.out.println();

                if (!(nextMenuInput == 1 || nextMenuInput == 2) || nextMenuInput == 3) {
                    System.out.println("Pilihan Anda Tidak Valid!, Silahkan Coba Lagi [1-3]");
                }

                if (nextMenuInput == 1) {
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

                    do {
                        System.out.println("Anda Memilih Lanjutkan Peminjaman");
                        System.out.println();
                        //Amelia Azra Pakaya
                        //Data Buku
                        System.out.println("Silahkan Isi Data Buku\nPilihan Jenis Buku...");
                        System.out.println("+==============================+");
                        System.out.println("| 1. Buku Kamus                |");
                        System.out.println("| 2. Buku Ilmu Pengetahuan     |");
                        System.out.println("| 3. Buku Ensiklopedia         |");
                        System.out.println("+==============================+");

                        System.out.println();
                        System.out.print("Masukkan Pilihan Anda : ");
                        libraryBookInput = Integer.valueOf(brInput.readLine());
                        System.out.println();
                        
                        if (!(libraryBookInput == 1 || libraryBookInput == 2 || libraryBookInput == 3)) {
                            System.out.println("Pilihan Anda Tidak Valid!, Silahkan Coba Lagi [1/2/3]");
                        }
                        
                        if (libraryBookInput == 1) {
                            System.out.println("Anda Memilih Buku Kamus\nMemuat Data Buku..");
                            System.out.println("+===================================================================================================+\n" +
                                    "|    No.ISBN    |       Judul Buku       |   Pengarang   |   Penerbit   | Tahun Terbit | Jumlah Hal |\n" +  
                                    "=====================================================================================================\n" +
                                    "| 9789792204353 | Kamus Bahasa Indonesia |  Dendy Sygono |   Gramedia   |     2010     |     646    |\n" +
                                    "| 9786026673138 | Kamus Bahasa Korea     |  Tri Istiyani | Pusat kajian |     2017     |     307    |\n" +
                                    "| 9786020379470 | Kamus Kanji Jepang     |    Maulyanti  |   Gramedia   |     2013     |     568    |\n" +
                                    "+===================================================================================================+");

                        } else if (libraryBookInput == 2) {
                            System.out.println("Anda Memilih Buku Pengetahuan\nMemuat Data Buku..");
                            System.out.println("+=================================================================================================+\n" +
                                    "|    No.ISBN    |     Judul Buku      |    Pengarang   |   Penerbit   | Tahun Terbit | Jumlah Hal |\n" +  
                                    "===================================================================================================\n" +
                                    "| 9786024538361 |  Aplikasi Komputer  | Yenny Iskandar |  Deepublish  |     2018     |     262    |\n" +
                                    "| 9786022803690 | Teknologi Informasi |  Edy Irwansyah |  Deepublish  |     2014     |     339    |\n" +
                                    "| 9786026673343 |   Pemrograman Web   | Didik Setiawan |   Gramedia   |     2017     |     217    |\n" +
                                    "+==================================================================================================+");
                                    
                        } else if (libraryBookInput == 3) {
                            System.out.println("Anda Memilih Buku Kamus dan Buku \nMemuat Data Buku..");
                            System.out.println("+==================================================================================================================+\n" +
                                    "|    No.ISBN    |           Judul Buku           |   Pengarang   |      Penerbit     | Tahun Terbit |  Jumlah Hal  |\n" +  
                                    "====================================================================================================================\n" +
                                    "| 9786027153523 |       Ensiklopedia Sains       | Sri Winarsih  |      Gramedia     |     2020     |      137     |\n" +
                                    "| 9796853086    |   Ensiklopedia Sastra Modern   | Dendy Sugono  |  Remaja Rosdakara |     2003     |      371     |\n" +
                                    "| 9786230101533 | Ensikoledia Teknologi Komputer | Purindraswari |        Andi       |     2019     |      272     |\n" +
                                    "+===================================================================================================================+");
                            
                        } 

                        System.out.println();
                        System.out.print("Berapa Banyak Buku Yang Ingin Anda Pinjam? ");
                        int libraryBookQuantity = Integer.valueOf(brInput.readLine());
                        System.out.println();
                        noIsbn = new long[libraryBookQuantity];
                        judulBuku = new String[libraryBookQuantity];
                        namaPengarang = new String[libraryBookQuantity];
                        namaPenerbit = new String[libraryBookQuantity];
                        tahunTerbit = new long[libraryBookQuantity];
                        jumlahHal = new long[libraryBookQuantity];
                        
                        for (i = 0; i < libraryBookQuantity; i++) {

                            if (i <= libraryBookQuantity) {
                                System.out.println("+========================================+");
                                System.out.println("Data Buku Ke-" + (i + 1) + " : ");
                            } else if (i == libraryBookQuantity - 1) {
                                System.out.println("+========================================+");
                                System.out.println("Data Buku Ke-" + (i + 1) + " : ");
                            }

                            System.out.print("Masukkan No.ISBN : ");
                            noIsbn[i] = Long.parseLong(brInput.readLine());
                            
                            System.out.print("Masukkan Judul Buku : ");
                            judulBuku[i] = brInput.readLine();

                            System.out.print("Masukkan Nama Pengarang : ");
                            namaPengarang[i] = brInput.readLine();
                            
                            System.out.print("Masukkan Nama Penerbit : ");
                            namaPenerbit[i] = brInput.readLine();

                            System.out.print("Masukkan Tahun Terbit : ");
                            tahunTerbit[i] = Long.parseLong(brInput.readLine());
                            
                            System.out.print("Masukkan Jumlah Hal : ");
                            jumlahHal[i] = Long.parseLong(brInput.readLine());
                            
                        }

                        // for (i = 0; i < libraryBookQuantity; i++) {
                        //     System.out.println();
                        //     System.out.println("Print Data Buku Ke-" + (i + 1));
                        //     System.out.println("+======================================+");
                        //     System.out.println("  No.ISBN        : " + noIsbn[i]);
                        //     System.out.println("  Judul Buku     : " + judulBuku[i]);
                        //     System.out.println("  Nama Pengarang : " + namaPengarang[i]);
                        //     System.out.println("  Nama Penerbit  : " + namaPenerbit[i]);
                        //     System.out.println("  Tahun Terbit   : " + tahunTerbit[i]);
                        //     System.out.println("  Jumlah Hal     : " + jumlahHal[i]);
                        //     System.out.println("+======================================+");
                        //     System.out.println();
                        // }
                        
                        System.out.println("+======================================+");
                        System.out.println("Buku Telah Berhasil Diinput Ke Sistem\nSilahkan Ikuti Instruksi Selanjutnya");
                        System.out.println("+======================================+");

                        // Farden Ramzy Muharram
                        
                        do {
                            System.out.println("Dimohon Untuk Mengisi Data Diri Anda");
                            System.out.print("Silahkan Masukkan Nama Anda   : ");
                            namaPeminjam = brInput.readLine();
                            System.out.print("Silahkan Masukkan NPM Anda    : ");
                            npmPeminjam = Long.valueOf(brInput.readLine());
                            System.out.print("Silahkan Masukkan Kelas Anda  : ");
                            kelasPeminjam = brInput.readLine();
                            System.out.print("Silahkan Masukkan No.Tlp Anda : ");
                            notlpPeminjam = Long.valueOf(brInput.readLine());
                            System.out.print("Silahkan Masukkan Program Studi Anda : ");
                            prodiPeminjam = brInput.readLine();
                            System.out.print("Silahkan Masukkan Hari/Tanggal Peminjaman : ");
                            hariPeminjam = brInput.readLine();
                            System.out.print("Silahkan Masukkan Jam Peminjaman : ");
                            waktuPeminjam = Double.parseDouble(brInput.readLine());
                            System.out.print("\nYakin Sudah Mengisi Data Diri Anda Dengan Benar (y/N): ");
                            lanjut = brInput.readLine();

                            if (lanjut.equalsIgnoreCase("y")) {
                                System.out.println("\nTerima Kasih Telah Mengisi Data Diri Anda");
                            } else {
                                System.out.println("\nSilahkan Masukkan Data Diri Anda Kembali Dengan Benar!");
                            }

                        } while (lanjut.equalsIgnoreCase("n"));

                        // Siti Mawaddah

                        System.out.println();
                        System.out.println("           Jadwal Petugas Perpustakaan          ");
                        System.out.println("+==============================================+");
                        System.out.println("|      Jam      |   Hari  |        Nama       |");
                        System.out.println("+==============================================+");
                        System.out.println("| 08.00 - 12.00 | Senin   | Zanna Kirania     |");
                        System.out.println("| 13.00 - 17.00 | Senin   | Kaila Sherly      |");
                        System.out.println("+==============================================+");
                        System.out.println("| 08.00 - 12.00 | Selasa  | Azka Aqilla Wajdi |");
                        System.out.println("| 13.00 - 17.00 | Selasa  | Daffa Ramdan      |");
                        System.out.println("+==============================================+");
                        System.out.println("| 08.00 - 12.00 | Rabu    | Kaila Sherly      |");
                        System.out.println("| 13.00 - 17.00 | Rabu    | Zanna Kirania     |");
                        System.out.println("+==============================================+");
                        System.out.println("| 08.00 - 12.00 | Kamis   | Daffa Ramdan      |");
                        System.out.println("| 13.00 - 17.00 | Kamis   | Azka Aqilla Wajdi |");
                        System.out.println("+==============================================+");
                        System.out.println("| 08.00 - 11.30 | Jumat   | Hanif Maqil       |");
                        System.out.println("| 13.00 - 16.00 | Jumat   | Aqmar Nadhif      |");
                        System.out.println("+==============================================+");
                        System.out.println();
                        System.out.println("Silahkan Isi Data Petugas...");
                        System.out.println("+==================================================================================================================+");
                        System.out.println("|         NIP        |        Nama       | Jenis Kelamin |       Jabatan       | No. Telepon  |       Alamat      |"); 
                        System.out.println("====================================================================================================================");
                        System.out.println("| 198609262015051001 | Aqmar Nadhif      | Laki-laki     | Kepala Perpustakaan | 081281229933 | Jl. Merpati 21    |");
                        System.out.println("| 198305162019111002 | Hanif Maqil       | Laki-laki     | Waka Perpustakaan   | 087811905423 | Jl. Raflesia 19   |");
                        System.out.println("| 199011092014021003 | Daffa Ramdan      | Laki-laki     | Pustakawan          | 085268320186 | Jl. Kayu Manis 03 |");
                        System.out.println("| 198707102016082004 | Zanna Kirania     | Perempuan     | Pustakawan          | 081375621399 | Jl. Ahmad Yani 54 |");
                        System.out.println("| 198508242017042005 | Azka Aqilla Wajdi | Perempuan     | Staff Administrasi  | 083801157321 | Jl. Nasional 5    |");
                        System.out.println("| 198912112018052006 | Kaila Sherly      | Perempuan     | Staff Administrasi  | 089666315415 | Jl. Kemuning 12   |");
                        System.out.println("+===================================================================================================================+");
                        System.out.println();
                        System.out.println("+===========================+");
                        System.out.print("Masukkan NIP Petugas : ");
                        nipPetugas = brInput.readLine();
                        System.out.print("Masukkan Nama Petugas : ");
                        namaPetugas = brInput.readLine();
                        System.out.print("Masukkan Jenis Kelamin Petugas : ");
                        jeniskelaminPetugas = brInput.readLine();
                        System.out.print("Masukkan Jabatan Petugas : ");
                        jabatanPetugas = brInput.readLine();
                        System.out.print("Masukkan No. Telepon Petugas : ");
                        notlpPetugas = Long.valueOf(brInput.readLine());
                        System.out.print("Masukkan Alamat Petugas : ");
                        alamatPetugas = brInput.readLine();
                        System.out.println("+===========================+");
                        System.out.println();
                        

                        // Comunicate With Peminjaman
                        

                    } while (!(libraryBookInput == 1 || libraryBookInput == 2 || libraryBookInput == 3));

                    // Pengembalian
                } else if (nextMenuInput == 2) {
                    // Egi Saputra
                    System.out.println();
                    System.out.println("Dimohon Untuk Mengisi Data Diri Anda : ");
                    System.out.println();
                    System.out.print("Silahkan Masukkan Nama Anda   : ");
                    namaPeminjamPengembalian = brInput.readLine();
                    System.out.print("Silahkan Masukkan NPM Anda    : ");
                    npmPeminjamPengembalian = Long.parseLong(brInput.readLine());
                    System.out.print("Silahkan Masukkan Kelas Anda  : ");
                    kelasPeminjamPengembalian = brInput.readLine();
                    System.out.print("Silahkan Masukkan No.Tlp Anda : ");
                    notlpPeminjamPengembalian = Long.parseLong(brInput.readLine());
                    System.out.print("Silahkan Masukkan Program Studi Anda : ");
                    prodiPeminjamPengembalian = brInput.readLine(); 
                    System.out.println("Masukkan Tanggal Peminjaman Anda : ");
                    int tanggalPeminjaman = Integer.valueOf(brInput.readLine());
                    System.out.println("Masukkan Tanggal Peminjaman Anda : ");
                    System.out.print("Masukkan No.ISBN Buku Yang Dipinjam : "); 
                    noIsbnPengembalian = Long.valueOf(brInput.readLine());

                    // To be continued soon

                    System.out.println("\n");
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                DATA PENGEMBALIAN              |");
                    System.out.println("-----------------------------------------------");
                    System.out.println("TANGGAL PEMINJAMAN   : " + tanggalPeminjaman);
                    // System.out.println("JUMLAH DENDA         : " +jumlahDENDA);
                    System.out.println("No Isbn              : " + noIsbnPengembalian);
                    System.out.println("KELAS                : " + kelasPeminjamPengembalian);
                    System.out.println("NO.TLP               : " + notlpPeminjamPengembalian);
                    System.out.println("PROGRAM STUDI        : " + prodiPeminjamPengembalian);
                    // System.out.println("-----------------------------------------------");

                } else if (nextMenuInput == 3) {
                    System.out.println("+======================================+");
                    System.out.println("Anda Telah Keluar Dari Program");
                    System.out.println("+======================================+");
                    System.out.print("Tekan Enter Untuk Keluar <|");
                    brInput.readLine();
                    System.exit(0);
                }

            } while (!(nextMenuInput == 1 || nextMenuInput == 2) || nextMenuInput == 3);

            // Print All Data

            tryAgain = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Mengulangi Program Ini Lagi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if (tryAgain == JOptionPane.NO_OPTION) {

                System.exit(0);

            } else if (tryAgain == JOptionPane.YES_OPTION) {

                if (userMenuInput == 1) {
                    System.out.println("\n\n");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Halo " + userLoginUsername + ", Selamat Datang Kembali!");
                    System.out.println("Anda Sudah Login.");
                    System.out.println("----------------------------------------------------");
                    System.out.println("\n");
                } else if (userMenuInput == 2) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("Halo " + userNameRegister + ", Selamat Datang Kembali!");
                    System.out.println("Anda Sudah Login.");
                    System.out.println("----------------------------------------------------");
                    System.out.println("\n");
                }
                    
            }

        } while (tryAgain == JOptionPane.YES_OPTION);

        brInput.close();
    }
}

/*
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠤⠤⡤⠤⣀⣀⡀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⢔⠲⠈⠉⠀⠀⠀⠀⡸⠀⠀⠈⣿⣿⣦⡀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⠂⡡⠄⠀⠀⠀⠀⠀⠈⠀⠀⢇⠀⠀⠀⣿⣿⣿⣷⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⡰⢁⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠀⠀⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠎⢀⣡⠴⠒⠈⠉⠉⢉⣩⣿⣶⣦⣄⡀⠀⡆⠀⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⠀⠀⣼⣴⠉⠀⢀⠖⠉⠉⠙⠿⣿⣿⣿⣿⣿⣿⣷⣼⡀⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⠀⠀⢻⣿⣄⣴⠏⠀⠀⠀⠀⠀⠙⣿⣿⣿⡿⠿⠛⠁⡇⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⡹⠛⠁⠀⠀⠀⠀⠀⠀⠀⠈⠉⠀⠀⠀⠀⠀⡇⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⠀⢀⡔⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠀⠀⠀⡠⠊⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⣿⣿⣿⣿⠀
                            ⠀⠀⢀⠔⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡜⠀⠀⣿⣿⣿⣿⠀
                            ⠀⠠⡃⢠⡤⠤⣀⣀⣀⡀⠀⠀⠀⢣⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠇⠀⠀⣿⣿⣿⣿⠀
                            ⠀⠀⠑⢼⣧⣀⣴⣿⣿⣿⣿⣷⣦⣄⠇⠀⠀⠀⠀⠀⠀⠀⠀⢰⠀⠀⠀⣿⣿⣿⣿⡇
                            ⠀⠀⠀⣼⢠⠀⠈⠍⠉⠛⠛⠛⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⢀⡇⢠⠀⠀⣿⣿⣿⣿⢇
                            ⠀⠀⠀⡏⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣶⣤⣷⣶⣿⣿⣿⠏⠀
                            ⠀⠀⢸⠇⢀⠀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⡟⠉⠃⠀⠀
                            ⠀⠀⢸⠀⡇⠮⣀⣀⣤⣤⣭⣽⣿⣄⠀⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀
                            ⠀⠀⡇⠰⠐⠲⠾⠿⠿⠿⠿⠟⠛⠛⠋⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀
                            ⠀⢸⢁⠇⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀
                            ⠀⠏⠸⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀
                            ⢸⠀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀
                            ⠀⠑⠢⠤⠀⠀⠀⠀⠀⠒⣄⣀⠠⠶⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⡜⢠⠃⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⠿⠟⠋⠀⠀⠀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠰⠁⠈⠀⠀⠀⠀⣤⣶⣿⡿⠿⠿⠛⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                            ⠀⠀⠀⠀⠀⠀⠀⠀⠉⠐⠒⠒⠂⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
*/