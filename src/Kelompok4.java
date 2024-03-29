import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

class Kelompok4 {

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
            int libraryBookInput, i, bookDuration = 0, libraryBookQuantity = 0;

            // Farden Ramzy Muharram
            String namaPeminjam = "", kelasPeminjam = "", prodiPeminjam = "",hariPeminjam = "", lanjut = "";
            long npmPeminjam = 0L, notlpPeminjam = 0L;
            double waktuPeminjam = 0.0D;

            // Siti Mawaddah
            String namaPetugas = "", nipPetugas = "", jenisKelaminPetugas = "", alamatPetugas = "", jabatanPetugas = "";
            long notlpPetugas = 0L, jumlahDenda = 0L;

            // Egi Saputra
            String namaPeminjamPengembalian , kelasPeminjamPengembalian, prodiPeminjamPengembalian, judulBukuPengembalian, returnToMainMenu = "";
            long npmPeminjamPengembalian, notlpPeminjamPengembalian, lamaPeminjaman;
        
        do {
            // Menu
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

        // Login (Rionggo Rahardi)
        if (userMenuInput == 1) {

            do {
                System.out.println("Login..");
                System.out.println();
                userLoginUsername = JOptionPane.showInputDialog(null, "Username : ", "Masukkan Username Anda", JOptionPane.QUESTION_MESSAGE);
                userLoginPassword = JOptionPane.showInputDialog(null, "Password : ", "Masukkan Password Anda", JOptionPane.QUESTION_MESSAGE);

                if (!(userLoginUsername.equals("admin") && userLoginPassword.equals("1234"))) {
                    int loginError = JOptionPane.showConfirmDialog(null,
                            "Username atau Password Anda Salah, Silahkan Coba Lagi\nJika Lupa Password Harap Lapor Petugas Yang Sedang Bertugas\n\nTekan No Untuk Keluar..",
                            "Login Failed", JOptionPane.OK_OPTION);

                            if (loginError == JOptionPane.NO_OPTION) {
                                System.out.println("Anda Memilih Membatalkan");
                                System.out.print("Tekan Enter Untuk Keluar <|");
                                brInput.readLine();
                                System.exit(0);
                            }
                }

            } while (!(userLoginUsername.equals("admin") && userLoginPassword.equals("1234")));

            // Greetings Message
            JOptionPane.showMessageDialog(null, "Selamat Datang " + userLoginUsername, "Login Success", JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Anda Berhasil Login Pada, " + new Date() +
                    "\nSilahkan Ikuti Instruksi Selanjutnya.\n" +
                    "\nJika Terdapat Error Silahkan Kirimkan Email Ke rioclasher4@proton.me", "Login Success", JOptionPane.INFORMATION_MESSAGE);

        } else if (userMenuInput == 2) {
            // Register (Rionggo Rahardi)
            System.out.println("Anda Memilih Registrasi");
            System.out.println();
            userNameRegister = JOptionPane.showInputDialog(null, "Username : ", "Buat Username", JOptionPane.QUESTION_MESSAGE);
            String userFullNameRegister = JOptionPane.showInputDialog(null, "Nama Lengkap : ", "Input Nama Lengkap", JOptionPane.QUESTION_MESSAGE);
            long userNpmRegister = Long.valueOf(JOptionPane.showInputDialog(null, "Masukkan NPM : ", "Input NPM", JOptionPane.QUESTION_MESSAGE));
            String userEmailRegister = JOptionPane.showInputDialog(null,"Masukkan Email : ", "Input Email", JOptionPane.QUESTION_MESSAGE);
            String userPasswordRegister = JOptionPane.showInputDialog(null, "Password : ", "Buat Password", JOptionPane.QUESTION_MESSAGE);
            String pwdConfirm = JOptionPane.showInputDialog(null, "Konfirmasi Password : ", "Konfirmasi Password yg telah diinput sebelumnya", JOptionPane.QUESTION_MESSAGE);

            // Cek Password
            while (!(userPasswordRegister.equals(pwdConfirm))) {
                JOptionPane.showMessageDialog(null, "Password Tidak Sama \nSilahkan Coba Lagi!", "Konfirmasi Password", JOptionPane.OK_OPTION);
                userPasswordRegister = JOptionPane.showInputDialog(null, "Masukkan Password : ", "Buat Password", JOptionPane.QUESTION_MESSAGE);
                pwdConfirm = JOptionPane.showInputDialog(null, "Konfirmasi Password : ", "Konfirmasi Password yg telah diinput sebelumnya", JOptionPane.QUESTION_MESSAGE);
            }

            // Cek Register
            JOptionPane.showMessageDialog(null, "Selamat Datang Pengguna Baru @" + userNameRegister +
                    "\nNama Lengkap : " + userFullNameRegister +
                    "\nNPM : " + userNpmRegister +
                    "\nEmail : " + userEmailRegister, "Registrasi Berhasil", JOptionPane.INFORMATION_MESSAGE);

            int emailNotifier = JOptionPane.showConfirmDialog(null,
                    "Apakah Anda Ingin Dapat Peberitahuan Melalui Email? ", "Pemberitahuan Email", JOptionPane.YES_NO_OPTION);

            if (emailNotifier == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Pemberitahuan Melalui Email Telah Diaktifkan..", "Pemberitahuan Email", JOptionPane.INFORMATION_MESSAGE);
            } else if (emailNotifier == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Pemberitahuan Melalui Email Tidak Diaktifkan\n\nUntuk Mengaktifkan Harap Bilang Petugas Yang Sedang Berjaga", "Pemberitahuan Email", JOptionPane.INFORMATION_MESSAGE);
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
                            "Apakah Anda Ingin Melanjutkan?\nTekan No Untuk Keluar..", "Instruksi Peminjaman", JOptionPane.YES_NO_OPTION);

                    if (confirm != JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null, "Terima Kasih Telah Menggunakan Perpustakaan Kami");
                        System.out.println("Anda Menghentikan Program..");
                        System.exit(0);
                    }

                        System.out.println("Anda Memilih Lanjutkan Peminjaman");                        
                    do {
                        // Farden Ramzy Muharram
                        System.out.println();
                        System.out.println("Form Data Diri..");
                        System.out.println("+========================================================+");
                        System.out.println("           Dimohon Untuk Mengisi Data Diri Anda");
                        System.out.println("+========================================================+");
                        System.out.println();
                        System.out.print(" Silahkan Masukkan Nama Lengkap Anda   : ");
                        namaPeminjam = brInput.readLine();
                        System.out.print(" Silahkan Masukkan NPM Anda    : ");
                        npmPeminjam = Long.valueOf(brInput.readLine());
                        System.out.print(" Silahkan Masukkan Kelas Anda  : ");
                        kelasPeminjam = brInput.readLine();
                        System.out.print(" Silahkan Masukkan No.Tlp Anda : ");
                        notlpPeminjam = Long.valueOf(brInput.readLine());
                        System.out.print(" Silahkan Masukkan Program Studi Anda : ");
                        prodiPeminjam = brInput.readLine();
                        System.out.print(" Silahkan Masukkan Hari Peminjaman (Contoh : Senin) : ");
                        hariPeminjam = brInput.readLine();
                        System.out.print(" Silahkan Masukkan Jam Peminjaman (Contoh : 23.46) : ");
                        waktuPeminjam = Double.parseDouble(brInput.readLine());
                        System.out.print(" \nYakin Sudah Mengisi Data Diri Anda Dengan Benar (y/N): ");
                        lanjut = brInput.readLine();
                        System.out.println();
                        System.out.println("+========================================================+");

                        if (lanjut.equalsIgnoreCase("y")) {
                            System.out.println("        Terima Kasih Telah Mengisi Data Diri Anda");
                            System.out.println("+========================================================+");
                        } else {
                            System.out.println(" \nSilahkan Masukkan Data Diri Anda Kembali Dengan Benar!");
                        }

                    } while (lanjut.equalsIgnoreCase("n"));
                
                do {
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

                    } while (!(libraryBookInput == 1 || libraryBookInput == 2 || libraryBookInput == 3));
                    
                    if (libraryBookInput == 1) {
                        System.out.println("Anda Memilih Buku Kamus\nMemuat Data Buku..");
                        System.out.println("+===================================================================================================+\n" +
                                "|    No.ISBN    |       Judul Buku       |   Pengarang   |   Penerbit   | Tahun Terbit | Jumlah Hal |\n" +  
                                "=====================================================================================================\n" +
                                "| 9789792204353 | Kamus Bahasa Indonesia |  Dendy Sygono |   Gramedia   |     2010     |     646    |\n" +
                                "| 9786026673138 |   Kamus Bahasa Korea   |  Tri Istiyani | Pusat kajian |     2017     |     307    |\n" +
                                "| 9786020379470 |   Kamus Kanji Jepang   |    Maulyanti  |   Gramedia   |     2013     |     568    |\n" +
                                "+===================================================================================================+");

                    } else if (libraryBookInput == 2) {
                        System.out.println("Anda Memilih Buku Ilmu Pengetahuan\nMemuat Data Buku..");
                        System.out.println("+=================================================================================================+\n" +
                                "|    No.ISBN    |     Judul Buku      |    Pengarang   |   Penerbit   | Tahun Terbit | Jumlah Hal |\n" +  
                                "===================================================================================================\n" +
                                "| 9786024538361 |  Aplikasi Komputer  | Yenny Iskandar |  Deepublish  |     2018     |     262    |\n" +
                                "| 9786022803690 | Teknologi Informasi |  Edy Irwansyah |  Deepublish  |     2014     |     339    |\n" +
                                "| 9786026673343 |   Pemrograman Web   | Didik Setiawan |   Gramedia   |     2017     |     217    |\n" +
                                "+=================================================================================================+");
                                    
                    } else if (libraryBookInput == 3) {
                        System.out.println("Anda Memilih Buku Ensiklopedia\nMemuat Data Buku..");
                        System.out.println("+==================================================================================================================+\n" +
                                "|    No.ISBN    |           Judul Buku           |   Pengarang   |      Penerbit     | Tahun Terbit |  Jumlah Hal  |\n" +  
                                "====================================================================================================================\n" +
                                "| 9786027153523 |       Ensiklopedia Sains       | Sri Winarsih  |      Gramedia     |     2020     |      137     |\n" +
                                "| 9796853086    |   Ensiklopedia Sastra Modern   | Dendy Sugono  |  Remaja Rosdakara |     2003     |      371     |\n" +
                                "| 9786230101533 | Ensikoledia Teknologi Komputer | Purindraswari |        Andi       |     2019     |      272     |\n" +
                                "+==================================================================================================================+");
                            
                    }

                    JOptionPane.showMessageDialog(null, "Ketentuan Peminjaman\n" +
                    "1. Buku Hanya Bisa Dipinjam Maks 7 Hari\n" +
                    "2. Apabila Buku Tidak Dikembalikan dalam 7 hari, maka anda dikenakan denda!\n"
                    , "Ketentuan Peminjaman", JOptionPane.INFORMATION_MESSAGE);

                    System.out.print("\nBerapa Lama Buku Akan Dipinjam? (Contoh : [1-7]) : ");
                    bookDuration = Integer.valueOf(brInput.readLine());
                    System.out.println("Anda Meminjam Buku Selama " + bookDuration + " Hari");
                    System.out.print("Berapa Banyak Buku Yang Ingin Anda Pinjam? ");
                    libraryBookQuantity = Integer.valueOf(brInput.readLine());
                    System.out.println();
                    noIsbn = new long[libraryBookQuantity];
                    judulBuku = new String[libraryBookQuantity];
                    namaPengarang = new String[libraryBookQuantity];
                    namaPenerbit = new String[libraryBookQuantity];
                    tahunTerbit = new long[libraryBookQuantity];
                    jumlahHal = new long[libraryBookQuantity];
                        
                    for (i = 0; i < libraryBookQuantity; i++) {
                    
                        if (i <= libraryBookQuantity) {
                        System.out.println("+==================================================+");
                        System.out.println(" Data Buku Ke-" + (i + 1) + " : ");
                        }
                    
                        System.out.print(" Masukkan No.ISBN        : ");
                        noIsbn[i] = Long.parseLong(brInput.readLine());
                            
                        System.out.print(" Masukkan Judul Buku     : ");
                        judulBuku[i] = brInput.readLine();

                        System.out.print(" Masukkan Nama Pengarang : ");
                        namaPengarang[i] = brInput.readLine();
                            
                        System.out.print(" Masukkan Nama Penerbit  : ");
                        namaPenerbit[i] = brInput.readLine();

                        System.out.print(" Masukkan Tahun Terbit   : ");
                        tahunTerbit[i] = Long.parseLong(brInput.readLine());
                            
                        System.out.print(" Masukkan Jumlah Hal     : ");
                        jumlahHal[i] = Long.parseLong(brInput.readLine());
                            
                    }
                    
                    // Informasi
                    System.out.println("+==================================================+");
                    System.out.println("       Buku Telah Berhasil Diinput Ke Sistem        ");
                    System.out.println("       Silahkan Ikuti Instruksi Selanjutnya         ");
                    System.out.println("+==================================================+");           


                    // Siti Mawaddah
                    System.out.println();
                    System.out.println("+==============================================+");	
                    System.out.println("           Jadwal Petugas Perpustakaan         ");
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
                    System.out.println("+============================+");
                    System.out.print("Masukkan NIP Petugas           : ");
                    nipPetugas = brInput.readLine();
                    System.out.print("Masukkan Nama Petugas          : ");
                    namaPetugas = brInput.readLine();
                    System.out.print("Masukkan Jenis Kelamin Petugas : ");
                    jenisKelaminPetugas = brInput.readLine();
                    System.out.print("Masukkan Jabatan Petugas       : ");
                    jabatanPetugas = brInput.readLine();
                    System.out.print("Masukkan No. Telepon Petugas   : ");
                    notlpPetugas = Long.valueOf(brInput.readLine());
                    System.out.print("Masukkan Alamat Petugas        : ");
                    alamatPetugas = brInput.readLine();
                    System.out.println("+===========================+");
                    System.out.println();
                    
                    // Siti Mawaddah
                    System.out.println("Total Buku yang Dipinjam : " + libraryBookQuantity);
                    System.out.println();
                    System.out.println("Lama Hari Peminjaman : " + bookDuration);

                    if (libraryBookQuantity >= 10) {
                        jumlahDenda = bookDuration * 5000;
                    } else if (libraryBookQuantity > 6 && libraryBookQuantity <= 9) {
                        jumlahDenda = bookDuration * 1500; 
                    } else if (libraryBookQuantity > 3 && libraryBookQuantity <= 6) {
                        jumlahDenda = bookDuration * 1000;
                    } else if (libraryBookQuantity > 1 && libraryBookQuantity <= 3) {
                        jumlahDenda = bookDuration * 500;
                    } else {
                        jumlahDenda = bookDuration * 0;
                    }

                    long infoDenda = jumlahDenda;

                    JOptionPane.showMessageDialog(null, "Apabila Anda Telat Mengembalikan Lebih Dari 7 Hari \n" +
                    "Maka Akan Dikenakan Denda Sebesar Rp." + infoDenda, "Pemberitahuan", JOptionPane.INFORMATION_MESSAGE);
                            

                } else if (nextMenuInput == 2) {
                    // Pengembalian
                    // Egi Saputra
                    System.out.println("+==========================================+");
                    System.out.println("| Selamat Datang Di Form Pengembalian Buku |");
                    System.out.println("+==========================================+");
                    System.out.println();
                    System.out.println("Dimohon Untuk Mengisi Data Diri Anda : ");
                    System.out.println();
                    System.out.print("Silahkan Masukkan Nama Anda          : ");
                    namaPeminjamPengembalian = brInput.readLine();
                    System.out.print("Silahkan Masukkan NPM Anda           : ");
                    npmPeminjamPengembalian = Long.parseLong(brInput.readLine());
                    System.out.print("Silahkan Masukkan Kelas Anda         : ");
                    kelasPeminjamPengembalian = brInput.readLine();
                    System.out.print("Silahkan Masukkan No.Tlp Anda        : ");
                    notlpPeminjamPengembalian = Long.parseLong(brInput.readLine());
                    System.out.print("Silahkan Masukkan Program Studi Anda : ");
                    prodiPeminjamPengembalian = brInput.readLine(); 
                    System.out.print("Silahkan Masukkan Judul Buku yang ingin dikembalikan : ");
                    judulBukuPengembalian = brInput.readLine();
                    System.out.print("Sudah Berapa Lama Anda Meminjam Buku (Contoh 1-7)          : ");
                    lamaPeminjaman = Integer.valueOf(brInput.readLine());

                    // Condition  (Siti Mawaddah)

                    if (lamaPeminjaman > 7) {
                        if (libraryBookQuantity >= 10) {
                            jumlahDenda = bookDuration * 5000;
                        } else if (libraryBookQuantity > 6 && libraryBookQuantity <= 9) {
                            jumlahDenda = bookDuration * 1500; 
                        } else if (libraryBookQuantity > 3 && libraryBookQuantity <= 6) {
                            jumlahDenda = bookDuration * 1000;
                        } else if (libraryBookQuantity > 1 && libraryBookQuantity <= 3) {
                            jumlahDenda = bookDuration * 500;
                        } else {
                            jumlahDenda = bookDuration * 0;
                        }
                    }

                    // Informasi
                    JOptionPane.showMessageDialog(null, "Denda Akan Dikenakan Apabila Melebihi 7 Hari", "Denda", JOptionPane.INFORMATION_MESSAGE);

                    // Output (Egi Saputra)
                    System.out.println("\n");
                    System.out.println("-----------------------------------------------");
                    System.out.println("|                DATA PENGEMBALIAN            |");
                    System.out.println("-----------------------------------------------");
                    System.out.println("| Nama Peminjam   | " + namaPeminjamPengembalian);
                    System.out.println("| NPM Peminjam    | " + npmPeminjamPengembalian);
                    System.out.println("| Kelas Peminjam  | " + kelasPeminjamPengembalian);
                    System.out.println("| No.Tlp Peminjam | " + notlpPeminjamPengembalian);
                    System.out.println("| Program Studi   | " + prodiPeminjamPengembalian);
                    System.out.println("| Lama Peminjaman | " + lamaPeminjaman + " hari");
                    System.out.println("| Judul Buku      | " + judulBukuPengembalian);
                    System.out.println("| Denda           | " + "Rp." + jumlahDenda + " Rupiah");
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    System.out.println("Terimakasih Telah Melakukan Pengembalian Buku, " + namaPeminjamPengembalian + "!");
                    System.out.print("Tekan Enter Untuk Keluar <|");
                    brInput.readLine();
                    System.exit(0);

                } else if (nextMenuInput == 3) {
                    System.out.println("+======================================+");
                    System.out.println("Anda Telah Keluar Dari Program");
                    System.out.println("+======================================+");
                    System.out.print("Tekan Enter Untuk Keluar <|");
                    brInput.readLine();
                    System.exit(0);
                }

            } while (!(nextMenuInput == 1 || nextMenuInput == 2) || nextMenuInput == 3);

            // Print All Data (Tim Kelompok)

            System.out.println("Menggenerate Data Buku...");
            System.out.println();
            System.out.println("+========================================+");
            System.out.println("|             DATA PEMINJAM              |");
            System.out.println("+========================================+");
            System.out.println("| Nama Peminjam   | " + namaPeminjam);
            System.out.println("| NPM Peminjam    | " + npmPeminjam);
            System.out.println("| Kelas Peminjam  | " + kelasPeminjam);
            System.out.println("| No.Tlp Peminjam | " + notlpPeminjam);
            System.out.println("| Program Studi   | " + prodiPeminjam);
            System.out.println("| Hari Peminjaman | " + hariPeminjam );
            System.out.println("| Jam Peminjaman  | " + waktuPeminjam);
            System.out.println("| Lama Peminjaman | " + bookDuration + " hari");
            System.out.println("+========================================+");
            System.out.println("|               DATA BUKU                |");
            System.out.println("+========================================+");

            for (i = 0; i < libraryBookQuantity; i++) {

                if (i <= libraryBookQuantity) {
                    System.out.println("+========================================+");
                    System.out.println("Data Buku Ke-" + (i + 1) + " : ");
                }
                    System.out.println("| Judul Buku      | " + judulBuku[i]);
                    System.out.println("| Pengarang       | " + namaPengarang[i]);
                    System.out.println("| Penerbit        | " + namaPenerbit[i]);
                    System.out.println("| Tahun Terbit    | " + tahunTerbit[i]);
                    System.out.println("| Jumlah Halaman  | " + jumlahHal[i]);
            }

            System.out.println("+========================================+");
            System.out.println("|             DATA PETUGAS               |");
            System.out.println("+========================================+");
            System.out.println("| Nama Petugas   | " + namaPetugas);
            System.out.println("| NIP Petugas    | " + nipPetugas);
            System.out.println("| Jenis Kelamin  | " + jenisKelaminPetugas);
            System.out.println("| Jabatan        | " + jabatanPetugas);
            System.out.println("| No.Tlp Petugas | " + notlpPetugas);
            System.out.println("| Alamat         | " + alamatPetugas);
            System.out.println("+========================================+");
            System.out.println();
            System.out.println("Terima Kasih Telah Menggunakan Program Ini");
            System.out.println("Tekan Enter Untuk Melanjutkan <|");
            brInput.readLine();
            tryAgain = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Mengulangi Program Ini Lagi?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            
            if (tryAgain == JOptionPane.NO_OPTION) {
                System.out.println("Terima Kasih Telah Menggunakan Program Ini..");
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

        } while (tryAgain == JOptionPane.YES_OPTION || returnToMainMenu.equalsIgnoreCase("y"));

        brInput.close();
    }
}