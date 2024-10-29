/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}", // Ini sudah mencakup semua file di dalam src
    "./src/components/**/*.{js,jsx}", // Ini memastikan semua file di dalam folder components juga tercover
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}
