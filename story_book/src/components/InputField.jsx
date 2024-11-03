import React from 'react';

const InputField = ({ placeholder, value, onChange }) => {
  return (
    <input
      type="text"
      placeholder={placeholder}
      value={value}
      onChange={onChange}
      style={{ padding: '8px', fontSize: '16px', width: '200px' }}
    />
  );
};

export default InputField;
