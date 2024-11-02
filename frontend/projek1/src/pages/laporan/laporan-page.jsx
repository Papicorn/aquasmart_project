import { ChartGraph } from "../../components/chart";
import { Card } from "../../components/card";
import { useCardStore } from "../../store";
import { Link } from "react-router-dom";

function LaporanPage() {
  return (
    <div className="laporan-page px-80 py-14 flex flex-col items-center">
      <span className="laporan-page__title text-lg mb-8">Bioflok Tunas Regency</span>
      <ChartGraph />
      <div className="laporan-page__detail flex justify-between w-full mt-8 text-lg">
        <span>Bulan Oktober 2024</span>
        <div className="flex gap-x-3">
          <span>
            Laba: <b>Rp.123.456</b>
          </span>
          <span>
            Rugi: <b>Rp.0</b>{" "}
          </span>
        </div>
      </div>
      <div className="laporan-page__card flex flex-col gap-y-5 w-full mt-8">
        {useCardStore((state) => state.cardList).map((item, i) => (
          <Card key={i} {...item} />
        ))}
      </div>
      <Link to="/laporan/adding-page" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
        <button className="laporan-page__button">Tambah</button>
      </Link>
    </div>
  );
}

export default LaporanPage;
