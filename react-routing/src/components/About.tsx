import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Box } from '@mui/material';

const About: React.FC = () => {
  const navigate = useNavigate();

  function handleClick() {
    navigate('/dashboard');
  }

  return (
    <Box sx={{ padding: 2 }}>
      <h1>About Page</h1>
      <Button variant="contained" color="primary" onClick={handleClick}>
        Move to Dashboard
      </Button>
    </Box>
  );
};

export default About;
