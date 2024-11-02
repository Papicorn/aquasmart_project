/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
import React, { useState } from "react";
import { useCardStore } from "../store";
import { useNavigate } from "react-router-dom";

function Form({ card = {} }) {
  const [kategori, setKategori] = useState(card?.type ?? "");
  const [jenisTransaksi, setJenisTransaksi] = useState(card.title || "");
  const [harga, setHarga] = useState(parseInt(card?.price?.replace(/[^0-9]/g, "")) || 0);
  const [tanggal, setTanggal] = useState("");
  const [catatan, setCatatan] = useState("");

  const addCard = useCardStore((state) => state.addCard);
  const updateCard = useCardStore((state) => state.updateCard);
  const navigate = useNavigate();

  function formatToIDR(number) {
    return new Intl.NumberFormat("id-ID", {
      style: "currency",
      currency: "IDR",
    }).format(number);
  }

  function handleSubmit(e) {
    e.preventDefault();

    let formData = {
      id: new Date().getTime(),
      icon: "fish.png",
      title: jenisTransaksi,
      time: new Date().toLocaleTimeString(),
      price: formatToIDR(harga),
      type: kategori,
    };

    if (card.id) {
      formData.id = card.id;
      updateCard(card.id, formData);
    } else {
      addCard(formData);
    }
    navigate("/laporan");
  }

  return (
    <form onSubmit={handleSubmit} className="flex flex-col">
      <div className="form w-full bg-primary-color px-6 py-12 rounded-lg flex flex-col gap-y-8">
        <div className="flex justify-between h-12 bg-white rounded-lg px-8 py-2 items-center">
          <label htmlFor="kategori-laporan">--Kategori Laporan--</label>
          <select name="kategori-laporan" id="kategori-laporan" value={kategori} onChange={(e) => setKategori(e.target.value)}>
            <option value="" disabled hidden></option>
            <option value="pemasukan">Pemasukan</option>
            <option value="pengeluaran">Pengeluaran</option>
          </select>
        </div>
        <div className="flex justify-between h-12 bg-white rounded-lg px-8 py-2 items-center">
          <label htmlFor="jenis-transaksi">--Jenis Transaksi--</label>
          <select name="jenis-transaksi" id="jenis-transaksi" value={jenisTransaksi} onChange={(e) => setJenisTransaksi(e.target.value)}>
            {kategori === "" && (
              <>
                <option value="pemasukan">Penjualan ikan</option>
                <option value="pengeluaran">Opsi Lainnya</option>
                <option value="pengeluaran">Pakan ikan</option>
                <option value="pengeluaran">Bibit ikan</option>
                <option value="pengeluaran">Biaya peralatan/infrastruktur</option>
                <option value="pengeluaran">Obat-obatan</option>
                <option value="pengeluaran">Opsi lainnya</option>
              </>
            )}
            {kategori === "pemasukan" ? (
              <>
                <option value="pemasukan">Penjualan ikan</option>
                <option value="pengeluaran">Opsi Lainnya</option>
              </>
            ) : (
              <>
                <option value="pengeluaran">Pakan ikan</option>
                <option value="pengeluaran">Bibit ikan</option>
                <option value="pengeluaran">Biaya peralatan/infrastruktur</option>
                <option value="pengeluaran">Obat-obatan</option>
                <option value="pengeluaran">Opsi lainnya</option>
              </>
            )}
          </select>
        </div>
        <div className="flex justify-between bg-white rounded-lg px-8 py-2 items-center">
          <span>Tanggal</span>
          <div>
            <input type="date" className="bg-transparent border-none outline-none" value={tanggal} onChange={(e) => setTanggal(e.target.value)} />
            <i className="fas fa-calendar-alt text-2xl" />
          </div>
        </div>
        <div className="flex justify-between bg-white rounded-lg pe-8 items-center">
          <span className="w-20 h-11 rounded-s-lg bg-secondary-color bg-opacity-50 text-start ps-4 pt-2 ">Rp</span>
          <input type="number" placeholder="0" className="w-full bg-transparent border-none outline-none ms-5" value={harga} onChange={(e) => setHarga(e.target.value)} />
        </div>
        <div>
          <textarea
            className="w-full bg-white rounded-lg px-8 py-2 outline-none h-32 placeholder:text-black"
            placeholder="Catatan"
            value={catatan}
            onChange={(e) => setCatatan(e.target.value)}
          ></textarea>
        </div>
      </div>
      {card ? (
        <button type="submit" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
          Simpan
        </button>
      ) : (
        <button type="submit" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
          Tambah
        </button>
      )}
    </form>
  );
}

export { Form };
