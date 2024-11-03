import React from 'react';
import { Typography } from '@mui/material';

interface CustomTypographyProps {
  variant: 'h4' | 'body1';
  children: React.ReactNode;
}

const CustomTypography: React.FC<CustomTypographyProps> = ({ variant, children }) => {
  return <Typography variant={variant}>{children}</Typography>;
};

export default CustomTypography;
