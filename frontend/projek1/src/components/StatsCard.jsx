// src/components/StatsCard.js
import React from 'react';
import './StatsCard.css';

const StatsCard = ({ icon, label, value }) => {
  return (
    <div className="stats-card">
      <div className="icon">{icon}</div>
      <div className="stats-label">{label}</div>
      <div className="stats-value">{value}</div>
    </div>
  );
};

export default StatsCard;
