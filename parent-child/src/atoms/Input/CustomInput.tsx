import React from 'react';
import { TextField, InputAdornment } from '@mui/material';

interface CustomInputProps {
  type: string;
  placeholder: string;
  icon: React.ReactNode;
}

const CustomInput: React.FC<CustomInputProps> = ({ type, placeholder, icon }) => {
  return (
            <TextField
             type={type}
              placeholder={placeholder}
              fullWidth
              slotProps={{
                input: {
                  startAdornment: (
                    <InputAdornment position="start">
                      {icon}
                    </InputAdornment>
                  ),
                },
              }}
            />            
  );
};

export default CustomInput;
