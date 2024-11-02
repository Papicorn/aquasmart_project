import React from "react";

function Hero() {
  return (
    <div className="relative h-96 bg-[url('hero.png')] bg-bottom bg-cover">
      <div className="absolute inset-0 bg-gradient-to-t from-secondary-color to-transparent"></div>
    </div>
  );
}

export { Hero };
