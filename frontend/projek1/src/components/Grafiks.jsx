import React, { useState } from "react";
import Chart from 'react-apexcharts';
import '@fortawesome/fontawesome-free/css/all.min.css';
import './Grafiks.css'; // Pastikan Anda memiliki file CSS ini

const Grafik = () => {
    const allData = {
        '2023': {
            pemasukan: [700000, 1000000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000],
            pengeluaran: [500000, 400000, 300000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000]
        },
        '2024': {
            pemasukan: [800000, 1200000, 1600000, 2100000, 2600000, 3100000, 3600000, 4100000, 4600000, 5100000, 5600000, 6100000],
            pengeluaran: [600000, 500000, 400000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000]
        }
    };

    const [startDate, setStartDate] = useState('');
    const [endDate, setEndDate] = useState('');
    const [year, setYear] = useState('2023');

    const handleYearChange = (e) => {
        setYear(e.target.value);
    };

    const handleStartDateChange = (e) => {
        setStartDate(e.target.value);
    };

    const handleEndDateChange = (e) => {
        setEndDate(e.target.value);
    };

    // Fungsi untuk mendapatkan bulan dari tanggal
    const getMonthIndex = (dateString) => {
        const date = new Date(dateString);
        return date.getMonth();
    };

    // Hitung laba dan rugi
    const calculateProfitAndLoss = (startMonth, endMonth) => {
        const pemasukan = allData[year].pemasukan.slice(startMonth, endMonth + 1);
        const pengeluaran = allData[year].pengeluaran.slice(startMonth, endMonth + 1);

        const laba = pemasukan.map((p, index) => p - pengeluaran[index]);
        const rugi = laba.map(l => (l < 0 ? -l : 0)); // Rugi hanya jika laba negatif

        return { laba, rugi };
    };

    const startMonthIndex = startDate ? getMonthIndex(startDate) : 0;
    const endMonthIndex = endDate ? getMonthIndex(endDate) : 11;

    const { laba, rugi } = calculateProfitAndLoss(startMonthIndex, endMonthIndex);

    const series = [
        {
            name: 'Pemasukan',
            data: allData[year].pemasukan.slice(startMonthIndex, endMonthIndex + 1)
        },
        {
            name: 'Pengeluaran',
            data: allData[year].pengeluaran.slice(startMonthIndex, endMonthIndex + 1)
        },
        {
            name: 'Laba',
            data: laba
        },
        {
            name: 'Rugi',
            data: rugi
        }
    ];

    const options = {
        chart: {
            type: 'bar',
            stacked: false,
            zoom: {
                enabled: false
            },
            toolbar: {
                show: true
            }
        },
        plotOptions: {
            bar: {
                horizontal: false,
                columnWidth: '55%',
                endingShape: 'rounded'
            },
        },
        dataLabels: {
            enabled: true
        },
        xaxis: {
            categories: [
                'Januari', 'Februari', 'Maret', 'April', 'Mei', 'Juni',
                'Juli', ' Agustus', 'September', 'Oktober', 'November', 'Desember'
            ].slice(startMonthIndex, endMonthIndex + 1),
            title: {
                text: 'Bulan'
            }
        },
        yaxis: {
            title: {
                text: 'Jumlah (IDR)'
            }
        },
        title: {
            text: 'Grafik Pemasukan, Pengeluaran, Laba, dan Rugi',
            align: 'center'
        },
        legend: {
            position: 'top',
            horizontalAlign: 'center',
            floating: true,
            offsetY: -20,
            offsetX: 0
        },
        fill: {
            opacity: 1
        },
        tooltip: {
            shared: true,
            intersect: false
        }
    };

    return (
        <div className="container">
            <div className="header">Bioflok Tunas Regency</div>
            <div className="date-range">
                <div>
                    Dari:
                    <input
                        type="date"
                        value={startDate}
                        onChange={handleStartDateChange}
                    />
                    <i className="fas fa-calendar-alt"></ i>
                </div>
                <div>-</div>
                <div>
                    Sampai:
                    <input
                        type="date"
                        value={endDate}
                        onChange={handleEndDateChange}
                    />
                    <i className="fas fa-calendar-alt"></i>
                </div>
            </div>
            <div className="mb-3">
                <label htmlFor="yearSelect" className="form-label">Pilih Tahun:</label>
                <select id="yearSelect" className="form-select" value={year} onChange={handleYearChange}>
                    <option value="2023">2023</option>
                    <option value="2024">2024</option>
                </select>
            </div>
            <div style={{ width: '500px', height: '300px' }}>
                <Chart options={options} series={series} type="bar" />
            </div>
        </div>
    );
};

export default Grafik;