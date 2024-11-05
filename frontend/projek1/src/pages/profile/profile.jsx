import React from "react";
import { Link } from "react-router-dom";
import { useProfileStore } from "../../store";
import { useState } from "react";
import { LogoutModal } from "../../components/logoutModal";
function Profile() {
    const profile = useProfileStore((state) => state.profile);
    const [show, setShow] = useState(false);

    return (
        <div className="profile__container relative pb-8">
            <img src="icons/profile.png" alt="profile__image" className="profile__image w-60 relative -top-24 left-10" />
            <div className="profile__detail px-80 flex flex-col gap-y-6 items-center">
                <div className="border h-14 profile__name border-secondary-color p-2 rounded-lg flex items-center self-stretch">
                    <img src="/icons/username-icon.png" alt="username icon" className="w-5 me-4" />
                    {profile.name}
                </div>
                <div className="border h-14 profile__address border-secondary-color p-2 rounded-lg flex items-center self-stretch">
                    <img src="/icons/address-icon.png" alt="username icon" className="w-5 me-4" />
                    {profile.address}
                </div>
                <div className="border h-14 profile__email border-secondary-color p-2 rounded-lg flex items-center self-stretch">
                    <img src="/icons/email-icon.png" alt="username icon" className="w-5 me-4" />
                    {profile.email}
                </div>
                <div className="border h-14 profile__password border-secondary-color p-2 rounded-lg flex items-center self-stretch">
                    <img src="/icons/password-icon.png" alt="username icon" className="w-5 me-4" />
                    {profile.password}
                </div>

                <div className="profile__button flex flex-col justify-center">
                    <Link to={"/profile/edit"} className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4 text-center">
                        Edit
                    </Link>
                    <button className=" bg-primary-color text-white px-4 py-2 rounded-lg mt-4" onClick={() => setShow(true)}>
                        Logout
                    </button>
                    {show && <LogoutModal setShow={setShow} profile={profile} />}
                </div>
            </div>
        </div>
    );
}

export default Profile;