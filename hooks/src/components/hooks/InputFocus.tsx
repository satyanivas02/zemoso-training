import React, { useRef } from 'react';

const InputFocus: React.FC = () => {
  const inputRef = useRef<HTMLInputElement>(null); 

  const handleClick = () => {
    if (inputRef.current) {
      inputRef.current.focus(); 
    }
  };

  return (
    <div>
      <input ref={inputRef} type="text" placeholder="Click the button to focus" />
      <button onClick={handleClick}>Focus the Input</button>
    </div>
  );
};

export default InputFocus;
