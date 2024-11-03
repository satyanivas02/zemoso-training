// import React from 'react';
// import Text from '../atoms/Text';
// import Button from '../atoms/Button';

// interface CardProps {
//   title: string;
//   author: string;
//   time: string;
//   reads: string;
//   status: 'Finished' | 'Read again';
//   image: string; 
// }

// const Card: React.FC<CardProps> = ({ title, author, time, reads, status, image }) => {
//   return (
//     <div style={{ border: '1px solid #E0E0E0', padding: '16px', borderRadius: '8px', marginBottom: '16px' }}>
//       <img src={image} alt={title} style={{ width: '100%', height: 'auto', borderRadius: '8px' }} />
//       <Text variant="subtitle1">{title}</Text>
//       <Text variant="body1">{author}</Text>
//       <Text variant="body1">{`${time} | ${reads}`}</Text>
//       <Button 
//         variant="text"  
//         color="secondary" 
//         style={{ textTransform: 'none' }} 
//       >
//         {status}
//       </Button>
//     </div>
//   );
// };

// export default Card;

// import React from 'react';
// import { Card as MUICard, CardContent, Box } from '@mui/material';
// import Text from '../atoms/Text';
// import Button from '../atoms/Button';

// interface CardProps {
//   title: string;
//   author: string;
//   time: string;
//   reads: string;
//   status: 'Finished' | 'Read again';
//   image: string;
// }

// const Card: React.FC<CardProps> = ({ title, author, time, reads, status, image }) => {
//   return (
//     <MUICard sx={{ border: '1px solid #E0E0E0', borderRadius: '8px', mb: 2 }}>
//       <Box 
//         component="img" 
//         src={image} 
//         alt={title} 
//         sx={{ width: '100%', height: 'auto', borderRadius: '8px' }} 
//       />
//       <CardContent>
//         <Text variant="subtitle1">{title}</Text>
//         <Text variant="body1">{author}</Text>
//         <Text variant="body1">{`${time} | ${reads}`}</Text>
//         <Button variant="text" color="secondary">
//           {status}
//         </Button>
//       </CardContent>
//     </MUICard>
//   );
// };

// export default Card;

import React from 'react';
import { Card as MUICard, CardContent, Box } from '@mui/material';
import Text from '../atoms/Text';
import Button from '../atoms/Button';
import Icon from '../atoms/Icon';
import { ICONS } from '../../constants/icons';

interface CardProps {
  title: string;
  author: string;
  time: string;
  reads: string;
  status: 'Finished' | 'Read again';
  image: string;
  onButtonClick: () => void;
}

const Card: React.FC<CardProps> = ({ title, author, time, reads, status, image, onButtonClick }) => {
  return (
    <MUICard sx={{ 
      border: '1px solid #E0E0E0', 
      borderRadius: '8px', 
      mb: 2, 
      width: '100%',       // Make card width responsive
      maxWidth: '300px'     // Set a max width to reduce size
    }}>
      <Box 
        component="img" 
        src={image} 
        alt={title} 
        sx={{ width: '100%', height: 'auto', borderRadius: '8px' }} 
      />
      <CardContent>
        <Text variant="subtitle1">{title}</Text>
        <Text variant="body1">{author}</Text>

        {/* Icons for time read and number of reads */}
        <Box sx={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', mt: 1 }}>
          <Box sx={{ display: 'flex', alignItems: 'center', paddingRight: '4px' }}> {/* Reduce space between icon and text */}
            <Icon src={ICONS.timeReadIcon} alt="Time Read Icon" />
            <Text variant="body1">{time}</Text>
          </Box>
          <Box sx={{ display: 'flex', alignItems: 'center', paddingLeft: '4px' }}> {/* Reduce space between icon and text */}
            <Icon src={ICONS.usersReadIcon} alt="Users Read Icon" />
            <Text variant="body1">{reads}</Text>
          </Box>
        </Box>

        {/* Button for Finished/Read again */}
        <Box sx={{ display: 'flex', justifyContent: 'center', mt: 2 }}>
          <Button variant="text" color="secondary" onClick={onButtonClick}>
            {status}
          </Button>
        </Box>
      </CardContent>
    </MUICard>
  );
};

export default Card;
