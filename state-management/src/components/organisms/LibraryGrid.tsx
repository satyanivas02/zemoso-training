// import React from 'react';
// import Card from '../molecules/Card';
// import { cardData } from '../../constants/cardData';

// interface LibraryGridProps {
//   currentTab: number;
// }

// const LibraryGrid: React.FC<LibraryGridProps> = ({ currentTab }) => {
//   const data = currentTab === 0 ? cardData.currentlyReading : cardData.finished;

//   return (
//     <div style={{ display: 'flex', gap: '16px', flexWrap: 'wrap' }}>
//       {data.map((book, index) => (
//         <Card
//           key={index}
//           title={book.title}
//           author={book.author}
//           time={book.time}
//           reads={book.reads}
//           image={book.image} // Pass image to the Card component
//           status={currentTab === 0 ? 'Finished' : 'Read again'}
//         />
//       ))}
//     </div>
//   );
// };

// export default LibraryGrid;

// import React from 'react';
// import Card from '../molecules/Card';
// import { cardData } from '../../constants/cardData';
// import { Box } from '@mui/material';

// interface LibraryGridProps {
//   currentTab: number;
// }

// const LibraryGrid: React.FC<LibraryGridProps> = ({ currentTab }) => {
//   const data = currentTab === 0 ? cardData.currentlyReading : cardData.finished;

//   return (
//     <Box display="flex" gap="16px" flexWrap="wrap" >
//       {data.map((book, index) => (
//         <Card
//           key={index}
//           title={book.title}
//           author={book.author}
//           time={book.time}
//           reads={book.reads}
//           image={book.image} // Pass image to the Card component
//           status={currentTab === 0 ? 'Finished' : 'Read again'}
//         />
//       ))}
//     </Box>
//   );
// };

// export default LibraryGrid;

import React from 'react';
import Card from '../molecules/Card';
import { Box } from '@mui/material';

interface LibraryGridProps {
  currentTab: number;
  currentlyReading: any[];
  finished: any[];
  onFinishBook: (book: any) => void;
  onReadAgain: (book: any) => void;
}

const LibraryGrid: React.FC<LibraryGridProps> = ({ currentTab, currentlyReading, finished, onFinishBook, onReadAgain }) => {
  const data = currentTab === 0 ? currentlyReading : finished;

  return (
    <Box display="flex" gap="16px" flexWrap="wrap">
      {data.map((book, index) => (
        <Card
          key={index}
          title={book.title}
          author={book.author}
          time={book.time}
          reads={book.reads}
          image={book.image}
          status={currentTab === 0 ? 'Finished' : 'Read again'}
          onButtonClick={currentTab === 0 ? () => onFinishBook(book) : () => onReadAgain(book)}
        />
      ))}
    </Box>
  );
};

export default LibraryGrid;


