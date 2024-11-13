// NotificationList.js
import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faClock, faTimes } from '@fortawesome/free-solid-svg-icons';
import './Notifications.css';

const notifications = [
  { id: 1, message: "Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4", date: "Jumat, 29 September 2024", color: "blue" },
  { id: 2, message: "Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4", date: "Jumat, 10 Oktober 2024", color: "blue" },
  { id: 3, message: "Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4", date: "Jumat, 13 Oktober 2024", color: "blue" },
  { id: 4, message: "Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4", date: "Jumat, 13 Oktober 2024", color: "red" },
  { id: 5, message: "Jadwal panen hari ini pada jam 09:00 WIB di kolam A2 dan A4", date: "Jumat, 13 Oktober 2024", color: "red" }
];

const NotificationList = ({ onClose }) => (
  <div className="notifications-list">
    {notifications.map((notification) => (
      <div key={notification.id} className={`notification-card ${notification.color}`}>
        <FontAwesomeIcon icon={faClock} className="icon-notification" />
        <div className="notification-content">
          <h4>Reminder!</h4>
          <p>{notification.message}</p>
          <span>{notification.date}</span>
        </div>
        <FontAwesomeIcon icon={faTimes} className="icon-close" onClick={() => onClose(notification.id)} />
      </div>
    ))}
  </div>
);

export default NotificationList;
