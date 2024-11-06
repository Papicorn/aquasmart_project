import React, { useState } from "react";
import { useUserStore } from "../../../store";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";

function EditPage() {
    const { id } = useParams();
    const user = useUserStore((state) => state.userList).filter((item) => item.id === parseInt(id))[0];
    const editUser = useUserStore((state) => state.updateUser);

    const navigate = useNavigate();

    const [name, setName] = useState(user.name || "");
    const [address, setAddress] = useState(user.address || "");
    const [email, setEmail] = useState(user.email || "");
    const [role, setRole] = useState(user.role || "Petani");
    const [password, setPassword] = useState(user.password || "");

    const handleSubmit = (e) => {
        e.preventDefault();
        let formData = {
            id: user.id,
            name,
            address,
            email,
            role,
            password,
        };
        editUser(formData);
        navigate("/pengguna");
    };
    return (
        <form onSubmit={handleSubmit} className="px-80 m-auto p-8 flex flex-col gap-y-4">
            <div className="flex flex-col gap-y-2">
                <label htmlFor="">Nama Lengkap</label>
                <input type="text" className="border border-secondary-color p-2 rounded-lg" value={name} onChange={(e) => setName(e.target.value)} />
            </div>
            <div className="flex flex-col gap-y-2">
                <label htmlFor="">Lokasi Bioflok</label>
                <input type="text" className="border border-secondary-color p-2 rounded-lg" value={address} onChange={(e) => setAddress(e.target.value)} />
            </div>
            <div className="flex flex-col gap-y-2">
                <label htmlFor="">Email</label>
                <input type="email" className="border border-secondary-color p-2 rounded-lg" value={email} onChange={(e) => setEmail(e.target.value)} />
            </div>

            <div className="flex flex-col gap-y-2">
                <label htmlFor="">Kata Sandi</label>
                <input type="text" className="border border-secondary-color p-2 rounded-lg" value={password} onChange={(e) => setPassword(e.target.value)} />
            </div>

            <button type="submit" className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 self-end">
                Simpan
            </button>
        </form>
    );
}

export default EditPage;