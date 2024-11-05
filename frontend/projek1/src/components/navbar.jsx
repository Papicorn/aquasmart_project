import React from "react";
import { Link, useLocation } from "react-router-dom";

const navbarList = [
  { url: "/", name: "Beranda" },
  { url: "/pengguna", name: "Pengguna" },
  { url: "/laporan", name: "Laporan" },
  { url: "/dokumentasi", name: "Dokumentasi" },
];

function Navbar() {
  const location = useLocation();

  return (
    <div className="navbar__container flex items-center justify-between h-16 w-full bg-primary-color px-8 absolute botom-0 z-20">
      <img src="logo.png" alt="logo" className="navbar__logo h-12 " />
      <div className="navbar__list flex gap-x-10">
        {navbarList.map((item, i) => (
          <Link to={item.url} key={i} className={`text-white text-lg cursor-pointer ${location.pathname === item.url && "font-bold"}`}>
            {item.name}
          </Link>
        ))}
      </div>
      <div className="navbar__icons flex gap-x-4">
        <img src="icons/Bell.png" alt="Bell" className="h-5 cursor-pointer" />

        <Link to={"/profile"}>
          <img src="icons/User.png" alt="User" className="h-5 cursor-pointer" />
        </Link>
      </div>
    </div>
  );
}

export { Navbar };