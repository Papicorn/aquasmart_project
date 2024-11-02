import React, { useState } from "react";
import { ActionButton } from "./actionButton";
import { useUserStore } from "../store";

function UserCard({ id, name, role, registration, address }) {
  const [showActionMenu, setShowActionMenu] = useState(false);

  const toggleActionMenu = () => {
    setShowActionMenu((prev) => !prev);
  };

  return (
    <div className="user-card__container border-4 border-secondary-color w-full flex justify-between  p-4 rounded-lg text-lg">
      <div className="user-card__detail flex flex-col">
        <div className="user-card__content flex gap-x-4  ">
          <span className="user-card__name">
            <b>{name}</b>
          </span>
          <span className="user-card__role">{role}</span>
        </div>
        <span className="user-card__registration">
          Tgl Daftar : <b>{registration}</b>
        </span>
        <span className="user-card__address">
          Lokasi : <b>{address}</b>
        </span>
      </div>
      <div className="flex">
        <button onClick={toggleActionMenu}>
          <img src="icons/option.png" alt="Option" className="w-8 self-center" />
        </button>
        <div className="-bottom-0 -right-0 relative">{showActionMenu && <ActionButton id={id} deleteState={useUserStore.getState().deleteUser} />}</div>
      </div>
    </div>
  );
}

export { UserCard };
