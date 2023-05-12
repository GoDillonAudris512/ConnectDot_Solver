# Makalah_OneLine_13521062

> Source Code untuk menyelesaikan permainan One-Line dengan memanfaatkan algoritma Depth First Search (DFS). Dibuat untuk memenuhi tugas makalah IF2211 Strategi Algoritma 2022/2023

## Daftar Isi
- [Author](#author)
- [Implementasi Program](#implementasi-program)
- [Sistematika File](#sistematika-file)
- [Requirements](#requirements)
- [Cara Menjalankan Program](#cara-menjalankan-program)

## Author
| NIM      | Nama                      |
| -------- | ------------------------- |
| 13521062 | Go Dillon Audris          |

## Implementasi Program
Program yang dibuat merupakan suatu program untuk memecahkan masalah permainan One-Line. One-Line
adalah permainan dimana pemain diminta untuk menarik suatu garis dari kotak mulai sampai ke kotak
selesai dalam satu tarikan dan melewati semua kotak lain yang ada. Dalam implementasinya,
permainan ini diselesaikan dengan memanfaatkan algoritma Depth First Search (DFS). Program dapat
menerima suatu argumen path dari file, membaca isi file, dan memberikan salah satu langkah yang
mungkin untuk menyelesaikan permainan. Isi file berupa suatu matriks angka yang menggambarkan
papan permainan One-Line.

## Sistematika File
```bash
.
├─── bin
│   └─── .gitignore
├─── doc  
├─── src
│   ├─── Container
│   │   ├─── Board.java
│   │   ├─── Coordinate.java
│   │   └─── Node.java
│   ├─── IO
│   │   └─── Parser.java
│   ├─── Solver
│   │   └─── OneLineSolver.java
│   └─── App.java
└─── README.md
```

## Requirements
- Bahasa Java terinstall pada perangkat

## Cara Menjalankan Program
1. Lakukan *clone repository* melalui terminal dengan *command* berikut
    ``` bash
    $ git clone https://github.com/GoDillonAudris512/Makalah_OneLine_13521062.git
    ```
2. Masuk ke dalam direktori src dan lakukan *compile file* java dengan *command* berikut
   ``` bash
    $ cd src
    $ javac -d ../bin/ App.java
   ```
3. Jika proses *compile* berhasil, maka direktori bin akan berisi *bytecode file* kelas.
   Masuk ke dalam direktori bin dan jalankan program dengan *command* berikut
   ``` bash
    $ cd ../bin
    $ java App <argumen file>
   ```
Pastikan bahwa anda memasukkan suatu argumen *file* ketika menjalankan program. Argumen
dapat berupa *path* absolut atau *path* yang relatif terhadap direktori bin (seperti ../test/tc1.txt). Isi file merupakan suatu matriks dengan nilai antara 0 sampai 3. 0 merupakan kotak yang tak dapatdilewati, 1 merupakan kotak biasa, 2 merupakan kotak mulai, dan 3 merupakan kotak finish.