import React, { useState } from "react";
import { Link } from "react-router-dom";
import { DeleteModal } from "./deleteModal";

function ActionButton({ id, deleteState }) {
  const [showModal, setShowModal] = useState(false);

  return (
    <div className="action__container bg-white flex flex-col border-2 border-black p-2 rounded-md">
      <Link to={`/laporan/${id}`}>
        <button className="action__option">Edit</button>
      </Link>
      <button className="action__option" onClick={() => setShowModal((prev) => !prev)}>
        Hapus
      </button>

      {showModal && <DeleteModal id={id} deleteState={deleteState} setShow={setShowModal} />}
    </div>
  );
}

export { ActionButton };
