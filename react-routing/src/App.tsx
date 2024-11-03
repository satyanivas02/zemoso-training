import React from 'react';
import './App.css';
import { Box } from '@mui/material';
import { createBrowserRouter, RouterProvider } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import Dashboard from './components/Dashboard';
import Navbar from './components/Navbar';
import ParamComp from './components/ParamComp';
import Courses from './components/Courses';
import MockTest from './components/MockTest';
import Reports from './components/Reports';
import NotFound from './components/NotFound';

const router = createBrowserRouter([
  {
    path: '/',
    element: (
      <Box>
        <Navbar />
        <Home />
      </Box>
    ),
  },
  {
    path: '/about',
    element: (
      <Box>
        <Navbar />
        <About />
      </Box>
    ),
  },
  {
    path: '/dashboard',
    element: (
      <Box>
        <Navbar />
        <Dashboard />
      </Box>
    ),
    children: [
      {
        path: 'courses',
        element: <Courses />,
      },
      {
        path: 'mock-tests',
        element: <MockTest />,
      },
      {
        path: 'reports',
        element: <Reports />,
      },
    ],
  },
  {
    path: '/student/:id',
    element: (
      <Box>
        <Navbar />
        <ParamComp />
      </Box>
    ),
  },
  {
    path: '*',
    element: <NotFound />,
  },
]);

const App: React.FC = () => {
  return (
    <Box>
      <RouterProvider router={router} />
    </Box>
  );
};

export default App;
