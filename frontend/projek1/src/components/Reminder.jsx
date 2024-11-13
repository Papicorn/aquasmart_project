// src/components/Reminder.js
import React, { useState } from 'react';
import './Reminder.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClock, faTimes } from '@fortawesome/free-solid-svg-icons';
import { DeleteModal } from './deleteModal';

const initialReminders = [
    { id: 1, text: "Jadwal panen hari Jumat pada jam 08:00 WIB di kolam 42 dan 44.", date: "Jumat, 20 September 2024", color: "blue" },
    { id: 2, text: "Jadwal panen hari Jumat pada jam 08:00 WIB di kolam 42 dan 44.", date: "Jumat, 13 Oktober 2024", color: "blue" },
    { id: 3, text: "Jadwal panen hari Jumat pada jam 08:00 WIB di kolam 42 dan 44.", date: "Jumat, 13 Oktober 2024", color: "blue" },
    { id: 4, text: "Jadwal panen hari Jumat pada jam 08:00 WIB di kolam 42 dan 44.", date: "Jumat, 14 Oktober 2024", color: "red" },
    { id: 5, text: "Jadwal panen hari Jumat pada jam 08:00 WIB di kolam 42 dan 44.", date: "Jumat, 14 Oktober 2024", color: "red" },
];

const Reminder = () => {
    const [reminders, setReminders] = useState(initialReminders);
    const [showDeleteModal, setShowDeleteModal] = useState(false);
    const [reminderToDelete, setReminderToDelete] = useState(null);

    const deleteReminder = (id) => {
        setReminders(reminders.filter(reminder => reminder.id !== id));
    };

    const openDeleteModal = (id) => {
        setReminderToDelete(id);
        setShowDeleteModal(true);
    };

    return (
        <div className="reminder-container">
            <h2>Reminder</h2>
            <div className="reminder-list">
                {reminders.map((reminder) => (
                    <div key={reminder.id} className={`reminder-card ${reminder.color}`}>
                        <div className="reminder-content">
                            <FontAwesomeIcon icon={faClock} className="icon" />
                            <div>
                                <h4>Reminder!</h4>
                                <p>{reminder.text}</p>
                            </div>
                        </div>
                        <div>
                            <span>{reminder.date}</span>
                            <FontAwesomeIcon
                                icon={faTimes}
                                className="close-icon"
                                onClick={() => openDeleteModal(reminder.id)}
                            />
                        </div>
                    </div>
                ))}
            </div>
            {showDeleteModal && (
                <DeleteModal
                    id={reminderToDelete}
                    deleteState={deleteReminder}
                    setShow={setShowDeleteModal}
                />
            )}
        </div>
    );
};

export default Reminder;