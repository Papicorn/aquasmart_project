// src/components/ImageGallery.js
import React from 'react';
import './ImageGallery.css';

const ImageGallery = ({ images }) => {
  return (
    <div className="image-gallery">
      {images.map((img, index) => (
        <img key={index} src={img} alt="Gallery" className="gallery-image" />
      ))}
    </div>
  );
};

export default ImageGallery;
