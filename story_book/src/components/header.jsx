import React from 'react';

const Heading = ({ text, boldPart }) => {
  const parts = text.split(boldPart);

  return (
    <big>
      {parts[0]}
      <strong>{boldPart}</strong>
      {parts[1]}
    </big>
  );
};

export default Heading;
