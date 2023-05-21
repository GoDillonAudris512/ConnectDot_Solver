# ConnectDot_Solver

> Source Code untuk menyelesaikan permainan Connect-Dot dengan memanfaatkan algoritma Depth First Search (DFS). Dibuat untuk memenuhi tugas makalah IF2211 Strategi Algoritma 2022/2023

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
Program yang dibuat merupakan suatu program untuk memecahkan masalah permainan Connect-Dot. Connect-Dot
adalah permainan dimana pemain diminta untuk menarik suatu garis dari titik awal sampai ke titik
akhir dalam satu tarikan dan melewati semua titik lain yang ada. Dalam implementasinya,
permainan ini dapat diselesaikan dengan memanfaatkan algoritma Depth First Search (DFS). Program dapat
menerima suatu argumen path dari file, membaca isi file, dan memberikan salah satu langkah yang
mungkin untuk menyelesaikan permainan. Isi file berupa suatu matriks angka yang menggambarkan
susunan titik pada permainan Connect-Dot.

## Sistematika File
```bash
.
├─── bin
│   └─── .gitignore
├─── doc  
│   └─── Penerapan Algoritma Depth First Search (DFS) Dalam Pencarian Solusi Permainan Connect-Dot - Go Dillon Audris - 13521062.pdf
├─── src
│   ├─── Container
│   │   ├─── Board.java
│   │   ├─── Coordinate.java
│   │   └─── Node.java
│   ├─── IO
│   │   └─── Parser.java
│   ├─── Solver
│   │   └─── ConnectDotSolver.java
│   └─── App.java
├─── test
│   ├─── tc1-SimpleSolution.txt
│   ├─── tc2-AdvancedSolution.txt
│   ├─── tc3-AdvancedSolution.txt
│   ├─── tc4-NoSolution.txt
│   ├─── tc5-NoSolution.txt
│   ├─── tc6-InvalidFile.txt
│   └─── tc7-InvalidFile.txt
└─── README.md
```

## Requirements
- Bahasa Java terinstall pada perangkat

## Cara Menjalankan Program
1. Lakukan *clone repository* melalui terminal dengan *command* berikut
    ``` bash
    $ git clone https://github.com/GoDillonAudris512/ConnectDot_Solver.git
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
dapat berupa *path* absolut atau *path* yang relatif terhadap direktori bin (seperti ../test/tc1-SimpleSolution.txt). Isi file merupakan suatu matriks dengan nilai antara 0 sampai 3. 0 merupakan dinding atau kosong, 1 merupakan titik biasa, 2 merupakan titik awal, dan 3 merupakan titik akhir.