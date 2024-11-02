import { create } from "zustand";

const rawCardList = [
  {
    id: 1,
    icon: "fish.png",
    title: "Penjualan ikan x256",
    time: "20:56:08",
    price: "Rp.825.000",
    type: "pemasukan",
  },
  {
    id: 2,
    icon: "fish.png",
    title: "Pembelian stok pakan 3kg",
    time: "20:56:08",
    price: "Rp.825.000",
    type: "pengeluaran",
  },
  {
    id: 3,
    icon: "egg.png",
    title: "Pembelian bibit ikan x200",
    time: "20:56:08",
    price: "Rp.825.000",
    type: "pengeluaran",
  },
  {
    id: 4,
    icon: "fish.png",
    title: "Pembelian stok pakan 3kg",
    time: "20:56:08",
    price: "Rp.825.000",
    type: "pengeluaran",
  },
  {
    id: 5,
    icon: "fish.png",
    title: "Pembelian stok pakan 3kg",
    time: "20:56:08",
    price: "Rp.825.000",
    type: "pengeluaran",
  },
];

const rawUserList = [
  {
    id: 0,
    name: "Budiono Siregar",
    role: "Petani",
    registration: "20 Oktober 2000",
    address: "Indojaya Bioflok",
  },
  {
    id: 1,
    name: "Budiono Siregar",
    role: "Petani",
    registration: "20 Oktober 2000",
    address: "Indojaya Bioflok",
  },
  {
    id: 2,
    name: "Budiono Siregar",
    role: "Petani",
    registration: "20 Oktober 2000",
    address: "Indojaya Bioflok",
  },
];

const useCardStore = create((set) => ({
  cardList: rawCardList,
  addCard: (card) => set((state) => ({ cardList: [...state.cardList, card] })),
  deleteCard: (id) => set((state) => ({ cardList: state.cardList.filter((item) => item.id !== id) })),
  updateCard: (id, card) => set((state) => ({ cardList: state.cardList.map((item) => (item.id === id ? card : item)) })),
}));

const useUserStore = create((set) => ({
  userList: rawUserList,
  addUser: (user) => set((state) => ({ userList: [...state.userList, user] })),
  deleteUser: (id) => set((state) => ({ userList: state.userList.filter((item) => item.id !== id) })),
}));

export { useCardStore, useUserStore };
