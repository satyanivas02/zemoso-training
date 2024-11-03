import React from 'react';
import { useNavigate } from 'react-router-dom';
import { Button, Box } from '@mui/material';

const Home: React.FC = () => {
  const navigate = useNavigate();

  function handleClick() {
    navigate('/about');
  }

  return (
    <Box sx={{ padding: 2 }}>
      <h1>Home Page</h1>
      <Button variant="contained" color="primary" onClick={handleClick}>
        Move to About Page
      </Button>
    </Box>
  );
};

export default Home;
