import React, { useEffect, useState } from 'react';
import { fetchUsers, createUser, updateUser, deleteUser } from '../services/api';

interface User {
  id: string;
  name: string;
  email: string;
}

const UserList: React.FC = () => {
  const [users, setUsers] = useState<User[]>([]);
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [editingUserId, setEditingUserId] = useState<string | null>(null);

  // Fetch users when the component mounts
  useEffect(() => {
    const loadUsers = async () => {
      try {
        const fetchedUsers = await fetchUsers();
        setUsers(fetchedUsers);
      } catch (error) {
        console.error('Error fetching users:', error);
      }
    };
    loadUsers();
  }, []);

  // Handle form submission for both create and update
  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (editingUserId) {
      // Update user
      try {
        const updatedUser = await updateUser(editingUserId, { name, email });
        setUsers(users.map(user => user.id === editingUserId ? updatedUser : user));
        resetForm();
      } catch (error) {
        console.error('Error updating user:', error);
      }
    } else {
      // Create new user
      try {
        const newUser = await createUser({ name, email });
        setUsers([...users, newUser]);
        resetForm();
      } catch (error) {
        console.error('Error creating user:', error);
      }
    }
  };

  // Reset form fields
  const resetForm = () => {
    setEditingUserId(null);
    setName('');
    setEmail('');
  };

  // Handle deleting a user
  const handleDelete = async (id: string) => {
    try {
      await deleteUser(id);
      setUsers(users.filter(user => user.id !== id));
    } catch (error) {
      console.error('Error deleting user:', error);
    }
  };

  // Handle editing a user
  const handleEdit = (user: User) => {
    setName(user.name);
    setEmail(user.email);
    setEditingUserId(user.id);
  };

  return (
    <div>
      <h1>User List</h1>
      {/* Form for creating/updating user */}
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Name"
          required
        />
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Email"
          required
        />
        <button type="submit">
          {editingUserId ? 'Update User' : 'Create User'}
        </button>
      </form>
     
      {/* Render the user list */}
      <ul>
        {users.map(user => (
          <li key={user.id}>
            {user.name} ({user.email})
            <button onClick={() => handleEdit(user)}>Edit</button>
            <button onClick={() => handleDelete(user.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UserList;
