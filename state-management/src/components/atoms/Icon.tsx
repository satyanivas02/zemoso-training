// // import React from 'react';

// // interface IconProps {
// //   src: string;
// //   alt: string;
// // }

// // const Icon: React.FC<IconProps> = ({ src, alt }) => {
// //   return <img src={src} alt={alt} style={{ width: '124px', height: '40px',}} />;
// // };

// // export default Icon;

// import React from 'react';
// import { Box } from '@mui/material';

// interface IconProps {
//   src: string;
//   alt: string;
// }

// const Icon: React.FC<IconProps> = ({ src, alt }) => {
//   return (
//     <Box 
//       component="img"
//       src={src} 
//       alt={alt} 
//       sx={{ width: '124px', height: '40px' }} // Moved inline styles to sx
//     />
//   );
// };

// export default Icon;

import React from 'react';

interface IconProps {
  src: string;
  alt: string;
  width?: string;  // Add width prop
  height?: string; // Add height prop
}

const Icon: React.FC<IconProps> = ({ src, alt, width, height }) => {
  return (
    <img src={src} alt={alt} style={{ width, height }} />  // Apply width and height
  );
};

export default Icon;

