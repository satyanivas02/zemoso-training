import React from 'react';
import { Button as MUIButton } from '@mui/material';

interface ButtonProps {
  onClick: () => void;
  children: React.ReactNode;
}

const Button: React.FC<ButtonProps> = ({ onClick, children }) => {
  return (
    <MUIButton variant="contained" onClick={onClick}>
      {children}
    </MUIButton>
  );
};

export default Button;
