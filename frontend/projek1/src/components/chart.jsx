import React, { useState, useEffect, useMemo } from "react";
import Chart from "react-apexcharts";

const ChartGraph = () => {
  const allData = useMemo(() => {
    return {
      2023: {
        pemasukan: [700000, 1000000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000],
        pengeluaran: [500000, 400000, 300000, 1500000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000],
      },
      2024: {
        pemasukan: [800000, 1200000, 1600000, 2100000, 2600000, 3100000, 3600000, 4100000, 4600000, 5100000, 5600000, 6100000],
        pengeluaran: [600000, 500000, 400000, 2000000, 2500000, 3000000, 3500000, 4000000, 4500000, 5000000, 5500000, 6000000],
      },
    };
  }, []);

  const [startDate, setStartDate] = useState("2023-01-01");
  const [endDate, setEndDate] = useState("2024-12-31");
  const [series, setSeries] = useState([]);
  const minInputDate = "2023-01-01";
  const maxInputDate = "2024-12-31";

  const handleStartDateChange = (e) => {
    setStartDate(e.target.value);
  };

  const handleEndDateChange = (e) => {
    setEndDate(e.target.value);
  };

  useEffect(() => {
    if (startDate && endDate) {
      const startYear = new Date(startDate).getFullYear();
      const endYear = new Date(endDate).getFullYear();
      const startMonth = new Date(startDate).getMonth();
      const endMonth = new Date(endDate).getMonth();

      let totalPemasukan = 0;
      let totalPengeluaran = 0;

      // Iterasi melalui tahun dan bulan untuk menghitung total
      for (let year = startYear; year <= endYear; year++) {
        const dataYear = allData[year];
        if (dataYear) {
          const start = year === startYear ? startMonth : 0;
          const end = year === endYear ? endMonth : 11;

          totalPemasukan += dataYear.pemasukan.slice(start, end + 1).reduce((a, b) => a + b, 0);
          totalPengeluaran += dataYear.pengeluaran.slice(start, end + 1).reduce((a, b) => a + b, 0);
        }
      }

      const totalLaba = totalPemasukan - totalPengeluaran;
      const totalRugi = totalPengeluaran - totalPemasukan;

      setSeries([
        {
          name: "Pemasukan",
          data: [totalPemasukan],
        },
        {
          name: "Pengeluaran",
          data: [totalPengeluaran],
        },
        {
          name: "Laba",
          data: [totalLaba],
        },
        {
          name: "Rugi",
          data: [Math.abs(totalRugi)],
        },
      ]);
    }
  }, [allData, startDate, endDate]);

  const options = {
    chart: {
      type: "bar",
      stacked: false,
      zoom: {
        enabled: false,
      },
      margin: {
        right: 20,
      },
      toolbar: {
        show: false,
      },
    },

    plotOptions: {
      bar: {
        horizontal: false,
        columnWidth: "70%",
        endingShape: "rounded",
        borderRadius: 5,
        dataLabels: {
          position: "top",
        },
      },
    },
    colors: ["#34C759", "#EC221F", "#3300FF", "#FFE100"],
    dataLabels: {
      enabled: true,
      style: {
        colors: ["#fff"],
        fontSize: "12px",
        offsetY: "-15px",
      },
    },
    xaxis: {
      lines: {
        show: false,
      },
      categories: [""],
      title: {
        text: "",
      },
      axisBorder: {
        show: true,
        color: "#000",
        height: 2,
        offsetX: 0,
        offsetY: 0,
      },
      labels: {
        style: {
          colors: ["#fff"],
          fontSize: "14px",
          fontWeight: "bold",
        },
      },
    },
    yaxis: {
      lines: {
        show: false,
      },
      title: {
        text: "",
      },
      labels: {
        style: {
          colors: "#000",
          fontSize: "12px",
        },
      },
      axisBorder: {
        show: true, // Menampilkan border pada y-axis
        color: "#000", // Warna border
        width: 2, // Lebar border
      },
    },
    title: {
      text: "",
      align: "center",
    },
    legend: {
      position: "bottom",
      horizontalAlign: "center",
      floating: true,
      offsetY: 0,
      offsetX: 0,
    },
    fill: {
      opacity: 1,
    },
    grid: {
      borderColor: "#fff",
      xaxis: {
        lines: {
          show: false,
        },
      },
      yaxis: {
        lines: {
          show: false,
        },
      },
    },
    tooltip: {
      enabled: true,
      theme: "light",
    },
  };
  return (
    <div className="chart__container bg-secondary-color p-8 w-max rounded-lg">
      <div className="chart__date-range flex justify-between mb-2 items-center">
        <div className="chart__date-start bg-white px-4 py-2 rounded-lg font-bold">
          Tanggal
          <input type="date" value={startDate} min={minInputDate} max={maxInputDate} onChange={handleStartDateChange} className="bg-transparent text-transparent border-none outline-none" />
          <i className="fas fa-calendar-alt"></i>
        </div>
        <span className="text-7xl text-white">-</span>
        <div className="chart__date-end bg-white px-4 py-2 rounded-lg font-bold ">
          Tanggal
          <input type="date" value={endDate} min={startDate} max={maxInputDate} onChange={handleEndDateChange} className="bg-transparent text-transparent border-none outline-none" />
          <i className="fas fa-calendar-alt"></i>
        </div>
      </div>

      {series.length > 0 && (
        <div style={{ width: "800px", borderRadius: "10px", backgroundColor: "#FFF" }} className="pb-5">
          <Chart options={options} series={series} type="bar" />
        </div>
      )}
    </div>
  );
};

export { ChartGraph };
