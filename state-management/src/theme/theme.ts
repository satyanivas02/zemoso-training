// import { createTheme } from '@mui/material/styles';

// export const theme = createTheme({
//   typography: {
//     fontFamily: '"Cera Pro", sans-serif',
//     h1: {
//       fontSize: '36px',
//       fontWeight: 700,
//       color: '#03314B',
//       paddingLeft: '20px',
//     },
//     subtitle1:{
//       fontSize:'18px',
//       fontWeight: 700,
//       color: '#03314B',
//       paddingLeft: '20px',
//     },
//     body1: {
//       fontSize: '1rem',
//       fontWeight: 400,
//       paddingLeft: '20px'
//     },
//   },
//   palette: {
//     primary: {
//       main: '#2ECC71', 
//     },
//     secondary: {
//       main: '#1F51FF',
//     },
//     text: {
//       primary: '#333',
//       secondary: '#A5A5A6',
//     },
//   },
// });

import { createTheme } from '@mui/material/styles';

export const theme = createTheme({
  typography: {
    fontFamily: '"Cera Pro", sans-serif',
    h1: {
      fontSize: '36px',
      fontWeight: 700,
      color: '#03314B',
      paddingLeft: '10px',  // Reduce padding
    },
    subtitle1:{
      fontSize:'18px',
      fontWeight: 700,
      color: '#03314B',
      paddingLeft: '10px',  // Reduce padding
    },
    body1: {
      fontSize: '1rem',
      fontWeight: 400,
      paddingLeft: '10px',  // Reduce padding
    },
  },
  palette: {
    primary: {
      main: '#2ECC71', 
    },
    secondary: {
      main: '#1F51FF',
    },
    text: {
      primary: '#333',
      secondary: '#A5A5A6',
    },
  },
});
