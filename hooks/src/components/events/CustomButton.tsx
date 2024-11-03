import React from 'react';
import { Button } from '@mui/material';

interface CustomButtonProps {
  onClick: () => void;
  children: React.ReactNode;
}

const CustomButton: React.FC<CustomButtonProps> = ({ onClick, children }) => {
  return (
    <Button
      variant="contained"
      onClick={(e) => {
        e.stopPropagation();  
        onClick();   
      }}
    >
      {children}
    </Button>
  );
};

export default CustomButton;
