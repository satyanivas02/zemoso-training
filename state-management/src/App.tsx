import React from 'react';
import { ThemeProvider } from '@mui/material/styles';
import { theme } from './theme/theme';
import LibraryPage from './components/template/LibraryPage';

const App: React.FC = () => {
  return (
    <ThemeProvider theme={theme}>
      <LibraryPage />
    </ThemeProvider>
  );
};

export default App;
