import React from "react";
import { UserCard } from "../../components/user-card";
import { useUserStore } from "../../store";
import { Link } from "react-router-dom";

function PenggunaPage() {
  const userList = useUserStore((state) => state.userList);
  return (
    <div className="w-full relative px-20 py-8 flex flex-col gap-y-8">
      <span className="text-5xl w-96 font-bold absolute text-white z-10 -top-56">Total Pengguna Keseluruhan</span>

      <span className="text-xl font-bold">{userList.length} Pengguna</span>
      {userList.map((item, i) => (
        <UserCard key={i} {...item} />
      ))}
      <Link to="/pengguna/adding-page" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
        <button className="laporan-page__button">+</button>
      </Link>
    </div>
  );
}

export default PenggunaPage;
