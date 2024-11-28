import React from 'react';
import { Button } from '@mui/material';

interface CustomButtonProps {
  children: React.ReactNode;
  onClick?: () => void;
}

const CustomButton: React.FC<CustomButtonProps> = ({ children, onClick }) => {
  return (
    <Button fullWidth variant="contained" onClick={onClick}>
      {children}
    </Button>
  );
};

export default CustomButton;
