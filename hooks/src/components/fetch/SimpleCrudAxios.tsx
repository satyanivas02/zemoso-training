import React, { useEffect, useState } from 'react';
import { Box, Button, Typography } from '@mui/material';
import axios from 'axios';

interface Item {
  id: number;
  title: string;
  body: string; // Assuming the full object contains a body property as well
}

const API_URL = 'https://jsonplaceholder.typicode.com/posts'; // Fake API endpoint

const SimpleCrudAxios: React.FC = () => {
  const [data, setData] = useState<Item[]>([]); // Store fetched data

  // GET request to fetch data from the API
  const getData = async () => {
    try {
      const response = await axios.get(API_URL);
      setData(response.data); // Set fetched data
      console.log('Fetched Data:', response.data); // Log entire object
    } catch (error) {
      console.error('GET error:', error);
    }
  };

  // POST request to add new item to the API
  const postData = async () => {
    const newItem = { title: `New Item ${data.length + 1}`, body: 'This is a new item body.' };
    try {
      const response = await axios.post(API_URL, newItem);
      setData([...data, response.data]); // Add new item to the state
      console.log('POST success:', response.data); // Log entire object
    } catch (error) {
      console.error('POST error:', error);
    }
  };

  // PUT request to update an item in the API
  const updateData = async (id: number) => {
    const updatedItem = { title: `Updated Item ${id}`, body: `This is the updated body for item ${id}.` };
    try {
      const response = await axios.put(`${API_URL}/${id}`, updatedItem);
      setData(data.map(item => (item.id === id ? response.data : item))); // Update the item in the state
      console.log('PUT success:', response.data); // Log entire object
    } catch (error) {
      console.error('PUT error:', error);
    }
  };

  // DELETE request to remove an item from the API
  const deleteData = async (id: number) => {
    try {
      await axios.delete(`${API_URL}/${id}`);
      setData(data.filter(item => item.id !== id)); // Remove the item from the state
      console.log('DELETE success: deleted item with id', id); // Log the id of deleted item
    } catch (error) {
      console.error('DELETE error:', error);
    }
  };

  // Fetch data when the component mounts
  useEffect(() => {
    getData(); // Trigger GET request on component mount
  }, []);

  return (
    <Box sx={{ padding: 3 }}>
      <Typography variant="h4">CRUD Operations with Axios</Typography>

      {/* Display the fetched data */}
      <Box sx={{ my: 2 }}>
        <Typography variant="h6">Fetched Data:</Typography>
        {data.length > 0 ? (
          <ul>
            {data.slice(0, 5).map(item => (
              <li key={item.id}>
                <Typography variant="body1">
                  <strong>ID:</strong> {item.id}<br />
                  <strong>Title:</strong> {item.title}<br />
                  <strong>Body:</strong> {item.body}<br />
                </Typography>
                <Button
                  variant="contained"
                  color="secondary"
                  sx={{ marginLeft: 2 }}
                  onClick={() => updateData(item.id)}
                >
                  Update
                </Button>
                <Button
                  variant="contained"
                  color="error"
                  sx={{ marginLeft: 2 }}
                  onClick={() => deleteData(item.id)}
                >
                  Delete
                </Button>
              </li>
            ))}
          </ul>
        ) : (
          <Typography>No data available</Typography>
        )}
      </Box>

      {/* Buttons to simulate CRUD operations */}
      <Box sx={{ display: 'flex', gap: 2 }}>
        <Button variant="contained" color="primary" onClick={postData}>
          Add Item (POST)
        </Button>
      </Box>
    </Box>
  );
};

export default SimpleCrudAxios;
