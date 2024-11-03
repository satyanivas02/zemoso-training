import React from 'react';
import { NavLink } from 'react-router-dom';
import { AppBar, Toolbar, Button } from '@mui/material';
import './Navbar.css';

const Navbar: React.FC = () => {
  return (
    <AppBar position="static" className='text'>
      <Toolbar>
        <Button color="inherit">
          <NavLink to="/" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Home
          </NavLink>
        </Button>
        <Button color="inherit">
          <NavLink to="/about" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            About
          </NavLink>
        </Button>
        <Button color="inherit">
          <NavLink to="/dashboard" className={({ isActive }) => (isActive ? 'active-link' : '')}>
            Dashboard
          </NavLink>
        </Button>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;
