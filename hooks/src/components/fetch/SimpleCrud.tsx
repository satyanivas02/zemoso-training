import React, { useEffect, useState } from 'react';
import { Box, Button, Typography } from '@mui/material';

const SimpleCrud: React.FC = () => {
  const [data, setData] = useState<string | null>(null);

  // Fetch GET request
  const getData = async () => {
    try {
      const response = await fetch('/data.json'); // Fetching from local JSON file
      const result = await response.json();
      setData(JSON.stringify(result));
    } catch (error) {
      console.error('GET error:', error);
    }
  };

  // Fetch POST request
  const postData = async () => {
    try {
      const newItem = { id: 4, name: 'Item 4' }; 
      const response = await fetch('/data.json', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newItem),
      });
      console.log('POST response:', await response.json());
    } catch (error) {
      console.error('POST error:', error);
    }
  };

  // Fetch PUT request
  const updateData = async () => {
    try {
      const updatedItem = { id: 1, name: 'Updated Item 1' };
      const response = await fetch(`/data.json/${updatedItem.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(updatedItem),
      });
      console.log('PUT response:', await response.json());
    } catch (error) {
      console.error('PUT error:', error);
    }
  };

  // Fetch DELETE request
  const deleteData = async (id: number) => {
    try {
      const response = await fetch(`/data.json/${id}`, {
        method: 'DELETE',
      });
      console.log('DELETE response:', await response.json());
    } catch (error) {
      console.error('DELETE error:', error);
    }
  };

  // Call GET when component mounts
  useEffect(() => {
    getData();
  }, []);

  return (
    <Box sx={{ padding: 3 }}>
      <Typography variant="h4">Simple CRUD Example</Typography>

      {data ? (
        <Box>
          <Typography variant="h6">Fetched Data:</Typography>
          <Typography>{data}</Typography>
        </Box>
      ) : (
        <Typography>Loading...</Typography>
      )}

      <Box sx={{ mt: 2 }}>
        <Button variant="contained" color="primary" onClick={postData}>
          Add Item (POST)
        </Button>
        <Button variant="contained" color="secondary" onClick={updateData} sx={{ mx: 2 }}>
          Update Item 1 (PUT)
        </Button>
        <Button variant="contained" color="error" onClick={() => deleteData(1)}>
          Delete Item 1 (DELETE)
        </Button>
      </Box>
    </Box>
  );
};

export default SimpleCrud;
