import React, { useState } from "react";
import { useUserStore } from "../../../store";
import { useNavigate } from "react-router-dom";

function AddingPage() {
  const addUser = useUserStore((state) => state.addUser);
  const navigate = useNavigate();

  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [email, setEmail] = useState("");
  const [role, setRole] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    let formData = {
      name,
      address,
      email,
      role,
      password,
    };
    addUser(formData);
    navigate("/pengguna");
  };
  return (
    <form onSubmit={handleSubmit} className="px-80 m-auto p-8 flex flex-col gap-y-4">
      <div className="flex flex-col gap-y-2">
        <label htmlFor="">Nama Lengkap</label>
        <input type="text" className="border border-secondary-color p-2 rounded-lg" onChange={(e) => setName(e.target.value)} />
      </div>
      <div className="flex flex-col gap-y-2">
        <label htmlFor="">Lokasi Bioflok</label>
        <input type="text" className="border border-secondary-color p-2 rounded-lg" onChange={(e) => setAddress(e.target.value)} />
      </div>
      <div className="flex flex-col gap-y-2">
        <label htmlFor="">Email</label>
        <input type="email" className="border border-secondary-color p-2 rounded-lg" onChange={(e) => setEmail(e.target.value)} />
      </div>
      <div className="flex flex-col gap-y-2">
        <label htmlFor="">Role</label>
        <input type="text" className="border border-secondary-color p-2 rounded-lg" onChange={(e) => setRole(e.target.value)} />
      </div>
      <div className="flex flex-col gap-y-2">
        <label htmlFor="">Kata Sandi</label>
        <input type="password" className="border border-secondary-color p-2 rounded-lg" onChange={(e) => setPassword(e.target.value)} />
      </div>

      <button type="submit" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
        Simpan
      </button>
    </form>
  );
}

export default AddingPage;
