import React from 'react';
import { Button as MUIButton } from '@mui/material';

interface AlertButtonProps {
  message: string;
  children: React.ReactNode;
}

const AlertButton: React.FC<AlertButtonProps> = ({ message, children }) => {
  return (
    <MUIButton variant="contained" onClick={() => alert(message)}>
      {children}
    </MUIButton>
  );
};

export default AlertButton;
