import React, { useContext } from 'react';
import { ThemeContext } from './ThemeProvider';

const ThemeToggleButton = () => {
  const themeContext = useContext(ThemeContext);

  if (!themeContext) {
    throw new Error('ThemeToggleButton must be used within a ThemeProvider');
  }

  const { theme, toggleTheme } = themeContext;

  return (
    <button onClick={toggleTheme}>
      Current Theme: {theme}
    </button>
  );
};

export default ThemeToggleButton;
