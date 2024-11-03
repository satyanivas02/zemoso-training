import axios from 'axios';

const API_URL = 'http://localhost:5000';

// GET: Fetch all users
export const fetchUsers = async () => {
  const response = await axios.get(`${API_URL}/users`);
  return response.data;
};

// POST: Create a new user
export const createUser = async (user: { name: string; email: string }) => {
  const response = await axios.post(`${API_URL}/users`, user);
  return response.data;
};

// PUT: Update an existing user
export const updateUser = async (id: string, updatedData: { name?: string; email?: string }) => {
  const response = await axios.put(`${API_URL}/users/${id}`, updatedData);
  return response.data;
};

// DELETE: Delete a user
export const deleteUser = async (id: string) => {
  await axios.delete(`${API_URL}/users/${id}`);
};
