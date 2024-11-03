import React from 'react';
import { Box } from '@mui/material';
import CustomButton from './CustomButton';

const Toolbar: React.FC = () => {
  return (
    <Box
      sx={{
        p: 2,
        backgroundColor: '#f5f5f5',
      }}
      onClick={() => {
        alert('You clicked on the toolbar!');
      }}
    >
      <CustomButton onClick={() => alert('Playing!')}>Play Movie</CustomButton>
      <CustomButton onClick={() => alert('Uploading!')}>Upload Image</CustomButton>
    </Box>
  );
};

export default Toolbar;
