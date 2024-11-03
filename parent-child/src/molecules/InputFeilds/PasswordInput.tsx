import React, { useState } from 'react';
import { TextField, InputAdornment } from '@mui/material';

const PasswordInput: React.FC = () => {
  const [showPassword, setShowPassword] = useState(false);

  const handleTogglePassword = () => {
    setShowPassword((prev) => !prev);
  };

  return (
    <TextField
      type={showPassword ? 'text' : 'password'}
      placeholder="Enter your password"
      fullWidth
      InputProps={{
        startAdornment: (
          <InputAdornment position="start">
            <img src="/assets/lock.svg" alt="lock icon" />
          </InputAdornment>
        ),
        endAdornment: (
          <InputAdornment position="end">
            <img
              src={showPassword ? '/assets/eye-slash.svg' : '/assets/eye.svg'}
              alt="toggle password visibility"
              onClick={handleTogglePassword}
              style={{ cursor: 'pointer' }}
            />
          </InputAdornment>
        ),
      }}
    />
  );
};

export default PasswordInput;
