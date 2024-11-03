import React from 'react';
import { useParams } from 'react-router-dom';
import { Box } from '@mui/material';

const ParamComp: React.FC = () => {
  const { id } = useParams<{ id: string }>();

  return (
    <Box sx={{ padding: 2 }}>
      <h1>Params: {id}</h1>
    </Box>
  );
};

export default ParamComp;
