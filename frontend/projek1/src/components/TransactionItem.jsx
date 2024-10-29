// TransactionItem.jsx
import React from 'react';

const TransactionItem = ({ icon, description, time, amount, type }) => {
    return (
        <div className="flex items-center justify-between border-2 border-blue-500 p-4 rounded-lg">
            <div className="flex items-center">
                <img src={icon} alt="Transaction icon" className="w-12 h-12 mr-4" />
                <div>
                    <div className="font-semibold">{description}</div>
                    <div className="text-sm text-gray-500">{time}</div>
                </div>
            </div>
            <div className="text-right">
                <div className={`font-semibold ${type === 'pemasukan' ? 'text-green-500' : 'text-red-500'}`}>{amount}</div>
                <div className={`text-sm ${type === 'pemasukan' ? 'text-green-500' : 'text-red-500'}`}>{type}</div>
            </div>
            <div className="text-gray-500">
                <i className="fas fa-ellipsis-v"></i>
            </div>
        </div>
    );
};

export default TransactionItem;