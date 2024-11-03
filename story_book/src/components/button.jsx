import React from 'react';
import './button.css';

const Button = ({ label, onClick, type }) => {
  return (
    <button className={`btn ${type}`} onClick={onClick}>
      {label}
    </button>
  );
};

export default Button;
