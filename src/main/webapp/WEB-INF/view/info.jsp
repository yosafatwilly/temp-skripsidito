<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="KNN - Info">
    <!-- row -->
    <div class="row tm-content-row">
        <label class="tm-hide-sm">&nbsp;</label>
        <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-taller">
                <h2 class="tm-block-title">Tentang Website Ini</h2>
                <p class="text-white"><b>Website</b> ini dibuat untuk mengimplementasikan algoritma
                    <i>k-Nearest Neighbor</i> dalam melakukan pengklasifikasian
                    terhadap calon karyawan baru dengan menggunakan hasil
                    tes <i>DISC</i>. Keluaran yang dihasilkan dari implementasi
                    algoritma <i>k-Nearest Neighbor</i> tadi adalah berupa akurasi
                    dan jarak terdekat dari data yang diuji. Tidak hanya
                    menguji <i>dataset</i> yang ada, <i>website</i> ini juga dapat menguji
                    data tunggal untuk mengetahui hasil klasifikasi dari uji
                    data tunggal tersebut. Data untuk uji data tunggal
                    dimasukkan secara manual.<br><br>
                    <b>Data</b> yang dapat diolah pada <i>website</i> ini adalah data
                    yang hanya berekstensi <b>.xls</b> atau <b>.xlsx</b> (Ms.Excel).</p>
            </div>
        </div>
    </div>
</z:layout>
