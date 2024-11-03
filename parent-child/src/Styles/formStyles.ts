import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    mode: 'dark',
    primary: {
      main: '#5b57ff',
    },
    background: {
      default: '#141621',
      paper: '#1E202C',
    },
    text: {
      primary: '#E8E7F0',
      secondary: '#b3b3b3',
    },
  },
  typography: {
    h1: {
      fontSize: '2rem',
      fontWeight: 700,
      fontFamily: 'Gilroy',
      fontStyle: 'normal',
    },
    body1: {
      fontSize: '1rem',
      color: '#b3b3b3',
    },
    button: {
      fontSize: '1rem',
      fontWeight: 500,
      textTransform: 'none',
    },
  },
  components: {
    MuiTextField: {
      styleOverrides: {
        root: {
          backgroundColor: '#2c3b41',
          borderRadius: '8px',
          '& input': {
            color: '#ffffff', 
          },
          '& .MuiInputBase-input::placeholder': {
            color: '#A5A5A6', 
          },
          '& .MuiOutlinedInput-root': {
            '& fieldset': {
              borderColor: '#3b3f5c', 
            },
            '&:hover fieldset': {
              borderColor: '#5b57ff', 
            },
            '&.Mui-focused fieldset': {
              borderColor: '#5b57ff', 
            },
          },
        },
      },
    },
    MuiButton: {
      styleOverrides: {
        root: {
          backgroundColor: '#4b4e54', 
          color: '#A5A5A6', 
          '&:hover': {
            backgroundColor: '#5c5f67', 
          },
        },
        outlined: {
          borderColor: 'transparent', 
        },
      },
    },
  },
});

export default theme;
