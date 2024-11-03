import React from 'react';
import { Button, Box } from '@mui/material';

interface SocialButtonProps {
  icon: React.ReactNode;
  label: string;
}

const SocialButton: React.FC<SocialButtonProps> = ({ icon, label }) => {
  return (
    <Button
      fullWidth
      variant="outlined"
      sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', padding: '8px', justifyContent: 'space-around' }}
    >
      <Box>{icon}</Box>
      <Box sx={{ fontSize: '12px', marginTop: '4px' }}>{label}</Box>
    </Button>
  );
};

export default SocialButton;
