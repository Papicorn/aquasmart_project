// src/components/ActivityList.js
import React from 'react';
import './ActivityList.css';

const ActivityList = ({ title, activities }) => {
  return (
    <div className="activity-list">
      <h3>{title}</h3>
      <ul>
        {activities.map((activity, index) => (
          <li key={index}>
            <span>{activity.time}</span>
            <p>{activity.description}</p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ActivityList;
