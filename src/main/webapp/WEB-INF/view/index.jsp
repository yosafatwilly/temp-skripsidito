<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="z" tagdir="/WEB-INF/tags" %>
<z:layout pageTitle="KNN - Index">
    <div class="row tm-content-row">
        <label class="tm-hide-sm">&nbsp;</label>
        <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                <div class="row">
                    <div class="form-group col-sm-5">
                        <p style="color: white">Pilih file Testing</p>
                        <div class="btn-group-sm">
                            <form action="/upload" method="post" enctype="multipart/form-data">
                                <input id="telusuri" type="file" name="excel" class="btn btn-primary text-uppercase"/>
                                <br>
                                <br>
                                <button id="unggah" type="submit" class="btn btn-success text-uppercase">Unggah</button>
                            </form>
                        </div>
                    </div>
                </div>
                <table id="tabelDataset" class="table">
                    <thead>
                    <tr>
                        <th scope="col" colspan="4">I/MASK</th>
                        <th scope="col" colspan="4">II/UNDER PRESSURE</th>
                        <th scope="col" colspan="4">III/SELF</th>
                        <th scope="col" rowspan="2">LABEL</th>
                    </tr>

                    <tr>

                        <th scope="col">D</th>
                        <th scope="col">I</th>
                        <th scope="col">S</th>
                        <th scope="col">C</th>

                        <th scope="col">D</th>
                        <th scope="col">I</th>
                        <th scope="col">S</th>
                        <th scope="col">C</th>

                        <th scope="col">D</th>
                        <th scope="col">I</th>
                        <th scope="col">S</th>
                        <th scope="col">C</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${testing}" var="test" >
                        <tr>
                            <c:forEach items="${test.attributes}" var="att" >
                                <td >${att}</td>
                            </c:forEach>

                            <td >${test.classLabel}</td>

                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>

        <div class="tm-block-col tm-col-avatar">
            <div class="tm-bg-primary-dark tm-block tm-block-settings">
                <h2 class="tm-block-title">Implementasi k-Nearest Neighbor</h2>
                <form action="/hitung" method="post" class="tm-signup-form row">
                    <div class="form-group col-sm-5">
                        <label>Masukkan K</label>
                        <input
                                id="inputK"
                                name="inputK"
                                type="text"
                                class="form-control validate"
                                value=""/>
                    </div>
                    <div class="form-group col-lg-5">
                        <label class="tm-hide-sm">&nbsp;</label>
                        <button id="prosesK" type="submit" class="btn btn-primary text-uppercase">Proses</button>
                    </div>
                    <div class="form-group col-sm-5">
                        <label id="outputKnn">--output-- = ${akurasi}</label>
                    </div>
                </form>
            </div>
        </div>

        <div class="tm-block-col tm-col-account-settings">
            <div class="tm-bg-primary-dark tm-block tm-block-settings">
                <h2 class="tm-block-title">Uji Data Tunggal</h2>
                <form action="/predict" method="POST" class="tm-signup-form row">
                    <table>
                        <thead>
                        <tr>
                            <th>I/Mask</th>
                            <th>II/Under-Pressure</th>
                            <th>III/Self</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td class="text-center">
                                <div class="form-group col-sm-5">
                                    <label>D</label>
                                    <input
                                            id="maskD"
                                            name="maskD"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>I</label>
                                    <input
                                            id="maskI"
                                            name="maskI"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>S</label>
                                    <input
                                            id="maskS"
                                            name="maskS"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>C</label>
                                    <input
                                            id="maskC"
                                            name="maskC"
                                            type="text"
                                            class="form-control validate"
                                            value=""/>
                                </div>
                            </td>
                            <td class="text-center">
                                <div class="form-group col-sm-5">
                                    <label>D</label>
                                    <input
                                            id="pressureD"
                                            name="pressureD"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>I</label>
                                    <input
                                            id="pressureI"
                                            name="pressureI"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>S</label>
                                    <input
                                            id="pressureS"
                                            name="pressureS"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>C</label>
                                    <input
                                            id="pressureC"
                                            name="pressureC"
                                            type="text"
                                            class="form-control validate"
                                            value=""/>
                                </div>
                            </td>
                            <td class="text-center">
                                <div class="form-group col-sm-5">
                                    <label>D</label>
                                    <input
                                            id="selfD"
                                            name="selfD"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>I</label>
                                    <input
                                            id="selfI"
                                            name="selfI"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>S</label>
                                    <input
                                            id="selfS"
                                            name="selfS"
                                            type="text"
                                            class="form-control validate"
                                            value=""/><br>
                                    <label>C</label>
                                    <input
                                            id="selfC"
                                            name="selfC"
                                            type="text"
                                            class="form-control validate"
                                            value=""/>
                                </div>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <div class="col-12">
                        <button id="prosesUji" type="submit" class="btn btn-primary btn-block text-uppercase">
                            Proses
                        </button>
                    </div>
                    <div class="form-group col-sm-5">
                        <label id="outputUji">--output-- = ${output}</label>
                    </div>
                </form>
            </div>
        </div>
    </div>
</z:layout>
