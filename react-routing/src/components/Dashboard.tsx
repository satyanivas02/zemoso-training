import React from 'react';
import { Outlet } from 'react-router-dom';
import { Box } from '@mui/material';

const Dashboard: React.FC = () => {
  return (
    <Box sx={{ padding: 2 }}>
      <h1>Dashboard Page</h1>
      <Outlet />
    </Box>
  );
};

export default Dashboard;
