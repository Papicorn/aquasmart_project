/* eslint-disable no-unused-vars */
import React from "react";
import { useParams } from "react-router-dom";
import { useCardStore } from "../../../store";
import { Form } from "../../../components/form";

function EditPage() {
  const { id } = useParams();

  const card = useCardStore((state) => state.cardList).filter((item) => item.id === parseInt(id));
  console.log(card);

  return (
    <div className="form-container px-80 py-14">
      <Form card={card[0]} />
    </div>
  );
}

export default EditPage;
