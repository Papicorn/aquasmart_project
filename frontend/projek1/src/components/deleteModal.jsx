import React from "react";

function DeleteModal({ id, deleteState, setShow }) {
  function handleDeleteButton() {
    deleteState(id);
    setShow(false);
  }
  return (
    <div className={`fixed z-50 w-full bottom-0 left-0 right-0 top-0 bg-black bg-opacity-50 flex items-center justify-center`}>
      <div className="card-modal bg-[#EFF6FC] p-10 rounded-lg flex flex-col gap-y-4">
        <span className="font-bold">Apakah anda yakin ingin menghapus data ini?</span>
        <div className="flex gap-x-8 justify-center">
          <button className="text-white bg-[#EC221F] px-9 py-3 rounded-lg" onClick={handleDeleteButton}>
            Hapus
          </button>
          <button className="text-white bg-black px-9 py-3 rounded-lg" onClick={() => setShow(false)}>
            Batal
          </button>
        </div>
      </div>
    </div>
  );
}

export { DeleteModal };
