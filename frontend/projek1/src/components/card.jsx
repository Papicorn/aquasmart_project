/* eslint-disable react/prop-types */
/* eslint-disable no-unused-vars */
import React from "react";
import { useState } from "react";
import { ActionButton } from "./actionButton";
import { useCardStore } from "../store";

function Card({ id, icon, title, time, price, type }) {
  const [showActionMenu, setShowActionMenu] = useState(false);

  const toggleActionMenu = () => {
    setShowActionMenu((prev) => !prev);
  };

  return (
    <div className="card__container w-full flex rounded-lg border-solid border-primary-color p-5 items-center justify-between border-4">
      <div className="card__content flex items-center gap-x-4">
        <div className="card__icon">
          <img src={"icons/" + icon} alt="card-icon" />
        </div>
        <div className="card__content-detail flex flex-col">
          <span className="card__title">{title}</span>
          <span className="card__time text-sm font-bold">{time}</span>
        </div>
      </div>
      <div className="card__content relative flex gap-x-3">
        <div className="card__content-detail flex flex-col justify-center">
          <span className={`card__price font-bold ${type === "pengeluaran" ? "text-[#FF0004]" : "text-[#0FD205]"}`}>{price}</span>
          <span className="card__type text-sm font-bold">{type}</span>
        </div>
        <button className="card__option" onClick={toggleActionMenu}>
          <img src="icons/option.png" alt="Option" className="w-5 self-center" />
        </button>
        <div className="-bottom-0 -right-0 relative">{showActionMenu && <ActionButton id={id} deleteState={useCardStore.getState().deleteCard} />}</div>
      </div>
    </div>
  );
}

export { Card };
